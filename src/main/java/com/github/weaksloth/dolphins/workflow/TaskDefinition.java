package com.github.weaksloth.dolphins.workflow;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.weaksloth.dolphins.remote.RequestHttpEntity;
import com.github.weaksloth.dolphins.task.*;
import com.github.weaksloth.dolphins.util.JacksonUtils;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskDefinition {

  private Long code;

  private Integer version;

  /** the task node's name */
  private String name;

  /** the task node's description */
  private String description;

  /** get from {@link AbstractTask#getTaskType()} */
  private String taskType;

  @JsonIgnore private AbstractTask taskParams;

  @JsonProperty("taskParams")
  private Object taskParamsMap;

  /** NO:the node will not execute;YES:the node will execute,default is YES */
  private String flag;

  private String taskPriority;

  private String workerGroup;

  private String failRetryTimes;

  private String failRetryInterval;

  private String timeoutFlag;

  private String timeoutNotifyStrategy;

  private Integer timeout = 0;

  private String delayTime = "0";

  private Long environmentCode = -1L;

  private String taskExecuteType;

  private Integer cpuQuota = -1;

  private Long memoryMax = -1L;

  private Integer taskGroupId;

  // convert from json
  public AbstractTask getTaskParams() {
    if (taskParams == null && taskParamsMap != null) {
      Class<? extends AbstractTask> type = ShellTask.class;
      switch (taskType) {
        case "DATAX":
          type = DataxTask.class;
          break;
        case "HTTP":
          type = HttpTask.class;
          break;
        case "SQL":
          type = SqlTask.class;
          break;
        case "SUB_WORKFLOW":
          type = SubWorkflowTask.class;
          break;
      }
      taskParams = JacksonUtils.convert(taskParamsMap, type);
    }
    return taskParams;
  }

  /**
   * must rewrite,then {@link RequestHttpEntity#bodyToMap()} can transfer object to json string
   *
   * @return object json string
   */
  @Override
  public String toString() {
    // for json property
    if (taskParamsMap == null) {
      taskParamsMap = this.taskParams;
    }
    return JacksonUtils.toJSONString(this);
  }
}
