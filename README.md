# Autom Java SDK

The official Java SDK for the [Autom](https://www.autom.dev) SERP API.

Google, Bing and Brave search results as structured JSON — web, maps, news, shopping, images, jobs and AI Mode.

The SDK exposes **23 typed methods**, one per documented endpoint, each with a parameter builder, plus a generic `request()`. It uses `java.net.http.HttpClient` and Jackson.

## Requirements

- Java 17 or newer

## Installation

The SDK is not on Maven Central. Build it from source, which installs it in your local Maven repository:

```sh
git clone https://github.com/automdev/autom-java.git
cd autom-java
mvn -q install -DskipTests
```

Then add it to your project. Maven:

```xml
<dependency>
  <groupId>dev.autom</groupId>
  <artifactId>autom</artifactId>
  <version>0.1.0</version>
</dependency>
```

Gradle, with `mavenLocal()` in your repositories:

```kotlin
implementation("dev.autom:autom:0.1.0")
```

## Get your API key

[Sign up for Autom](https://app.autom.dev/register) or sign in, then copy your API key from the [dashboard](https://app.autom.dev). `AutomClient.fromEnv()` reads the `AUTOM_API_KEY` environment variable.

## Quick start

```java
import dev.autom.ApiResponse;
import dev.autom.AutomClient;
import dev.autom.params.GoogleSearchParams;

AutomClient client = AutomClient.fromEnv();
ApiResponse response = client.googleSearch(GoogleSearchParams.builder().query("web scraping api").build());
System.out.println(response.json().toPrettyString());
```

Parameter builders mirror the [API reference](https://docs.autom.dev); `build()` checks required parameters. Use `response.as(MyType.class)` to map the JSON onto your own types.

## Async jobs

Any call accepts `is_async: true` (useful past the 60-second server limit): the response is then a `job_id`. `waitForJob` polls `GET /v1/jobs/{id}` until a terminal status (`CompletedJob`, `Error`, `NotFound`, `BadRequest`):

```java
ApiResponse submitted = client.googleSearch(GoogleSearchParams.builder().query("web scraping api").isAsync(true).build());
ApiResponse job = client.waitForJob(
    submitted.json().get("job_id").asText(),
    Duration.ofSeconds(3),
    Duration.ofHours(12),
    progress -> System.out.println(progress.path("status").asText() + " " + progress.path("progress").asInt()));
```

## GET or POST

Methods use GET when the endpoint supports it (query string). POST sends the same parameters as JSON:

```java
client.bingSearch(BingSearchParams.builder().query("test").build(), RequestOptions.method("POST"));
```

## Any endpoint

```java
ApiResponse response = client.request("GET", "/v1/usage", Map.of());
```

## Errors

```java
try {
  client.googleSearch(GoogleSearchParams.builder().query("web scraping api").build());
} catch (AutomApiException e) {
  System.err.println(e.status() + ": " + e.getMessage());
}
```

| Exception | When |
| --- | --- |
| `AutomConfigurationException` | Missing API key, invalid options or unsupported method. |
| `AutomSerializationException` | A required parameter is missing or a value can't be sent. |
| `AutomTransportException` | Network failure, timeout or interruption. |
| `AutomApiException` | Non-2xx status (`status()`, `errorMessage()`, `responseBody()`, `rawResponse()`). |
| `AutomResponseDecodingException` | A success response could not be decoded. |

All of them extend the unchecked `AutomException`.

## Retries

Requests are retried up to 3 times after a network error, a `408`, `500`, `502`, `503` or `504`, or a rate limit — which the API returns as `401` (or `429`) with a `Rate limit exceeded` message. Per-key quota errors (`…: quota daily`) are not retried, nor are `400`, `402`, `404` or client-side timeouts. The delay starts at 1 second and grows 1.5× per retry (capped at 30 seconds); a `Retry-After` header wins.

```java
AutomClient client = AutomClient.builder().maxRetries(5).retryDelay(Duration.ofMillis(500)).build();
client.googleSearch(GoogleSearchParams.builder().query("web scraping api").build(), RequestOptions.builder().maxRetries(0).build()); // one request without retries
```

## Batch requests

`batch()` runs a function per item on 10 threads (`concurrency`) and returns one `BatchResult` per item, in input order. A failing item never stops the others.

```java
List<String> inputs = List.of("web scraping api", "serp api", "rank tracker");
List<BatchResult<ApiResponse>> results = client.batch(inputs, 5, value ->
    client.googleSearch(GoogleSearchParams.builder().query(value).build()));
for (BatchResult<ApiResponse> result : results) {
  if (result.ok()) {
    System.out.println(result.value().json());
  } else {
    System.err.println(inputs.get(result.index()) + ": " + result.error().getMessage());
  }
}
```

| Constant | Default | Description |
| --- | --- | --- |
| `AutomClient.DEFAULT_CONCURRENCY` | `10` | Tasks run at the same time by batch |
| `AutomClient.DEFAULT_TIMEOUT` | `Duration.ofSeconds(120)` | Request timeout |
| `AutomClient.MAX_RETRIES` | `3` | Retry attempts after a network error, a 408/5xx or a rate limit |
| `AutomClient.RETRY_BACKOFF_FACTOR` | `1.5` | Exponential backoff multiplier |
| `AutomClient.DEFAULT_RETRY_DELAY` | `Duration.ofSeconds(1)` | Delay before the first retry |

## Configuration

```java
AutomClient client = AutomClient.builder()
    .apiKey(System.getenv("AUTOM_API_KEY"))
    .timeout(Duration.ofSeconds(60)) // default 120 s, null disables
    .header("X-Trace", "abc")
    .transport(AutomTransport.fromHttpClient(myHttpClient)) // optional
    .build();
```

## Endpoints

23 methods, generated from the [OpenAPI document](https://app.autom.dev/openapi).

| Method | HTTP | Description |
| --- | --- | --- |
| `bingSearch()` | GET / POST `/v1/bing/search` | Query Bing Search via API and retrieve structured organic results (title, link, snippet, position). |
| `braveImages()` | GET / POST `/v1/brave/images` | Search Brave Images via API and retrieve structured image results with pagination and SafeSearch. |
| `braveSearch()` | GET / POST `/v1/brave/search` | Search Brave Search via API and retrieve structured organic results with pagination. |
| `braveVideos()` | GET / POST `/v1/brave/videos` | Search Brave Videos via API and retrieve structured video results with pagination and SafeSearch. |
| `duckduckgoSearch()` | GET / POST `/v1/duckduckgo/search` | Query DuckDuckGo via API and retrieve structured organic results with region and language. |
| `finderGoogleCountries()` | GET `/v1/finder/google-countries` | Search Google countries and retrieve country codes (free Finder endpoint). |
| `finderGoogleLanguages()` | GET `/v1/finder/google-languages` | Search Google languages and retrieve language codes (free Finder endpoint). |
| `finderGoogleLocations()` | GET `/v1/finder/google-locations` | Find supported Google locations and retrieve location IDs and country codes (free endpoint). |
| `googleImages()` | GET / POST `/v1/google/images` | Search Google Images via API and retrieve image results (URLs, titles, sources, dimensions). |
| `googleJobs()` | GET / POST `/v1/google/jobs` | Scrape Google Jobs results via API and retrieve structured job listings with title, company, location, and pagination. |
| `googleMaps()` | GET / POST `/v1/google/maps` | Search Google Maps via API and retrieve structured place results (address, website, phone). |
| `googleNews()` | GET / POST `/v1/google/news` | Search Google News via API and retrieve structured news results with pagination. |
| `googleSearch()` | GET / POST `/v1/google/search` | Scrape Google Search results via API and retrieve structured SERP data with pagination. |
| `googleSearchAi()` | GET / POST `/v1/google/search/ai` | Query Google AI Mode via API. JSON with text_blocks, references, and shopping_results. |
| `googleSearchAutocomplete()` | GET / POST `/v1/google/search/autocomplete` | Get Google Search autocomplete suggestions via API for a given query. |
| `googleSearchLight()` | GET / POST `/v1/google/search/light` | Scrape lightweight Google Search results via API: fast, cost-efficient, organic results only. |
| `googleShopping()` | GET / POST `/v1/google/shopping` | Scrape Google Shopping results via API and retrieve structured product listings with prices, ratings, and merchant data. |
| `googleVideos()` | GET / POST `/v1/google/videos` | Search Google Videos via API and retrieve structured video results with metadata. |
| `jobs()` | GET `/v1/jobs/{id}` | Poll the status, progress (0–100) and result of a job started with is_async=true. Polling is free. Poll until status is terminal: Completed… |
| `search()` | GET / POST `/v1/search` | One call walks engines in order and returns the first organic results. engines=auto tries Google, then Brave, Bing, DuckDuckGo, Yahoo, and… |
| `stats()` | GET `/v1/stats` | Infrastructure health for an engine or endpoint over the last hour. Not scoped to your account or tenant. Enabled per account: HTTP 403 mea… |
| `usage()` | GET `/v1/usage` | Retrieve real-time usage statistics and credit balance for your Autom account. |
| `yahooSearch()` | GET / POST `/v1/yahoo/search` | Query Yahoo via API and retrieve structured organic results with country and language. |

## All Autom SDKs

| SDK | Package | Install |
| --- | --- | --- |
| Node.js | [`@automdev/sdk`](https://www.npmjs.com/package/@automdev/sdk) | `npm install @automdev/sdk` |
| Python | [`automdev`](https://pypi.org/project/automdev/) | `pip install automdev` |
| Go | [`autom-go`](https://pkg.go.dev/github.com/automdev/autom-go) | `go get github.com/automdev/autom-go` |
| .NET | [`Autom`](https://www.nuget.org/packages/Autom) | `dotnet add package Autom` |
| Ruby | [`autom`](https://rubygems.org/gems/autom) | `gem install autom` |
| PHP | [`autom/sdk`](https://packagist.org/packages/autom/sdk) | `composer require autom/sdk` |
| Java | [`autom-java`](https://github.com/automdev/autom-java) | build from source, see its README |
| CLI | [`@automdev/cli`](https://www.npmjs.com/package/@automdev/cli) | `npm install -g @automdev/cli` |
| MCP server | [`@automdev/mcp`](https://www.npmjs.com/package/@automdev/mcp) | `npx -y @automdev/mcp` |

## License

MIT — see [LICENSE](LICENSE).
