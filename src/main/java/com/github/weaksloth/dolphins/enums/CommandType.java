package com.github.weaksloth.dolphins.enums;

import java.util.HashMap;
import java.util.Map;

/** command types */
public enum CommandType {

  /**
   * command types 0 start a new workflow 1 start a new workflow from current nodes 2 recover
   * tolerance fault workflow 3 recover suspended workflow 4 start workflow from failure task nodes
   * 5 complement data 6 start a new workflow from scheduler 7 repeat running a workflow 8 pause a
   * workflow 9 stop a workflow 11 recover serial wait 12 start a task node in a workflow instance
   */
  START_PROCESS(0, "start a new workflow"),
  START_CURRENT_TASK_PROCESS(1, "start a new workflow from current nodes"),
  RECOVER_TOLERANCE_FAULT_PROCESS(2, "recover fault tolerance workflow instance"),
  RECOVER_SUSPENDED_PROCESS(3, "recover suspended workflow instance"),
  START_FAILURE_TASK_PROCESS(4, "recover workflow instance from failure tasks"),
  COMPLEMENT_DATA(5, "complement data"),
  SCHEDULER(6, "start a new workflow from scheduler"),
  REPEAT_RUNNING(7, "repeat running a workflow"),
  PAUSE(8, "pause a workflow"),
  STOP(9, "stop a workflow"),
  RECOVER_SERIAL_WAIT(11, "recover serial wait"),
  EXECUTE_TASK(12, "start a task node in a workflow instance"),
  DYNAMIC_GENERATION(13, "dynamic generation"),
  ;

  CommandType(int code, String descp) {
    this.code = code;
    this.descp = descp;
  }

  private final int code;
  private final String descp;

  public int getCode() {
    return code;
  }

  public String getDescp() {
    return descp;
  }

  private static final Map<Integer, CommandType> COMMAND_TYPE_MAP = new HashMap<>();

  static {
    for (CommandType commandType : CommandType.values()) {
      COMMAND_TYPE_MAP.put(commandType.code, commandType);
    }
  }

  public static CommandType of(Integer status) {
    if (COMMAND_TYPE_MAP.containsKey(status)) {
      return COMMAND_TYPE_MAP.get(status);
    }
    throw new IllegalArgumentException("invalid status : " + status);
  }
}
