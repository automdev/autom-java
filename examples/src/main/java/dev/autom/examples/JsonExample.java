package dev.autom.examples;

import dev.autom.ApiResponse;
import dev.autom.AutomClient;
import dev.autom.params.GoogleSearchParams;

/** Run with AUTOM_API_KEY set. */
public final class JsonExample {
  private JsonExample() {}

  public static void main(String[] args) throws Exception {
    AutomClient client = AutomClient.fromEnv();
    ApiResponse response = client.googleSearch(GoogleSearchParams.builder().query("web scraping api").build());
    System.out.println(response.json().toPrettyString());
  }
}
