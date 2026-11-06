package dev.autom.params;

import dev.autom.AutomParams;
import dev.autom.AutomSerializationException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Parameters for {@code GET / POST /v1/brave/videos}.
 *
 * <p>Generated from the Autom OpenAPI document. Do not edit by hand.
 */
public final class BraveVideosParams implements AutomParams {
  private final Map<String, Object> values;

  private BraveVideosParams(Map<String, Object> values) {
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

  /** Builder for {@link BraveVideosParams}. */
  public static final class Builder {
    private final Map<String, Object> values = new LinkedHashMap<>();

    private Builder() {}

    /** Required. The search query you want to run on Brave Videos. */
    public Builder query(String value) {
      values.put("query", value);
      return this;
    }

    /** Page number for pagination. Default: 1. */
    public Builder page(Number value) {
      values.put("page", value);
      return this;
    }

    /** Country code (e.g. fr, us). Mapped to Brave country. */
    public Builder gl(String value) {
      values.put("gl", value);
      return this;
    }

    /** Language code (e.g. fr, en). Mapped to Brave lang. */
    public Builder hl(String value) {
      values.put("hl", value);
      return this;
    }

    /** SafeSearch: active | off | moderate | strict. Google-style active maps to Brave strict. */
    public Builder safe(String value) {
      values.put("safe", value);
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

    /** Validates required parameters and returns the immutable {@link BraveVideosParams}. */
    public BraveVideosParams build() {
      if (values.get("query") == null) {
        throw new AutomSerializationException("The \"query\" parameter is required.", "query");
      }
      return new BraveVideosParams(java.util.Collections.unmodifiableMap(new LinkedHashMap<>(values)));
    }
  }
}
