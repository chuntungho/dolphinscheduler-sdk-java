package com.github.weaksloth.dolphins.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import lombok.Data;

/** copied from org.apache.dolphinscheduler.api.vo.ResourceItemVO */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceQueryRes {

  /** resource alias */
  private String alias;

  private String userName;

  /** file name */
  private String fileName;

  /** the absolute path of the resource */
  private String fullName;

  /** is directory */
  private boolean isDirectory = false;

  /** resource type: FILE, ALL */
  private String type;

  /** resource size */
  private long size;

  /** create time */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;

  /** update time */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date updateTime;
}
