package dev.autom;

/** The request failed before a complete HTTP response was received (network error, timeout). */
public final class AutomTransportException extends AutomException {
  private static final long serialVersionUID = 1L;

  /** Creates the exception. */
  public AutomTransportException(String message, Throwable cause) {
    super(message, cause);
  }
}
