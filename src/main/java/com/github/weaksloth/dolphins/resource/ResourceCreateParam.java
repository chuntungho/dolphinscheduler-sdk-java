package com.github.weaksloth.dolphins.resource;

import com.github.weaksloth.dolphins.core.DolphinClientConstant;
import lombok.Data;
import lombok.experimental.Accessors;

/** create resource param */
@Data
@Accessors(chain = true)
public class ResourceCreateParam {

  private String type = DolphinClientConstant.Resource.TYPE_FILE;

  /**
   * the absolute path of the parent directory, such as file:/dolphinscheduler/default/resources,
   * see {@link ResourceOperator#queryBaseDir()}
   */
  private String currentDir;

  private String fileName;

  private String suffix;

  private String content;
}
