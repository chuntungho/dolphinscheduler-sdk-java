package com.github.weaksloth.dolphins.task;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SubProcessTask extends AbstractTask {
  @Override
  public String getTaskType() {
    return "SUB_PROCESS";
  }

  private List<Object> resourceList;

  private Long processDefinitionCode;
}
