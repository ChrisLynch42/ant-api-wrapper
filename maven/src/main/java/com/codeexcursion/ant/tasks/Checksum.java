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
public class Checksum extends BaseTask {
  private org.apache.tools.ant.taskdefs.Checksum task = new org.apache.tools.ant.taskdefs.Checksum();

  public Checksum(
    Project project
  ) {
    super(project);
    task.setProject(project);
    
  }

  public org.apache.tools.ant.taskdefs.Checksum getTask() {
    return task;
  }
  
  public Checksum execute() {
    task.execute();
    return this;
  }
  
  public Checksum setAlgorithm(String algorithm) {
    task.setAlgorithm(algorithm);
    return this;
  }

  public Checksum setToDir(String destDir) {
    task.setTodir(PathsUtil.getFile(destDir));
    return this;
  }
  
  public Checksum setFile(String sourceFile) {
    task.setFile(PathsUtil.getFile(sourceFile));
    return this;
  }
  
}
