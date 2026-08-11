package com.github.weaksloth.dolphins.task;

import com.github.weaksloth.dolphins.remote.RequestHttpEntity;
import com.github.weaksloth.dolphins.util.JacksonUtils;
import com.github.weaksloth.dolphins.workflow.Parameter;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class HttpTask extends AbstractTask {

  private List<Parameter> localParams = Collections.emptyList();

  /** http request param */
  private List<HttpParam> httpParams = Collections.emptyList();

  /** http request url */
  private String url;

  /** http method, {@link com.github.weaksloth.dolphins.enums.HttpMethod} */
  private String httpMethod;

  /** http request body */
  private String httpBody;

  private String httpCheckCondition; // STATUS_CODE_DEFAULT
  private String condition;
  private Integer connectTimeout = 60000;

  @Override
  public String getTaskType() {
    return "HTTP";
  }

  @Data
  @Accessors(chain = true)
  @AllArgsConstructor
  @NoArgsConstructor
  public static class HttpParam {
    private String prop;
    private String value;
    private String httpParametersType;

    /** create http form param instance */
    public static HttpParam newForm() {
      return new HttpParam(null, null, "PARAMETER");
    }

    /** create http headers param instance */
    public static HttpParam newHeader() {
      return new HttpParam(null, null, "HEADERS");
    }

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
}
