package com.github.weaksloth.dolphins.workflowinstance;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.weaksloth.dolphins.common.PageInfo;
import com.github.weaksloth.dolphins.core.AbstractOperator;
import com.github.weaksloth.dolphins.core.DolphinClientConstant;
import com.github.weaksloth.dolphins.core.DolphinException;
import com.github.weaksloth.dolphins.remote.DolphinsRestTemplate;
import com.github.weaksloth.dolphins.remote.HttpRestResult;
import com.github.weaksloth.dolphins.remote.Query;
import com.github.weaksloth.dolphins.util.JacksonUtils;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WorkflowInstanceOperator extends AbstractOperator {

  public WorkflowInstanceOperator(
      String dolphinAddress, String token, DolphinsRestTemplate dolphinsRestTemplate) {
    super(dolphinAddress, token, dolphinsRestTemplate);
  }

  /**
   * start/run workflow instance
   *
   * <p>api: /dolphinscheduler/projects/{projectCode}/executors/start-workflow-instance
   *
   * @param workflowInstanceCreateParam workflow instance create param
   * @return true for success,otherwise false
   */
  public Boolean start(Long projectCode, WorkflowInstanceCreateParam workflowInstanceCreateParam) {
    String url = dolphinAddress + "/projects/" + projectCode + "/executors/start-workflow-instance";
    log.info("start workflow instance ,url:{}", url);
    try {
      HttpRestResult<JsonNode> restResult =
          dolphinsRestTemplate.postForm(
              url, getHeader(), workflowInstanceCreateParam, JsonNode.class);
      log.info("start workflow response:{}", restResult);
      return restResult.getSuccess();
    } catch (Exception e) {
      throw new DolphinException("start dolphin scheduler workflow instance fail", e);
    }
  }

  public Boolean batchStart(
      Long projectCode, WorkflowInstanceCreateParam workflowInstanceCreateParam) {
    String url =
        dolphinAddress + "/projects/" + projectCode + "/executors/batch-start-workflow-instance";
    log.info("batch start workflow instance ,url:{}", url);
    try {
      HttpRestResult<JsonNode> restResult =
          dolphinsRestTemplate.postForm(
              url, getHeader(), workflowInstanceCreateParam, JsonNode.class);
      log.info("batch start workflow response:{}", restResult);
      return restResult.getSuccess();
    } catch (Exception e) {
      throw new DolphinException("batch start dolphin scheduler workflow instance fail", e);
    }
  }

  /**
   * page query workflow's instance list
   *
   * @param page page,default 1 while is null
   * @param size size,default 10 while is null
   * @param projectCode project code
   * @param workflowCode workflow definition code
   * @return {@link List<WorkflowInstanceQueryResp>}
   */
  public List<WorkflowInstanceQueryResp> page(
      Integer page, Integer size, Long projectCode, Long workflowCode) {
    page = Optional.ofNullable(page).orElse(DolphinClientConstant.Page.DEFAULT_PAGE);
    size = Optional.ofNullable(size).orElse(DolphinClientConstant.Page.DEFAULT_SIZE);

    String url = dolphinAddress + "/projects/" + projectCode + "/workflow-instances";

    Query query = new Query();
    query
        .addParam("pageNo", String.valueOf(page))
        .addParam("pageSize", String.valueOf(size))
        .addParam("workflowDefinitionCode", String.valueOf(workflowCode));

    try {
      HttpRestResult<JsonNode> restResult =
          dolphinsRestTemplate.get(url, getHeader(), query, JsonNode.class);
      return JacksonUtils.parseObject(
              restResult.getData().toString(),
              new TypeReference<PageInfo<WorkflowInstanceQueryResp>>() {})
          .getTotalList();
    } catch (Exception e) {
      throw new DolphinException("page dolphin scheduler workflow instance list fail", e);
    }
  }

  /**
   * repeat run dolphin scheduler workflow instance
   *
   * @param projectCode project code
   * @param workflowInstanceId workflow instance id
   * @return true for success,otherwise false
   */
  public Boolean reRun(Long projectCode, Long workflowInstanceId) {
    log.info("repeat run workflow instance,id:{}", workflowInstanceId);
    return execute(projectCode, workflowInstanceId, DolphinClientConstant.ExecuteType.RE_RUN);
  }

  /**
   * stop dolphin scheduler workflow instance
   *
   * @param projectCode project code
   * @param workflowInstanceId workflow instance id
   * @return true for success,otherwise false
   */
  public Boolean stop(Long projectCode, Long workflowInstanceId) {
    log.info("stop workflow instance,id:{}", workflowInstanceId);
    return execute(projectCode, workflowInstanceId, DolphinClientConstant.ExecuteType.STOP);
  }

  /**
   * pause dolphin scheduler workflow instance
   *
   * @param projectCode project code
   * @param workflowInstanceId workflow instance id
   * @return true for success,otherwise false
   */
  public Boolean pause(Long projectCode, Long workflowInstanceId) {
    log.info("pause workflow instance,id:{}", workflowInstanceId);
    return execute(projectCode, workflowInstanceId, DolphinClientConstant.ExecuteType.PAUSE);
  }

  /**
   * execute dolphin scheduler workflow instance with custom execute type
   *
   * @param projectCode project code
   * @param workflowInstanceId workflow instance id
   * @param executeType {@link com.github.weaksloth.dolphins.core.DolphinClientConstant.ExecuteType}
   * @return true for success,otherwise false
   */
  public Boolean execute(Long projectCode, Long workflowInstanceId, String executeType) {
    String url = dolphinAddress + "/projects/" + projectCode + "/executors/execute";
    WorkflowInstanceRunParam workflowInstanceRunParam =
        new WorkflowInstanceRunParam()
            .setWorkflowInstanceId(workflowInstanceId)
            .setExecuteType(executeType);
    try {
      HttpRestResult<String> restResult =
          dolphinsRestTemplate.postForm(url, getHeader(), workflowInstanceRunParam, String.class);
      return restResult.getSuccess();
    } catch (Exception e) {
      throw new DolphinException(executeType + " dolphin scheduler workflow instance fail", e);
    }
  }

  public Boolean delete(Long projectCode, Long workflowInstanceId) {
    String url =
        dolphinAddress + "/projects/" + projectCode + "/workflow-instances/" + workflowInstanceId;
    try {
      HttpRestResult<String> restResult =
          dolphinsRestTemplate.delete(url, getHeader(), null, String.class);
      return restResult.getSuccess();
    } catch (Exception e) {
      throw new DolphinException("delete dolphin scheduler workflow instance fail", e);
    }
  }
}
