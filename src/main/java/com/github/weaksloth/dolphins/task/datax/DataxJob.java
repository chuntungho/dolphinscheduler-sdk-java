package com.github.weaksloth.dolphins.task.datax;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DataxJob {

  @JsonProperty("content")
  private List<ContentItem> content;

  @JsonProperty("setting")
  private DataxSetting setting;
}
