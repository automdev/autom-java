package dev.autom.params;

import dev.autom.AutomParams;
import dev.autom.AutomSerializationException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Parameters for {@code GET / POST /v1/bing/search}.
 *
 * <p>Generated from the Autom OpenAPI document. Do not edit by hand.
 */
public final class BingSearchParams implements AutomParams {
  private final Map<String, Object> values;

  private BingSearchParams(Map<String, Object> values) {
    this.values = values;
  }

  /** Returns a new builder. */
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Map<String, Object> toMap() {
    return values;
  }

  /** Builder for {@link BingSearchParams}. */
  public static final class Builder {
    private final Map<String, Object> values = new LinkedHashMap<>();

    private Builder() {}

    /** Required. The search query you want to run on Bing. */
    public Builder query(String value) {
      values.put("query", value);
      return this;
    }

    /** Page number for pagination (1 = first page). Default: 1. */
    public Builder page(Number value) {
      values.put("page", value);
      return this;
    }

    /** Number of results per page (e.g. 10, 20, 50). This value is a suggestion. Default: 10. */
    public Builder num(Number value) {
      values.put("num", value);
      return this;
    }

    /** Search origin location (e.g. city). */
    public Builder location(String value) {
      values.put("location", value);
      return this;
    }

    /** GPS latitude for the search origin. */
    public Builder lat(Number value) {
      values.put("lat", value);
      return this;
    }

    /** GPS longitude for the search origin. */
    public Builder lon(Number value) {
      values.put("lon", value);
      return this;
    }

    /** Market code where results come from (e.g. en-US). Cannot be used together with cc. */
    public Builder mkt(String value) {
      values.put("mkt", value);
      return this;
    }

    /** Country code to search from (2-letter ISO 3166-1). Cannot be used together with mkt. */
    public Builder cc(String value) {
      values.put("cc", value);
      return this;
    }

    /** Comma-separated list of fields to keep in the response, with dot notation for nested fields (e.g. name,location.city). Does not change the credit cost. */
    public Builder fields(String value) {
      values.put("fields", value);
      return this;
    }

    /** Process the request asynchronously: the response is a job_id to poll on /v1/jobs/{id} (see waitForJob). Default: false. */
    public Builder isAsync(Boolean value) {
      values.put("is_async", value);
      return this;
    }

    /** Return HTTP 200 even when an error occurs; the error is then in the response body. Default: false. */
    public Builder softFail(Boolean value) {
      values.put("soft_fail", value);
      return this;
    }

    /** Validates required parameters and returns the immutable {@link BingSearchParams}. */
    public BingSearchParams build() {
      if (values.get("query") == null) {
        throw new AutomSerializationException("The \"query\" parameter is required.", "query");
      }
      return new BingSearchParams(java.util.Collections.unmodifiableMap(new LinkedHashMap<>(values)));
    }
  }
}
