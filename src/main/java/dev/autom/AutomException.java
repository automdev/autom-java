package dev.autom;

/** Base class for every SDK-defined exception. */
public class AutomException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  /** Creates the exception. */
  public AutomException(String message, Throwable cause) {
    super(message, cause);
  }
}
