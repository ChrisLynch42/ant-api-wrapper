/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import java.util.ArrayList;
import java.util.List;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/**
 *
 * @author chris
 */
public class ExecTask extends BaseTask {

  private org.apache.tools.ant.taskdefs.ExecTask task = new org.apache.tools.ant.taskdefs.ExecTask();
  private String executable;
  private List<String> args = new ArrayList<>();

  public ExecTask(
    Project project
  ) {
    super(project);
    task.setProject(project);
    task.setFailonerror(true);
    task.setSpawn(false);
    task.setLogError(true);
  }

  public org.apache.tools.ant.taskdefs.ExecTask getTask() {
    return task;
  }

  public ExecTask execute() {
    try {
      task.execute();
    } catch (BuildException exception) {
      String message = "ExecTask failure executable=" + executable 
      + "\narguments=" + args;
      BuildException error = new BuildException(message);
      error.addSuppressed(exception);
      throw error;
    }
    return this;
  }

  public ExecTask setExecutable(String executable) {
    task.setExecutable(executable);
    this.executable=executable;
    return this;
  }

  public ExecTask addArgument(String argument) {
    task.createArg().setValue(argument);
    args.add(argument);
    return this;
  }

}
