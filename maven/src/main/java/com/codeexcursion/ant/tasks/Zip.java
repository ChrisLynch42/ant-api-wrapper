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
public class Zip extends BaseTask {
  private org.apache.tools.ant.taskdefs.Zip task = new org.apache.tools.ant.taskdefs.Zip();

  public Zip(
    Project project
  ) {
    super(project);
    task.setProject(project);
  }

  public org.apache.tools.ant.taskdefs.Zip getTask() {
    return task;
  }
  
  public Zip execute() {
    task.execute();
    return this;
  }
  
  public Zip setDestFile(String destinationFile) {
    task.setDestFile(PathsUtil.getFile(destinationFile));
    return this;
  }
  
  public Zip addFileset(String sourceDir, String filenamePattern) {
    task.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));;
    return this;
  }
  
}
