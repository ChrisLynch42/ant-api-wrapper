/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.util.PathsUtil;
import org.apache.tools.ant.Project;

/**
 *
 * @author chris
 */
public class Replace extends BaseTask {
  private org.apache.tools.ant.taskdefs.Replace task = new org.apache.tools.ant.taskdefs.Replace();

  public Replace(
    Project project
  ) {
    super(project);
    task.setProject(project);
  }

  public org.apache.tools.ant.taskdefs.Replace getTask() {
    return task;
  }
  
  public Replace execute() {
    task.execute();
    return this;
  }
  
  public Replace setToken(String token) {
    task.setToken(token);
    return this;
  }

  public Replace setValue(String value) {
    task.setValue(value);
    return this;
  }

  public Replace setFile(String targetFile) {
    task.setFile(PathsUtil.getFile(targetFile));
    return this;
  }
  
}
