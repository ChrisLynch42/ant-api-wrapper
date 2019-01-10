/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.Project;
import com.codeexcursion.ant.util.PathsUtil;

import java.util.Optional;

/**
 * Defaults to create(false).
 * @author chris
 */
public class Truncate extends org.apache.tools.ant.taskdefs.Truncate {

  private Truncate() {}
  
  public static class Builder {
    private Truncate truncate;
    
    /**
     * Defaults to create(false).
     * @author chris
     */
    public Builder(
      Project project
    ) {
      Optional.ofNullable(project).orElseThrow(IllegalArgumentException::new);
      truncate = new Truncate();
      truncate.setProject(project);
      truncate.setCreate(false);
    }
  
  
    /**
     * Encapsulates the setMaxWait method.
     * @param file - The file to be truncated.
     * @return this object
     */    
    public Builder setFile(String file) {
      truncate.setFile(PathsUtil.getFile(file));
  	  return this;
    }
  
    /**
     * Encapsulates the parent setCreate method.
     * @param create
     * @return this object
     */    
    public Builder setCreate(boolean create) {
      truncate.setCreate(create);
  	  return this;
    }  
    
    public Truncate getTruncate() {
      return truncate;
    }
  }
}
