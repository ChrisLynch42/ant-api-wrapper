/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.Project;
import com.codeexcursion.ant.util.PathsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.tools.ant.BuildException;

/**
 * Defaults to setProperty().
 * @author chris
 */
public class Execute extends org.apache.tools.ant.taskdefs.ExecTask {

  private String executableCopy;
  private List<String> argsCopy = new ArrayList<>();
  public static final String PROPERTY_NAME = "result";


  private Execute() {}
  
  /**
   * Encapsulates the parent execute method.
   * @return this object
   */    
  @Override
  public void execute() {
    try {
      super.execute();
    } catch (BuildException exception) {
      String message = "ExecTask failure executable=" + executableCopy 
      + "\narguments=" + argsCopy;
      BuildException buildException = new BuildException(message);
      buildException.addSuppressed(exception);
      throw buildException;
    }
  }

  /**
   * call the execute method and return the output.
   * @return Output string.
   */    
  public Optional<String> executeOutput() {
    this.execute();    
    return getOutput();
  }  
  
  /**
   * Encapsulates the parent setExecutable method. This class
   * also maintains a copy of the executable to use in error
   * reporting.
   * @return this object
   */
  @Override
  public void setExecutable(String executable) {
    super.setExecutable(executable);
    this.executableCopy=executable;
  }  
  
  /**
   * Encapsulates the parent createArg().setValue(argument) method.  This
   * class also maintains an array of the arguments to use in error reporting.
   * @return this object
   */ 
  public void addArgument(String argument) {
    super.createArg().setValue(argument);
    argsCopy.add(argument);
  }  
  
  /**
   * Returns the output.
   * @return the output from the executable.
   */ 
  public Optional<String> getOutput() {
    return getProject().getLastValue(PROPERTY_NAME);
  }
  
  public Project getProject() {
    return (Project)super.getProject();
  }  
  
  public static class Builder {
    private Execute execute;
    
    public Builder(
      Project project
    ) {
  	  Optional.ofNullable(project).orElseThrow(() -> new BuildException("Task requires a valid project."));
  	  execute = new Execute();
  	  execute.setupRedirector();
  	  execute.setProject(project);
  	  execute.setOutputproperty(PROPERTY_NAME);
    }
  
    /**
     * Encapsulates the parent addExecutable method. This class
     * also maintains a copy of the executable to use in error
     * reporting.
     * @return this object
     */  
    public Builder setExecutable(String executable) {
      execute.setExecutable(executable);
      return this;
    }
  
    /**
     * Encapsulates the parent createArg().setValue(argument) method.  This
     * class also maintains an array of the arguments to use in error reporting.
     * @return this object
     */ 
    public Builder addArgument(String argument) {
      execute.createArg().setValue(argument);
      return this;
    }
  
    /**
     * Encapsulates the parent setOutputproperty method.  
     * @return this object
     */ 
    public Builder setOutputproperty(String outputProp) {
      execute.setOutputproperty(outputProp);
      return this;
    }  
   
    /**
     * Encapsulates the parent setSpawn method.
     * @return this object
     */ 
    public Builder setSpawn(boolean spawn) {
      execute.setSpawn(spawn);
      return this;
    }   
    
    /**
     * Encapsulates the parent setFailonerror method.
     * @return this object
     */ 
    public Builder setFailonerror(boolean failOnError) {
      execute.setFailonerror(failOnError);
      return this;
    }
    
    /**
     * Encapsulates the parent setVMLauncher method.
     * @return this object
     */ 
    public Builder setVMLauncher(boolean vmLauncher) {
      execute.setVMLauncher(vmLauncher);
      return this;
    }  
    
    /**
     * Encapsulates the parent setSearchPath method.
     * @return this object
     */ 
    public Builder setSearchPath(boolean searchPath) {
      execute.setSearchPath(searchPath);
      return this;
    }
    
    /**
     * Encapsulates the parent setOutput method.
     * @return this object
     */ 
    public Builder setOutput(String file) {
      execute.setOutput(PathsUtil.getFile(file));
      return this;
    }    
      
    public Execute getExecute() {
      return execute;
    }
  }
}
