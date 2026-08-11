package com.github.weaksloth.dolphins.workflow;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/** copied from org.apache.dolphinscheduler.dao.entity.DagData */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DagData {

  private WorkflowDefineResp workflowDefinition;
  private List<TaskRelation> workflowTaskRelationList;
  private List<TaskDefinition> taskDefinitionList;

  public DagData() {}

  public WorkflowDefineResp getWorkflowDefinition() {
    return workflowDefinition;
  }

  public void setWorkflowDefinition(WorkflowDefineResp workflowDefinition) {
    this.workflowDefinition = workflowDefinition;
  }

  public List<TaskRelation> getWorkflowTaskRelationList() {
    return workflowTaskRelationList;
  }

  public void setWorkflowTaskRelationList(List<TaskRelation> workflowTaskRelationList) {
    this.workflowTaskRelationList = workflowTaskRelationList;
  }

  public List<TaskDefinition> getTaskDefinitionList() {
    return taskDefinitionList;
  }

  public void setTaskDefinitionList(List<TaskDefinition> taskDefinitionList) {
    this.taskDefinitionList = taskDefinitionList;
  }
}
