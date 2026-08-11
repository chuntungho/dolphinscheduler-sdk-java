package com.github.weaksloth.dolphins.workflowinstance;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.weaksloth.dolphins.workflow.WorkflowDefineResp;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/** copied from org.apache.dolphinscheduler.dao.entity.WorkflowInstance */
@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkflowInstanceQueryResp {

  /** id */
  private int id;

  /** workflow definition code */
  private Long workflowDefinitionCode;

  /** workflow definition version */
  private int workflowDefinitionVersion;

  /** project code */
  private Long projectCode;

  /** workflow instance state */
  private String state;

  /** workflow instance state history */
  private String stateHistory;

  /** recovery flag for failover */
  private String recovery;

  /** start time */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date startTime;

  /** end time */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date endTime;

  /** run time */
  private int runTimes;

  /** name */
  private String name;

  /** host */
  private String host;

  /** workflow definition structure */
  private WorkflowDefineResp workflowDefinition;

  /** workflow command type */
  private String commandType;

  /** command parameters */
  private String commandParam;

  /** node depend type */
  private String taskDependType;

  /** task max try times */
  private int maxTryTimes;

  /** failure strategy when task failed.continue or end */
  private String failureStrategy;

  /** warning type */
  private String warningType;

  /** warning group */
  private Integer warningGroupId;

  /** schedule time */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date scheduleTime;

  /** command start time */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date commandStartTime;

  /** user define parameters string */
  private String globalParams;

  /** executor id */
  private int executorId;

  /** executor name */
  private String executorName;

  /** tenant code */
  private String tenantCode;

  /** queue */
  private String queue;

  /** workflow instance is sub workflow */
  private String isSubWorkflow;

  /** task locations for web */
  private String locations;

  /** history command */
  private String historyCmd;

  /** depend workflow schedule times */
  private String dependenceScheduleTimes;

  /** workflow instance duration */
  private String duration;

  /** workflow instance priority */
  private String workflowInstancePriority;

  /** worker group */
  private String workerGroup;

  /** environment code */
  private Long environmentCode;

  /** workflow timeout for warning */
  private int timeout;

  /** varPool string */
  private String varPool;

  /** next workflow instance id */
  private int nextWorkflowInstanceId;

  /** dry run flag */
  private int dryRun;

  /** re-start time */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date restartTime;
}
