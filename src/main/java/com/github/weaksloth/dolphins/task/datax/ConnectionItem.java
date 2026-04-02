package com.github.weaksloth.dolphins.task.datax;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ConnectionItem {
  private List<String> table;
  private List<String> querySql;
  private List<String> jdbcUrl;
}
