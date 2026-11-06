package dev.autom.examples;

import dev.autom.ApiResponse;
import dev.autom.AutomClient;
import dev.autom.params.GoogleSearchParams;
import java.time.Duration;

/** Run with AUTOM_API_KEY set. */
public final class WaitForJobExample {
  private WaitForJobExample() {}

  public static void main(String[] args) throws Exception {
    AutomClient client = AutomClient.fromEnv();
    ApiResponse submitted = client.googleSearch(GoogleSearchParams.builder().query("web scraping api").isAsync(true).build());
    ApiResponse job = client.waitForJob(
        submitted.json().get("job_id").asText(),
        Duration.ofSeconds(3),
        Duration.ofHours(12),
        progress -> System.out.println(progress.path("status").asText() + " " + progress.path("progress").asInt()));
    System.out.println(job.json().toPrettyString());
  }
}
