package dev.autom;

/** The client configuration is missing or unusable. */
public final class AutomConfigurationException extends AutomException {
  private static final long serialVersionUID = 1L;

  /** Creates the exception. */
  public AutomConfigurationException(String message) {
    super(message, null);
  }

  /** Creates the exception with a cause. */
  public AutomConfigurationException(String message, Throwable cause) {
    super(message, cause);
  }
}
