package com.github.weaksloth.dolphins;

import lombok.Data;
import lombok.NoArgsConstructor;

/** Dolphin Scheduler Properties */
@Data
@NoArgsConstructor
public class DolphinSchedulerProperties {
  private String baseUrl = "http://localhost:8080/dolphinscheduler";
  private String username;
  private String password;
  private String token;
  private long connectionTimeout = 10;
  private long responseTimeout = 30;
  private int maxConnections = 100;
  private int maxConnectionsPerRoute = 10;
}
