package com.github.weaksloth.dolphins.remote;

import com.google.common.base.Strings;
import java.net.URI;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;

public class BaseHttpMethod {

  private final ClassicRequestBuilder builder;

  public BaseHttpMethod(ClassicRequestBuilder builder) {
    this.builder = builder;
  }

  public void addHeader(String name, String value) {
    builder.addHeader(name, value);
  }

  public void setEntity(HttpEntity httpEntity) {
    builder.setEntity(httpEntity);
  }

  public ClassicHttpRequest build() {
    return builder.build();
  }

  /**
   * get base http method by name
   *
   * @param name
   * @return
   */
  public static BaseHttpMethod of(String name, URI uri) {
    if (!Strings.isNullOrEmpty(name)) {
      ClassicRequestBuilder builder = ClassicRequestBuilder.create(name);
      builder.setUri(uri);
      return new BaseHttpMethod(builder);
    }
    throw new IllegalArgumentException("Unsupported http method : " + name);
  }
}
