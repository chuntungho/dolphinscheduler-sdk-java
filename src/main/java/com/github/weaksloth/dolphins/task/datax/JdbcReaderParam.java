package com.github.weaksloth.dolphins.task.datax;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class JdbcReaderParam {
  private String username;
  private String password;
  private String splitPk;

  // talbe/column/where will be ignored when querySql is provided
  private List<String> column;
  private String where;

  private List<ConnectionItem> connection;
}
