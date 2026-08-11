package com.github.weaksloth.dolphins.enums;

/** where the worker group comes from */
public enum WorkerGroupSource {
  CONFIG(1, "config"),
  UI(2, "ui");

  private final int code;
  private final String desc;

  WorkerGroupSource(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public int getCode() {
    return code;
  }

  public String getDesc() {
    return desc;
  }
}
