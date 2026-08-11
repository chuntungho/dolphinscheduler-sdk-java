package com.github.weaksloth.dolphins.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.NonNull;

public enum WorkflowExecutionStatus {

  // In order to compatible with the old value, the code is not consecutive
  SUBMITTED_SUCCESS(0, "submit success", false, false, false),
  RUNNING_EXECUTION(1, "running", true, true, false),
  READY_PAUSE(2, "ready pause", true, true, false),
  PAUSE(3, "pause", false, false, true),
  READY_STOP(4, "ready stop", true, false, false),
  STOP(5, "stop", false, false, true),
  FAILURE(6, "failure", false, false, true),
  SUCCESS(7, "success", false, false, true),
  SERIAL_WAIT(14, "serial wait", true, true, false),
  FAILOVER(18, "failover", false, false, false),
  ;

  private static final Map<Integer, WorkflowExecutionStatus> CODE_MAP = new HashMap<>();

  private static final int[] NEED_FAILOVER_STATES =
      new int[] {
        RUNNING_EXECUTION.getCode(), READY_PAUSE.getCode(), READY_STOP.getCode(),
      };

  static {
    for (WorkflowExecutionStatus executionStatus : WorkflowExecutionStatus.values()) {
      CODE_MAP.put(executionStatus.getCode(), executionStatus);
    }
  }

  /**
   * Get <code>WorkflowExecutionStatus</code> by code, if the code is invalidated will throw {@link
   * IllegalArgumentException}.
   */
  public static @NonNull WorkflowExecutionStatus of(int code) {
    WorkflowExecutionStatus workflowExecutionStatus = CODE_MAP.get(code);
    if (workflowExecutionStatus == null) {
      throw new IllegalArgumentException(
          String.format("The workflow execution status code: %s is invalidated", code));
    }
    return workflowExecutionStatus;
  }

  public boolean isRunning() {
    return this == RUNNING_EXECUTION;
  }

  public boolean canStop() {
    return canStop;
  }

  public boolean canPause() {
    return canPause;
  }

  /** whether the workflow instance is finished, and the state will not change anymore */
  public boolean isFinished() {
    return finalState;
  }

  public boolean isSuccess() {
    return this == SUCCESS;
  }

  public boolean isFailure() {
    return this == FAILURE;
  }

  public boolean isPause() {
    return this == PAUSE;
  }

  public boolean isReadyStop() {
    return this == READY_STOP;
  }

  public boolean isStop() {
    return this == STOP;
  }

  public static int[] getNeedFailoverWorkflowInstanceState() {
    return Arrays.copyOf(NEED_FAILOVER_STATES, NEED_FAILOVER_STATES.length);
  }

  private final int code;

  private final String desc;

  private final boolean canStop;

  private final boolean canPause;

  private final boolean finalState;

  WorkflowExecutionStatus(
      int code, String desc, boolean canStop, boolean canPause, boolean finalState) {
    this.code = code;
    this.desc = desc;
    this.canStop = canStop;
    this.canPause = canPause;
    this.finalState = finalState;
  }

  public int getCode() {
    return code;
  }

  public String getDesc() {
    return desc;
  }

  @Override
  public String toString() {
    return "WorkflowExecutionStatus{" + "code=" + code + ", desc='" + desc + '\'' + '}';
  }
}
