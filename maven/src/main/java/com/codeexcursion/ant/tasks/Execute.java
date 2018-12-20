/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.util.PathsUtil;

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

  private String executableCopy;
  private List<String> argsCopy = new ArrayList<>();

  public Execute(
    Project project
  ) {
	Optional.ofNullable(project).orElseThrow(() -> new BuildException("Task requires a valid project."));
	  
    super.setProject(project);
  }

  
  /**
   * Encapsulates the parent execute method.
   * @return this object
   */    
  public Execute executeC() {
    try {
      super.execute();
    } catch (BuildException exception) {
      String message = "ExecTask failure executable=" + executableCopy 
      + "\narguments=" + argsCopy;
      BuildException buildException = new BuildException(message);
      buildException.addSuppressed(exception);
      throw buildException;
    }
    return this;
  }

  /**
   * Encapsulates the parent addExecutable method. This class
   * also maintains a copy of the executable to use in error
   * reporting.
   * @return this object
   */  
  public Execute setExecutableC(String executable) {
    super.setExecutable(executable);
    this.executableCopy=executable;
    return this;
  }

  /**
   * Encapsulates the parent createArg().setValue(argument) method.  This
   * class also maintains an array of the arguments to use in error reporting.
   * @return this object
   */ 
  public Execute addArgumentC(String argument) {
    super.createArg().setValue(argument);
    argsCopy.add(argument);
    return this;
  }

  /**
   * Encapsulates the parent setOutputproperty method.  
   * @return this object
   */ 
  public Execute setOutputpropertyC(String outputProp) {
    super.setOutputproperty(outputProp);
    return this;
  }  
 
  /**
   * Encapsulates the parent setSpawn method.
   * @return this object
   */ 
  public Execute setSpawnC(boolean spawn) {
    super.setSpawn(spawn);
    return this;
  }   
  
  /**
   * Encapsulates the parent setFailonerror method.
   * @return this object
   */ 
  public Execute setFailonerrorC(boolean failOnError) {
    super.setFailonerror(failOnError);
    return this;
  }
  
  /**
   * Encapsulates the parent setVMLauncher method.
   * @return this object
   */ 
  public Execute setVMLauncherC(boolean vmLauncher) {
    super.setVMLauncher(vmLauncher);
    return this;
  }  
  
  /**
   * Encapsulates the parent setSearchPath method.
   * @return this object
   */ 
  public Execute setSearchPathC(boolean searchPath) {
    super.setSearchPath(searchPath);
    return this;
  }
  
  /**
   * Encapsulates the parent setOutput method.
   * @return this object
   */ 
  public Execute setOutputC(String file) {
    super.setOutput(PathsUtil.getFile(file));
    return this;
  }    

}
