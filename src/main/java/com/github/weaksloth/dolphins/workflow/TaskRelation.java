package com.github.weaksloth.dolphins.workflow;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.weaksloth.dolphins.remote.RequestHttpEntity;
import com.github.weaksloth.dolphins.util.JacksonUtils;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskRelation {

  private String name = "";

  private Long preTaskCode = 0L;

  private Integer preTaskVersion = 0;

  private Long postTaskCode;

  private Integer postTaskVersion = 0;

  private String conditionType = "NONE";

  private Map<String, Object> conditionParams;

  /**
   * must rewrite,then {@link RequestHttpEntity#bodyToMap()} can transfer object to json string
   *
   * @return object json string
   */
  @Override
  public String toString() {
    return JacksonUtils.toJSONString(this);
  }
}
