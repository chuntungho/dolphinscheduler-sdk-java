package com.github.weaksloth.dolphins.resource;

import com.github.weaksloth.dolphins.core.DolphinClientConstant;
import java.io.File;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResourceUploadParam {

  private String type = DolphinClientConstant.Resource.TYPE_FILE;

  /**
   * the absolute path of the parent directory, such as file:/dolphinscheduler/default/resources,
   * see {@link ResourceOperator#queryBaseDir()}
   */
  private String currentDir;

  private File file;

  private String name;
}
