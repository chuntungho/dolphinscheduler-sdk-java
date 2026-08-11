package com.github.weaksloth.dolphins.workflowinstance;

import lombok.Data;
import lombok.experimental.Accessors;

/** re run/recover workflow instance */
@Data
@Accessors(chain = true)
public class WorkflowInstanceRunParam {

  private Long workflowInstanceId;

  private String executeType;
}
