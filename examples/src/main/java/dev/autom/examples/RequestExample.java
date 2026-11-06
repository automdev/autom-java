package dev.autom.examples;

import dev.autom.ApiResponse;
import dev.autom.AutomApiException;
import dev.autom.AutomClient;
import java.util.Map;

/** Run with AUTOM_API_KEY set. */
public final class RequestExample {
  private RequestExample() {}

  public static void main(String[] args) throws Exception {
    AutomClient client = AutomClient.fromEnv();
    try {
      ApiResponse response = client.request("GET", "/v1/usage", Map.of());
      System.out.println(response.text());
    } catch (AutomApiException e) {
      System.err.println("HTTP " + e.status() + ": " + e.getMessage());
    }
  }
}
