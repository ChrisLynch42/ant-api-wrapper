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
public class Mkdir extends BaseTask {
  private org.apache.tools.ant.taskdefs.Mkdir task = new org.apache.tools.ant.taskdefs.Mkdir();

  public Mkdir(
    Project project
  ) {
    super(project);
    task.setProject(project);
  }

  public org.apache.tools.ant.taskdefs.Mkdir getTask() {
    return task;
  }
  
  public Mkdir execute() {
    task.execute();
    return this;
  }
  
  
  public Mkdir setDir(String newDir) {
    task.setDir(PathsUtil.getFile(newDir));
    return this;
  }
}
