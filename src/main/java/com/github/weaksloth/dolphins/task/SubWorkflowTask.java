package com.github.weaksloth.dolphins.task;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/** reference: org.apache.dolphinscheduler.plugin.task.api.parameters.SubWorkflowParameters */
@Data
@Accessors(chain = true)
public class SubWorkflowTask extends AbstractTask {
  @Override
  public String getTaskType() {
    return "SUB_WORKFLOW";
  }

  private List<Object> resourceList;

  private Long workflowDefinitionCode;
}
