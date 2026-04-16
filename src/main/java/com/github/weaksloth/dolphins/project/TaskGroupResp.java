package com.github.weaksloth.dolphins.project;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TaskGroupResp {
  private Integer id;
  private String name;
  private Long projectCode;
  private Integer groupSize;
  private Integer useSize;
  private String description;
  private String status;
}
