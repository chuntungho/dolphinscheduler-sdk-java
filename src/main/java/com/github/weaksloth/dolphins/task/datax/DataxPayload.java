package com.github.weaksloth.dolphins.task.datax;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataxPayload {

  @JsonProperty("job")
  private DataxJob job;

  public static DataxPayload of(DataxJob job) {
    return new DataxPayload(job);
  }

  public DataxPayload(DataxJob job) {
    this.job = job;
  }

  public void setJob(DataxJob job) {
    this.job = job;
  }

  public DataxJob getJob() {
    return job;
  }
}
