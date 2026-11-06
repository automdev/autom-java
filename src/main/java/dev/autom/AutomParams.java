package dev.autom;

import java.util.Map;

/** Parameters of one endpoint, in wire order. Implemented by every class in {@code dev.autom.params}. */
public interface AutomParams {
  /** Wire name to value; null values are omitted from requests. */
  Map<String, Object> toMap();
}
