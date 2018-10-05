/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.util.PathsUtil;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;

/**
 *
 * @author chris
 */
public class Unzip extends BaseTask {
  private org.apache.tools.ant.taskdefs.Expand task = new org.apache.tools.ant.taskdefs.Expand();

  public Unzip(
    Project project
  ) {
    super(project);
    task.setProject(project);
    task.setOverwrite(true);
  }

  public org.apache.tools.ant.taskdefs.Expand getTask() {
    return task;
  }
  
  public Unzip execute() {
    task.execute();
    return this;
  }
  
  public Unzip setOverwrite(boolean overwrite) {
    task.setOverwrite(overwrite);
    return this;
  }

  public Unzip setDest(String destDir) {
    task.setDest(PathsUtil.getFile(destDir));
    return this;
  }
  
  public Unzip setSrc(String sourceFile) {
    task.setSrc(PathsUtil.getFile(sourceFile));
    return this;
  }
  
  public Unzip addFileset(String sourceDir, String filenamePattern) {
    task.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));;
    return this;
  }
  
}
