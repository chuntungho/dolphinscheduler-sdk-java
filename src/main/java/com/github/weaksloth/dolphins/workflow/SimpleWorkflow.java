package com.github.weaksloth.dolphins.workflow;

public class SimpleWorkflow {
  private Integer id;
  private Long code;
  private String name;
  private Long projectCode;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Long getCode() {
    return code;
  }

  public void setCode(Long code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getProjectCode() {
    return projectCode;
  }

  public void setProjectCode(Long projectCode) {
    this.projectCode = projectCode;
  }
}
