package com.github.weaksloth.dolphins.task.datax;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Writer {

  private String name;

  private Object parameter;
}
