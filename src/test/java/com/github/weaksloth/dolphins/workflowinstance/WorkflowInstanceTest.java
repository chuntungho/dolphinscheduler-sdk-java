package com.github.weaksloth.dolphins.workflowinstance;

import com.github.weaksloth.dolphins.BaseTest;
import com.github.weaksloth.dolphins.enums.*;
import org.junit.Assert;
import org.junit.Test;

public class WorkflowInstanceTest extends BaseTest {

  public static final Long WORKFLOW_DEFINITION_CODE = 11386905142912L;

  /** the workflow must in online state,otherwise will cause error */
  @Test
  public void testStartInstance() {

    WorkflowInstanceCreateParam startParam = new WorkflowInstanceCreateParam();
    startParam
        .setWorkflowDefinitionCode(WORKFLOW_DEFINITION_CODE)
        .setScheduleTime("")
        .setFailureStrategy(FailureStrategy.CONTINUE)
        .setWarningType(WarningType.NONE)
        .setWarningGroupId(0L)
        .setExecType("")
        .setStartNodeList("")
        .setTaskDependType(TaskDependType.TASK_POST.toString())
        .setRunMode(RunMode.RUN_MODE_SERIAL.toString())
        .setWorkflowInstancePriority(Priority.MEDIUM.toString())
        .setWorkerGroup("default")
        .setEnvironmentCode("")
        .setStartParams("")
        .setExpectedParallelismNumber("")
        .setDryRun(0);
    Assert.assertTrue(getClient().opsForWorkflowInstance().start(projectCode, startParam));
  }

  @Test
  public void testReRun() {
    Long instanceId = 31L;
    Assert.assertTrue(getClient().opsForWorkflowInstance().reRun(projectCode, instanceId));
  }

  @Test
  public void testPage() {
    getClient()
        .opsForWorkflowInstance()
        .page(null, null, projectCode, WORKFLOW_DEFINITION_CODE)
        .forEach(System.out::println);
  }

  @Test
  public void testDelete() {
    Long instanceId = 31L;
    Assert.assertTrue(getClient().opsForWorkflowInstance().delete(projectCode, instanceId));
  }
}
