/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import java.io.File;
import com.codeexcursion.ant.util.PathsUtil;
import org.apache.tools.ant.Project;

/**
 *
 * @author chris
 */
public class Delete extends BaseTask {
  private org.apache.tools.ant.taskdefs.Delete task = new org.apache.tools.ant.taskdefs.Delete();

  public Delete(
    Project project
  ) {
    super(project);
    task.setProject(project);
    task.setIncludeEmptyDirs(true);
  }

  public org.apache.tools.ant.taskdefs.Delete getTask() {
    return task;
  }
  
  public Delete execute() {
    task.execute();
    return this;
  }
  
  public Delete setIncludeEmptyDirs(boolean includeEmptyDirs) {
    task.setIncludeEmptyDirs(includeEmptyDirs);
    return this;
  }

  public Delete setDir(String targetDir) {
    task.setDir(PathsUtil.getFile(targetDir));
    return this;
  }
  
  public Delete addFileset(String sourceDir, String filenamePattern) {
    task.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));
    return this;
  }
  
}
