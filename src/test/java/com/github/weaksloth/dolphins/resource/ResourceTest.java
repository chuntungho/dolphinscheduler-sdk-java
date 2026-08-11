package com.github.weaksloth.dolphins.resource;

import com.github.weaksloth.dolphins.BaseTest;
import java.io.File;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ResourceTest extends BaseTest {

  private final String fileName = "dophinsdk-create2";
  private final String suffix = "sh";

  /**
   * since 3.3.0 the resource api works with the absolute path of the file, the base directory can
   * be queried by {@link ResourceOperator#queryBaseDir()}, such as
   * file:/dolphinscheduler/default/resources
   */
  private String baseDir() {
    return getClient().opsForResource().queryBaseDir();
  }

  private String fullName() {
    return baseDir() + fileName + "." + suffix;
  }

  @Test
  public void testQueryBaseDir() {
    System.out.println(baseDir());
  }

  @Test
  public void testPage() {
    List<ResourceQueryRes> list = getClient().opsForResource().page(null, null, baseDir(), "");
    list.forEach(System.out::println);
  }

  @Test
  public void testOnlineCreate() {
    ResourceCreateParam resourceCreateParam = new ResourceCreateParam();
    resourceCreateParam
        .setCurrentDir(baseDir())
        .setSuffix(suffix)
        .setFileName(fileName)
        .setContent("created by dolphin scheduler java sdk");
    Assert.assertTrue(getClient().opsForResource().onlineCreate(resourceCreateParam));
  }

  @Test
  public void testOnlineUpdate() {
    ResourceUpdateParam resourceUpdateParam = new ResourceUpdateParam();
    resourceUpdateParam.setFullName(fullName()).setContent("update by dolphin scheduler java sdk");
    Assert.assertTrue(getClient().opsForResource().onlineUpdate(resourceUpdateParam));
  }

  @Test
  public void testUploadFile() {
    ResourceUploadParam resourceUploadParam = new ResourceUploadParam();
    resourceUploadParam
        .setCurrentDir(baseDir())
        .setName("test_upload.txt")
        .setFile(new File("/home/chen/Documents/test_upload.txt"));
    Assert.assertTrue(getClient().opsForResource().upload(resourceUploadParam));
  }

  @Test
  public void delete() {
    Assert.assertTrue(getClient().opsForResource().delete(fullName()));
  }
}
