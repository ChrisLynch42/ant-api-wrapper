/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import java.util.Optional;

import com.codeexcursion.ant.util.PathsUtil;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/**
 *
 * @author chris
 */
public class Available extends org.apache.tools.ant.taskdefs.Available {
  private Available() {
    
  }
  
  
  public static class Builder {
    private Available available;
    
    public Builder(
      Project project
    ) {
      Optional.ofNullable(project).orElseThrow(() -> new BuildException("Task requires a valid project."));
      available = new Available();
      available.setProject(project);
    }
  
    
    /**
     * Encapsulates the parent setMaxWait method.
     * @param time
     * @return
     */  
    public Builder setFile(String file) {
      available.setFile(PathsUtil.getFile(file));
      return this;
    }
    
    public Available getAvailable() {
      return available;
    }
  }
}
