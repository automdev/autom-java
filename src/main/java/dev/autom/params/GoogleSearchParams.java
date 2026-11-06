package dev.autom.params;

import dev.autom.AutomParams;
import dev.autom.AutomSerializationException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Parameters for {@code GET / POST /v1/google/search}.
 *
 * <p>Generated from the Autom OpenAPI document. Do not edit by hand.
 */
public final class GoogleSearchParams implements AutomParams {
  private final Map<String, Object> values;

  private GoogleSearchParams(Map<String, Object> values) {
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

  /** Builder for {@link GoogleSearchParams}. */
  public static final class Builder {
    private final Map<String, Object> values = new LinkedHashMap<>();

    private Builder() {}

    /** Required. The search query you want to run on Google (supports advanced operators like site:, inurl:, intitle:). */
    public Builder query(String value) {
      values.put("query", value);
      return this;
    }

    /** Advanced search filters string (e.g. time ranges: qdr:h last hour, qdr:d last day, qdr:w last week, qdr:m last month, qdr:y last year). */
    public Builder tbs(String value) {
      values.put("tbs", value);
      return this;
    }

    /** Adult content filter. active enables Google SafeSearch; off disables it. Omit to use Google default. */
    public Builder safe(String value) {
      values.put("safe", value);
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

    /** Country to use for the Google search. Two-letter country code (e.g. us for the United States, uk for United Kingdom, or fr for France). */
    public Builder gl(String value) {
      values.put("gl", value);
      return this;
    }

    /** Language to use for the Google search. Two or three-letter language code (e.g. en, es, fr), optionally followed by a region code (e.g. en-gb, es-419). */
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

    /** Page number / offset used for pagination. Default: 1. */
    public Builder page(Number value) {
      values.put("page", value);
      return this;
    }

    /** Maximum number of results to return per page (deprecated). Default: 10. */
    public Builder num(Number value) {
      values.put("num", value);
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

    /** Validates required parameters and returns the immutable {@link GoogleSearchParams}. */
    public GoogleSearchParams build() {
      if (values.get("query") == null) {
        throw new AutomSerializationException("The \"query\" parameter is required.", "query");
      }
      return new GoogleSearchParams(java.util.Collections.unmodifiableMap(new LinkedHashMap<>(values)));
    }
  }
}
