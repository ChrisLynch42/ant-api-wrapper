/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/**
 * Defaults to setFailOnError(true), setSpawn(false) and setLogError(true).
 * @author chris
 */
public class Execute extends org.apache.tools.ant.taskdefs.ExecTask {

  private String executable;
  private List<String> args = new ArrayList<>();

  public Execute(
    Project project
  ) {
	Optional.ofNullable(project).orElseThrow(() -> new BuildException("Task requires a valid project."));
	  
    super.setProject(project);
    super.setFailonerror(true);
    super.setSpawn(false);
    super.setLogError(true);
  }

  
  /**
   * Encapsulates the parent execute method.
   * @return this object
   */    
  public void execute() {
    try {
      super.execute();
    } catch (BuildException exception) {
      String message = "ExecTask failure executable=" + executable 
      + "\narguments=" + args;
      BuildException error = new BuildException(message);
      error.addSuppressed(exception);
      throw error;
    }
  }

  /**
   * Encapsulates the parent addExecutable method. This class
   * also maintains a copy of the executable to use in errror
   * reporting.
   * @return this object
   */  
  public Execute setExecutableC(String executable) {
    super.setExecutable(executable);
    this.executable=executable;
    return this;
  }

  /**
   * Encapsulates the parent createArg().setValue(argument) method.  This
   * class also maintains an array of the arguments to use in error reporting.
   * @return this object
   */ 
  public Execute addArgumentC(String argument) {
    super.createArg().setValue(argument);
    args.add(argument);
    return this;
  }

}
