/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.weaksloth.dolphins.taskinstance;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.weaksloth.dolphins.workflow.TaskDefinition;
import com.github.weaksloth.dolphins.workflow.WorkflowDefineResp;
import com.github.weaksloth.dolphins.workflowinstance.WorkflowInstanceQueryResp;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/** copied from org.apache.dolphinscheduler.dao.entity.TaskInstance */
@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskInstanceQueryResp implements Serializable {

  /** id */
  private Integer id;

  /** task name */
  private String name;

  /** task type */
  private String taskType;

  /** workflow instance id */
  private int workflowInstanceId;

  /** workflow instance name */
  private String workflowInstanceName;

  private Long projectCode;

  private long taskCode;

  private int taskDefinitionVersion;

  /** dolphin scheduler 3.4.2 still serializes this field with its legacy name */
  private String processDefinitionName;

  /** task group priority */
  private int taskGroupPriority;

  /** state */
  private String state;

  /** task first submit time. */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date firstSubmitTime;

  /** task submit time */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date submitTime;

  /** task start time */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date startTime;

  /** task end time */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date endTime;

  /** task host */
  private String host;

  /**
   * task shell execute path and the resource down from hdfs default path:
   * $base_run_dir/workflowInstanceId/taskInstanceId/retryTimes
   */
  private String executePath;

  /** task log path default path: $base_run_dir/workflowInstanceId/taskInstanceId/retryTimes */
  private String logPath;

  /** retry times */
  private int retryTimes;

  /** alert flag */
  private String alertFlag;

  /** workflow instance */
  private WorkflowInstanceQueryResp workflowInstance;

  /** workflow definition */
  private WorkflowDefineResp workflowDefinition;

  /** task definition */
  private TaskDefinition taskDefine;

  /** process id */
  private int pid;

  /** appLink */
  private String appLink;

  /** flag */
  private String flag;

  /** duration */
  private String duration;

  /** max retry times */
  private int maxRetryTimes;

  /** task retry interval, unit: minute */
  private int retryInterval;

  /** task instance priority */
  private String taskInstancePriority;

  /** workflow instance priority */
  private String workflowInstancePriority;

  /** workerGroup */
  private String workerGroup;

  /** environment code */
  private Long environmentCode;

  /** environment config */
  private String environmentConfig;

  /** executor id */
  private int executorId;

  /** varPool string */
  private String varPool;

  private String executorName;

  /** delay execution time. */
  private int delayTime;

  /** task params */
  private String taskParams;

  /** dry run flag */
  private int dryRun;

  /** task group id */
  private int taskGroupId;

  /** cpu quota */
  private Integer cpuQuota;

  /** max memory */
  private Integer memoryMax;

  /** task execute type */
  private String taskExecuteType;
}
