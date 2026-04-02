package com.github.weaksloth.dolphins.project;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TaskGroupParam {
  private String name;
  private String description;
  private Integer groupSize;
}
