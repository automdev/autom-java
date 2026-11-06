package dev.autom.params;

import dev.autom.AutomParams;
import dev.autom.AutomSerializationException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Parameters for {@code GET / POST /v1/google/jobs}.
 *
 * <p>Generated from the Autom OpenAPI document. Do not edit by hand.
 */
public final class GoogleJobsParams implements AutomParams {
  private final Map<String, Object> values;

  private GoogleJobsParams(Map<String, Object> values) {
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

  /** Builder for {@link GoogleJobsParams}. */
  public static final class Builder {
    private final Map<String, Object> values = new LinkedHashMap<>();

    private Builder() {}

    /** Required. The job search query to run on Google Jobs (e.g. developer, barista new york). */
    public Builder query(String value) {
      values.put("query", value);
      return this;
    }

    /** Advanced search filters string for Google Jobs (encoded filter chips). */
    public Builder uds(String value) {
      values.put("uds", value);
      return this;
    }

    /** Search radius in kilometers. Does not strictly limit the radius, but influences result proximity. */
    public Builder lrad(Number value) {
      values.put("lrad", value);
      return this;
    }

    /** Filter results by work type. Set to 1 to filter for work from home / remote jobs. */
    public Builder ltype(Number value) {
      values.put("ltype", value);
      return this;
    }

    /** Human-readable location to originate the search from (e.g. New York, NY, Paris, France). If several locations match, the most popular one is used. Note: location and uule cannot be used together. */
    public Builder location(String value) {
      values.put("location", value);
      return this;
    }

    /** Google encoded location parameter. Use for precise geo targeting. Note: uule and location cannot be used together. */
    public Builder uule(String value) {
      values.put("uule", value);
      return this;
    }

    /** Google domain to use for the search. Defaults to google.com. Default: "google.com". */
    public Builder googleDomain(String value) {
      values.put("google_domain", value);
      return this;
    }

    /** Country to use for the Google search. Two-letter country code (e.g. us for the United States, uk for United Kingdom, or fr for France). Default: "us". */
    public Builder gl(String value) {
      values.put("gl", value);
      return this;
    }

    /** Language to use for the Google search. Two or three-letter language code (e.g. en, es, fr), optionally followed by a region code (e.g. en-gb, es-419). Default: "en". */
    public Builder hl(String value) {
      values.put("hl", value);
      return this;
    }

    /** Limit results to one or more countries. Use country{XX} with | as delimiter (e.g. countryFR|countryDE). */
    public Builder cr(String value) {
      values.put("cr", value);
      return this;
    }

    /** Limit results to one or more languages. Use lang_{xx} with | as delimiter (e.g. lang_fr|lang_de). */
    public Builder lr(String value) {
      values.put("lr", value);
      return this;
    }

    /** Token to fetch the next page of results. Returned in the serpapi_pagination.next_page_token field of the previous response. */
    public Builder nextPageToken(String value) {
      values.put("next_page_token", value);
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

    /** Validates required parameters and returns the immutable {@link GoogleJobsParams}. */
    public GoogleJobsParams build() {
      if (values.get("query") == null) {
        throw new AutomSerializationException("The \"query\" parameter is required.", "query");
      }
      return new GoogleJobsParams(java.util.Collections.unmodifiableMap(new LinkedHashMap<>(values)));
    }
  }
}
