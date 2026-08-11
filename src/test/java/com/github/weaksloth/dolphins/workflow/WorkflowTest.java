package com.github.weaksloth.dolphins.workflow;

import com.github.weaksloth.dolphins.BaseTest;
import com.github.weaksloth.dolphins.enums.HttpCheckCondition;
import com.github.weaksloth.dolphins.enums.HttpMethod;
import com.github.weaksloth.dolphins.task.HttpTask;
import com.github.weaksloth.dolphins.task.ShellTask;
import com.github.weaksloth.dolphins.util.TaskDefinitionUtils;
import com.github.weaksloth.dolphins.util.TaskLocationUtils;
import com.github.weaksloth.dolphins.util.TaskRelationUtils;
import com.github.weaksloth.dolphins.util.TaskUtils;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/** the test for workflow definition */
public class WorkflowTest extends BaseTest {

  public static final String WORKFLOW_NAME = "test-dag2";

  /**
   * create simple workflow like: shellTask -> httpTask
   *
   * <p>1.generate task code
   *
   * <p>2.create tasks
   *
   * <p>3.create task definitions
   *
   * <p>4.create task relations
   *
   * <p>5.create workflow define param
   *
   * <p>
   */
  @Test
  public void testCreateWorkflowDefinition() {

    List<Long> taskCodes = getClient().opsForWorkflow().generateTaskCode(projectCode, 2);

    // build shell task
    ShellTask shellTask = new ShellTask();
    shellTask.setRawScript("echo 'hello dolphin scheduler java sdk'");
    TaskDefinition shellTaskDefinition =
        TaskDefinitionUtils.createDefaultTaskDefinition(taskCodes.get(0), shellTask);

    // build http task
    HttpTask httpTask = new HttpTask();
    httpTask
        .setUrl("http://www.baidu.com")
        .setHttpMethod(HttpMethod.GET.toString())
        .setHttpCheckCondition(HttpCheckCondition.STATUS_CODE_DEFAULT.toString())
        .setCondition("")
        .setConditionResult(TaskUtils.createEmptyConditionResult());
    TaskDefinition httpTaskDefinition =
        TaskDefinitionUtils.createDefaultTaskDefinition(taskCodes.get(1), httpTask);

    WorkflowDefineParam pcr = new WorkflowDefineParam();
    pcr.setName(WORKFLOW_NAME)
        .setLocations(TaskLocationUtils.horizontalLocation(taskCodes.toArray(new Long[0])))
        .setDescription("test-dag-description")
        .setTimeout("0")
        .setExecutionType(WorkflowDefineParam.EXECUTION_TYPE_PARALLEL)
        .setTaskDefinitionJson(Arrays.asList(shellTaskDefinition, httpTaskDefinition))
        .setTaskRelationJson(TaskRelationUtils.oneLineRelation(taskCodes.toArray(new Long[0])))
        .setGlobalParams(null);

    System.out.println(getClient().opsForWorkflow().create(projectCode, pcr));
  }

  @Test
  public void testPage() {
    List<WorkflowDefineResp> page =
        getClient().opsForWorkflow().page(projectCode, null, null, WORKFLOW_NAME);
    int expectedWorkflowNumber = 1;
    Assert.assertEquals(expectedWorkflowNumber, page.size());
  }

  @Test
  public void testOnlineWorkflow() {
    List<WorkflowDefineResp> page =
        getClient().opsForWorkflow().page(projectCode, null, null, WORKFLOW_NAME);
    Assert.assertTrue(getClient().opsForWorkflow().online(projectCode, page.get(0).getCode()));
  }

  @Test
  public void testOfflineWorkflow() {
    List<WorkflowDefineResp> page =
        getClient().opsForWorkflow().page(projectCode, null, null, WORKFLOW_NAME);
    Assert.assertTrue(getClient().opsForWorkflow().offline(projectCode, page.get(0).getCode()));
  }

  /** the workflow must in offline state */
  @Test
  public void testDeleteWorkflow() {
    List<WorkflowDefineResp> page =
        getClient().opsForWorkflow().page(projectCode, null, null, WORKFLOW_NAME);
    Assert.assertTrue(getClient().opsForWorkflow().delete(projectCode, page.get(0).getCode()));
  }
}
