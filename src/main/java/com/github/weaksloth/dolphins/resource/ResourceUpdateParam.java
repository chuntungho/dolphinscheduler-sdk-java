package com.github.weaksloth.dolphins.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ResourceUpdateParam {

  /** the absolute path of the resource */
  private String fullName;

  private String content;
}
