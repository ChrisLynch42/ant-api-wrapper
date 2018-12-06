/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.util.PathsUtil;

import java.io.File;

import org.apache.tools.ant.Project;

/**
 *
 * @author chris
 */
public class Copy extends BaseTask {
  private org.apache.tools.ant.taskdefs.Copy task = new org.apache.tools.ant.taskdefs.Copy();

  public Copy(
    Project project
  ) {
    super(project);
    task.setProject(project);
    task.setOverwrite(true);
    task.setForce(true);
  }

  public org.apache.tools.ant.taskdefs.Copy getTask() {
    return task;
  }
  
  public Copy execute() {
    task.execute();
    return this;
  }
  
  public Copy setForce(boolean force) {
    task.setForce(force);
    return this;
  }

  public Copy setOverwrite(boolean overwrite) {
    task.setOverwrite(overwrite);
    return this;
  }

  public Copy setFlatten(boolean flatten) {
    task.setFlatten(flatten);
    return this;
  }
  
  public Copy setToDir(String destDir) {
    task.setTodir(PathsUtil.getFile(destDir));
    return this;
  }
  
  public Copy addFileset(String sourceDir, String filenamePattern) {
    task.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));
    return this;
  }
  
  public Copy setFile(String file) {
	  task.setFile(PathsUtil.getFile(file));
	  return this;
  }
  
  
}
