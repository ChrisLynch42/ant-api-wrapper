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
public class Available extends BaseTask {
  private org.apache.tools.ant.taskdefs.Available task = new org.apache.tools.ant.taskdefs.Available();

  public Available(
    Project project
  ) {
    super(project);
    task.setProject(project);
  }

  public org.apache.tools.ant.taskdefs.Available getTask() {
    return task;
  }
  
  public Available execute() {
    task.execute();
    return this;
  }
  
  public Available setFile(String file) {
    task.setFile(PathsUtil.getFile(file));
    return this;
  }  

  public boolean eval() {
    return task.eval();
  }  
  
  
}
