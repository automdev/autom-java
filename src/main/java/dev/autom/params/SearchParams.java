package dev.autom.params;

import dev.autom.AutomParams;
import dev.autom.AutomSerializationException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Parameters for {@code GET / POST /v1/search}.
 *
 * <p>Generated from the Autom OpenAPI document. Do not edit by hand.
 */
public final class SearchParams implements AutomParams {
  private final Map<String, Object> values;

  private SearchParams(Map<String, Object> values) {
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

  /** Builder for {@link SearchParams}. */
  public static final class Builder {
    private final Map<String, Object> values = new LinkedHashMap<>();

    private Builder() {}

    /** Required. Search query. */
    public Builder query(String value) {
      values.put("query", value);
      return this;
    }

    /** Engine order. Default auto tries google, brave, bing, duckduckgo, yahoo, then baidu. A comma-separated list is followed as given. ddg and duck mean duckduckgo. Unknown names are ignored. Default: "auto". */
    public Builder engines(String value) {
      values.put("engines", value);
      return this;
    }

    /** Country code. Defaults to us when omitted. For example us, fr, gb, de. */
    public Builder gl(String value) {
      values.put("gl", value);
      return this;
    }

    /** Language code. Defaults to en when omitted. For example en, fr, de. */
    public Builder hl(String value) {
      values.put("hl", value);
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

    /** Validates required parameters and returns the immutable {@link SearchParams}. */
    public SearchParams build() {
      if (values.get("query") == null) {
        throw new AutomSerializationException("The \"query\" parameter is required.", "query");
      }
      return new SearchParams(java.util.Collections.unmodifiableMap(new LinkedHashMap<>(values)));
    }
  }
}
