package dev.autom.params;

import dev.autom.AutomParams;
import dev.autom.AutomSerializationException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Parameters for {@code GET / POST /v1/google/maps}.
 *
 * <p>Generated from the Autom OpenAPI document. Do not edit by hand.
 */
public final class GoogleMapsParams implements AutomParams {
  private final Map<String, Object> values;

  private GoogleMapsParams(Map<String, Object> values) {
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

  /** Builder for {@link GoogleMapsParams}. */
  public static final class Builder {
    private final Map<String, Object> values = new LinkedHashMap<>();

    private Builder() {}

    /** Required. Search query for Google Maps (e.g. business type, brand, or place name). */
    public Builder query(String value) {
      values.put("query", value);
      return this;
    }

    /** Page number for pagination (1 = first page). Default: 1. */
    public Builder page(Number value) {
      values.put("page", value);
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

    /** Map center / geo hint in Google format (e.g. &#64;43.5131985,1.4600501,60m). Helps focus results around a coordinate and zoom radius. */
    public Builder ll(String value) {
      values.put("ll", value);
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

    /** Validates required parameters and returns the immutable {@link GoogleMapsParams}. */
    public GoogleMapsParams build() {
      if (values.get("query") == null) {
        throw new AutomSerializationException("The \"query\" parameter is required.", "query");
      }
      return new GoogleMapsParams(java.util.Collections.unmodifiableMap(new LinkedHashMap<>(values)));
    }
  }
}
