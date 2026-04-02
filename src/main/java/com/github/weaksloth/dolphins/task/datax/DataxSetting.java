package com.github.weaksloth.dolphins.task.datax;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DataxSetting {

  @JsonProperty("speed")
  private Speed speed;

  @Data
  @Accessors(chain = true)
  public static class Speed {

    @JsonProperty("channel")
    private Integer channel = 1;
  }
}
