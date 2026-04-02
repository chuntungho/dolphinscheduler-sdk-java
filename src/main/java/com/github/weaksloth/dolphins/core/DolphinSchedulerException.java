package com.github.weaksloth.dolphins.core;

/** Dolphin Scheduler Client Exception */
public class DolphinSchedulerException extends RuntimeException {
  private int statusCode;
  private String responseBody;

  public DolphinSchedulerException(String message) {
    super(message);
  }

  public DolphinSchedulerException(String message, Throwable cause) {
    super(message, cause);
  }

  public DolphinSchedulerException(String message, int statusCode, String responseBody) {
    super(message);
    this.statusCode = statusCode;
    this.responseBody = responseBody;
  }

  public DolphinSchedulerException(
      String message, int statusCode, String responseBody, Throwable cause) {
    super(message, cause);
    this.statusCode = statusCode;
    this.responseBody = responseBody;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public String getResponseBody() {
    return responseBody;
  }

  @Override
  public String toString() {
    return "DolphinSchedulerException{"
        + "statusCode="
        + statusCode
        + ", responseBody='"
        + responseBody
        + '\''
        + ", message='"
        + getMessage()
        + '\''
        + '}';
  }
}
