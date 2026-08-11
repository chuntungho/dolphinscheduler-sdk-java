package com.github.weaksloth.dolphins.enums;

import java.util.HashMap;

/** Audit Operation type */
public enum AuditOperationType {
  CREATE("Create"),
  UPDATE("Update"),
  BATCH_DELETE("BatchDelete"),
  BATCH_START("BatchStart"),
  DELETE("Delete"),
  CLOSE("Close"),

  RELEASE("Release"),
  ONLINE("Online"),
  OFFLINE("Offline"),

  RESUME_PAUSE("ResumePause"),
  RESUME_FAILURE("ResumeFailure"),

  IMPORT("Import"),
  EXPORT("Export"),

  EXECUTE("Execute"),
  START("Start"),
  MODIFY("Modify"),
  RUN("Run"),
  RERUN("Rerun"),
  BATCH_RERUN("BatchRerun"),
  STOP("Stop"),
  KILL("Kill"),
  PAUSE("Pause"),
  MOVE("Move"),

  SWITCH_STATUS("SwitchStatus"),
  SWITCH_VERSION("SwitchVersion"),
  DELETE_VERSION("DeleteVersion"),
  FORCE_SUCCESS("ForceSuccess"),
  RENAME("Rename"),
  UPLOAD("Upload"),
  AUTHORIZE("Authorize"),
  UN_AUTHORIZE("UnAuthorize"),
  COPY("Copy"),
  ;

  private final String name;

  private static final HashMap<String, AuditOperationType> AUDIT_OPERATION_MAP = new HashMap<>();

  static {
    for (AuditOperationType operationType : AuditOperationType.values()) {
      AUDIT_OPERATION_MAP.put(operationType.name, operationType);
    }
  }

  AuditOperationType(String name) {
    this.name = name;
  }

  public static AuditOperationType of(String name) {
    if (AUDIT_OPERATION_MAP.containsKey(name)) {
      return AUDIT_OPERATION_MAP.get(name);
    }
    throw new IllegalArgumentException("invalid audit operation type code " + name);
  }

  public String getName() {
    return name;
  }
}
