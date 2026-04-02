package com.github.weaksloth.dolphins.process;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DagData {

  private ProcessDefineResp processDefinition;
  private List<TaskRelation> processTaskRelationList;
  private List<TaskDefinition> taskDefinitionList;

  public DagData() {}

  public ProcessDefineResp getProcessDefinition() {
    return processDefinition;
  }

  public void setProcessDefinition(ProcessDefineResp processDefinition) {
    this.processDefinition = processDefinition;
  }

  public List<TaskRelation> getProcessTaskRelationList() {
    return processTaskRelationList;
  }

  public void setProcessTaskRelationList(List<TaskRelation> processTaskRelationList) {
    this.processTaskRelationList = processTaskRelationList;
  }

  public List<TaskDefinition> getTaskDefinitionList() {
    return taskDefinitionList;
  }

  public void setTaskDefinitionList(List<TaskDefinition> taskDefinitionList) {
    this.taskDefinitionList = taskDefinitionList;
  }
}
