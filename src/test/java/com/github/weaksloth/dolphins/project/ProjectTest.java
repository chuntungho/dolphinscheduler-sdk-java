package com.github.weaksloth.dolphins.project;

import com.github.weaksloth.dolphins.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class ProjectTest extends BaseTest {

  private static final String PROJECT_NAME = "test_project";

  @Test
  public void testCreateProject() {

    ProjectCreateParam param = new ProjectCreateParam();
    param.setProjectName(PROJECT_NAME).setDescription("created by dolphinscheduler java sdk");
    ProjectInfoResp projectInfoResp = getClient().opsForProject().create(param);
    System.out.println(projectInfoResp);
    Assert.assertEquals(PROJECT_NAME, projectInfoResp.getName());
  }

  @Test
  public void testListProject() {
    getClient().opsForProject().page(null, null, null).forEach(System.out::println);
  }

  @Test
  public void testUpdateProject() {
    ProjectInfoResp projectInfo = getClient().opsForProject().page(null, null, PROJECT_NAME).get(0);
    ProjectUpdateParam updateParam = new ProjectUpdateParam();
    String newDescription = "updated by dolphinscheduler java sdk";
    updateParam
        .setProjectName(PROJECT_NAME)
        .setProjectCode(projectInfo.getCode())
        .setUserName(projectInfo.getUserName())
        .setDescription(newDescription);
    ProjectInfoResp newProjectInfo = getClient().opsForProject().update(updateParam);
    Assert.assertEquals(newDescription, newProjectInfo.getDescription());
  }

  @Test
  public void testDeleteProject() {
    // get test project code
    long code = getClient().opsForProject().page(null, null, PROJECT_NAME).get(0).getCode();
    getClient().opsForProject().delete(code);
  }

  @Test
  public void testCreateTaskGroup() {
    long projectCode = getClient().opsForProject().page(null, null, PROJECT_NAME).get(0).getCode();

    TaskGroupParam taskGroupParam = new TaskGroupParam();
    taskGroupParam.setName("test_task_group");
    taskGroupParam.setDescription("Test task group created by SDK");
    // taskGroupParam.setResourcePool(10);

    TaskGroupResp taskGroupResp =
        getClient().opsForProject().createTaskGroup(projectCode, taskGroupParam);
    System.out.println(taskGroupResp);
    Assert.assertNotNull(taskGroupResp);
    Assert.assertEquals("test_task_group", taskGroupResp.getName());
  }

  @Test
  public void testQueryTaskGroup() {
    java.util.List<TaskGroupResp> taskGroups =
        getClient().opsForProject().queryTaskGroup(null, null, null);
    System.out.println("Total task groups: " + taskGroups.size());
    taskGroups.forEach(System.out::println);
    Assert.assertNotNull(taskGroups);
  }

  @Test
  public void testQueryTaskGroupWithPagination() {
    java.util.List<TaskGroupResp> taskGroups =
        getClient().opsForProject().queryTaskGroup(1, 10, null);
    System.out.println("Task groups on page 1: " + taskGroups.size());
    Assert.assertNotNull(taskGroups);
  }

  @Test
  public void testQueryTaskGroupByName() {
    java.util.List<TaskGroupResp> taskGroups =
        getClient().opsForProject().queryTaskGroup(null, null, "test_task_group");
    System.out.println("Found task groups with name 'test_task_group': " + taskGroups.size());
    if (!taskGroups.isEmpty()) {
      Assert.assertEquals("test_task_group", taskGroups.get(0).getName());
    }
  }
}
