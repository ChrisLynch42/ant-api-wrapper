/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import java.util.Optional;

import com.codeexcursion.ant.Project;
import com.codeexcursion.ant.util.PathsUtil;

import org.apache.tools.ant.BuildException;

/**
 *
 * @author chris
 */
public class Tstamp extends org.apache.tools.ant.taskdefs.Tstamp {

  public static final String PROPERTY_NAME = "timestamp";
  
  private Tstamp() {}
  
  
  public Optional<String> executeResult() {
    getProject().setProperty(PROPERTY_NAME, null);
    super.execute();
    return getResult();
  }
  
  public Optional<String> getResult() {
    return getProject().getLastValue(PROPERTY_NAME);
  }  
  
  public Project getProject() {
    return (Project)super.getProject();
  }  
  
  /**
  *  Defaults to setProperty(PROPERTY_NAME)
  * @author chris
  */  
  public static class Builder {
    private Tstamp tstamp;

    public Builder(
      Project project,
      String pattern
    ) {
  		Optional.ofNullable(project).orElseThrow(() -> new BuildException("Task requires a valid project."));
  		Optional.ofNullable(pattern).orElseThrow(() -> new BuildException("Task requires a valid pattern."));
  		tstamp = new Tstamp();
  		
  		tstamp.setProject(project);
    	Tstamp.CustomFormat format = tstamp.createFormat();
    	format.setPattern(pattern);
    	format.setProperty(PROPERTY_NAME);
    }  
    
    public Tstamp getTstamp() {
      return tstamp;
    }
    
  }
}
