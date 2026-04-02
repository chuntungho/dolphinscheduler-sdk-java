package com.github.weaksloth.dolphins.instance;

import com.github.weaksloth.dolphins.enums.ExecutionOrder;
import com.github.weaksloth.dolphins.enums.FailureStrategy;
import com.github.weaksloth.dolphins.enums.WarningType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.jspecify.annotations.NonNull;

/** process instance create param */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ProcessInstanceCreateParam {

  /** continue or end */
  @NonNull private FailureStrategy failureStrategy = FailureStrategy.END;

  // for batch only
  private String processDefinitionCodes;

  // for single
  private Long processDefinitionCode;

  private String processInstancePriority;

  private ExecutionOrder executionOrder = ExecutionOrder.ASC_ORDER;
  // map
  @NonNull private String scheduleTime;

  private Long warningGroupId;

  @NonNull private WarningType warningType = WarningType.FAILURE;

  /** o or 1 */
  private Integer dryRun;

  /** env code */
  private String environmentCode;

  // COMPLEMENT_DATA
  private String execType;

  private String expectedParallelismNumber;

  /** run mode,value:RUN_MODE_SERIAL,RUN_MODE_PARALLEL */
  private String runMode;

  private String startNodeList;

  // Map format
  private String startParams;

  private String taskDependType;

  /** worker group */
  private String workerGroup = "default";
}
