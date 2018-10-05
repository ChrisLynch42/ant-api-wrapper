/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.util.PathsUtil;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.ExecuteOn;

/**
 *
 * @author chris
 */
public class Chmod extends BaseTask {
  private org.apache.tools.ant.taskdefs.Chmod task = new org.apache.tools.ant.taskdefs.Chmod();

  public Chmod(
    Project project
  ) {
    super(project);
    task.setProject(project);
    task.setMaxParallel(300);
    task.setForce(true);
  }

  public org.apache.tools.ant.taskdefs.Chmod getTask() {
    return task;
  }
  
  public Chmod execute() {
    task.execute();
    return this;
  }
  
  public Chmod setForce(boolean force) {
    task.setForce(force);
    return this;
  }

  public Chmod setType(String type) {
    ExecuteOn.FileDirBoth enumType = new ExecuteOn.FileDirBoth();
    enumType.setValue(type);    
    task.setType(enumType);
    return this;
  }

  public Chmod setDir(String targetDir) {
    task.setDir(PathsUtil.getFile(targetDir));
    return this;
  }
  
  public Chmod setPerm(String permissions) {
    task.setPerm(permissions);
    return this;
  }
  
  public Chmod addFileset(String sourceDir, String filenamePattern) {
    task.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));;
    return this;
  }
  
}
