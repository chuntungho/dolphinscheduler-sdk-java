package com.github.weaksloth.dolphins.enums;

import java.util.HashMap;

/** audit model type, replaces the AuditResourceType of the older dolphin scheduler version */
public enum AuditModelType {
  PROJECT("Project", null),
  WORKFLOW("Workflow", PROJECT),
  WORKFLOW_INSTANCE("WorkflowInstance", WORKFLOW),
  TASK("Task", WORKFLOW),
  TASK_INSTANCE("TaskInstance", TASK),
  SCHEDULE("Schedule", WORKFLOW),

  RESOURCE("Resource", null),
  FOLDER("Folder", RESOURCE),
  FILE("File", FOLDER),
  TASK_GROUP("TaskGroup", RESOURCE),

  DATASOURCE("Datasource", null),

  SECURITY("Security", null),
  TENANT("Tenant", SECURITY),
  USER("User", SECURITY),
  ALARM_GROUP("AlarmGroup", SECURITY),
  ALARM_INSTANCE("AlarmInstance", SECURITY),
  WORKER_GROUP("WorkerGroup", SECURITY),
  YARN_QUEUE("YarnQueue", SECURITY),
  ENVIRONMENT("Environment", SECURITY),
  CLUSTER("Cluster", SECURITY),
  K8S_NAMESPACE("K8sNamespace", SECURITY),
  TOKEN("Token", SECURITY),
  ;

  private final String name;
  private final AuditModelType parentType;

  private static final HashMap<String, AuditModelType> AUDIT_MODEL_MAP = new HashMap<>();

  static {
    for (AuditModelType auditModelType : values()) {
      AUDIT_MODEL_MAP.put(auditModelType.name, auditModelType);
    }
  }

  AuditModelType(String name, AuditModelType parentType) {
    this.name = name;
    this.parentType = parentType;
  }

  public static AuditModelType of(String name) {
    if (AUDIT_MODEL_MAP.containsKey(name)) {
      return AUDIT_MODEL_MAP.get(name);
    }
    throw new IllegalArgumentException("invalid audit model type " + name);
  }

  public String getName() {
    return name;
  }

  public AuditModelType getParentType() {
    return parentType;
  }
}
