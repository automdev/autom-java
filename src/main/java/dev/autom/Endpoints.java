package dev.autom;

import java.util.List;
import java.util.Map;

/**
 * Path, methods, response kind and parameter names of every documented operation.
 *
 * <p>Generated from the Autom OpenAPI document. Do not edit by hand.
 */
public final class Endpoints {
  private Endpoints() {}

  /** One documented operation. */
  public record Endpoint(String path, List<String> methods, boolean json, List<String> required) {}

  /** Every documented operation keyed by its snake_case name. */
  public static final Map<String, Endpoint> ALL = Map.ofEntries(
      Map.entry("bing_search", new Endpoint("/v1/bing/search", List.of("GET", "POST"), true, List.of("query"))),
      Map.entry("brave_images", new Endpoint("/v1/brave/images", List.of("GET", "POST"), true, List.of("query"))),
      Map.entry("brave_search", new Endpoint("/v1/brave/search", List.of("GET", "POST"), true, List.of("query"))),
      Map.entry("brave_videos", new Endpoint("/v1/brave/videos", List.of("GET", "POST"), true, List.of("query"))),
      Map.entry("duckduckgo_search", new Endpoint("/v1/duckduckgo/search", List.of("GET", "POST"), true, List.of("query"))),
      Map.entry("finder_google_countries", new Endpoint("/v1/finder/google-countries", List.of("GET"), true, List.of("query"))),
      Map.entry("finder_google_languages", new Endpoint("/v1/finder/google-languages", List.of("GET"), true, List.of("query"))),
      Map.entry("finder_google_locations", new Endpoint("/v1/finder/google-locations", List.of("GET"), true, List.of("query"))),
      Map.entry("google_images", new Endpoint("/v1/google/images", List.of("GET", "POST"), true, List.of("query"))),
      Map.entry("google_jobs", new Endpoint("/v1/google/jobs", List.of("GET", "POST"), true, List.of("query"))),
      Map.entry("google_maps", new Endpoint("/v1/google/maps", List.of("GET", "POST"), true, List.of("query"))),
      Map.entry("google_news", new Endpoint("/v1/google/news", List.of("GET", "POST"), true, List.of("query"))),
      Map.entry("google_search", new Endpoint("/v1/google/search", List.of("GET", "POST"), true, List.of("query"))),
      Map.entry("google_search_ai", new Endpoint("/v1/google/search/ai", List.of("GET", "POST"), true, List.of("query"))),
      Map.entry("google_search_autocomplete", new Endpoint("/v1/google/search/autocomplete", List.of("GET", "POST"), true, List.of("query"))),
      Map.entry("google_search_light", new Endpoint("/v1/google/search/light", List.of("GET", "POST"), true, List.of("query"))),
      Map.entry("google_shopping", new Endpoint("/v1/google/shopping", List.of("GET", "POST"), true, List.of("query"))),
      Map.entry("google_videos", new Endpoint("/v1/google/videos", List.of("GET", "POST"), true, List.of("query", "page"))),
      Map.entry("jobs", new Endpoint("/v1/jobs/{id}", List.of("GET"), true, List.of("id"))),
      Map.entry("search", new Endpoint("/v1/search", List.of("GET", "POST"), true, List.of("query"))),
      Map.entry("stats", new Endpoint("/v1/stats", List.of("GET"), true, List.of())),
      Map.entry("usage", new Endpoint("/v1/usage", List.of("GET"), true, List.of())),
      Map.entry("yahoo_search", new Endpoint("/v1/yahoo/search", List.of("GET", "POST"), true, List.of("query")))
  );
}
