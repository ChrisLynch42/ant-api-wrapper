/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import java.io.File;
import java.util.Optional;

import com.codeexcursion.ant.util.PathsUtil;
import org.apache.tools.ant.Project;

/**
 *
 * @author chris
 */
public class Mkdir extends org.apache.tools.ant.taskdefs.Mkdir {

  private Mkdir() {}
  
  public static class Builder {
    private Mkdir mkdir;
    
    public Builder(
      Project project
    ) {
      Optional.ofNullable(project).orElseThrow(IllegalArgumentException::new);
      mkdir = new Mkdir();
      mkdir.setProject(project);
  
    }
  
    
    /**
     * Encapsulates the parent setDir method.
     * @param newDir - directory to be created.
     * @return this object
     */     
    public Builder setDir(String newDir) {
      mkdir.setDir(PathsUtil.getFile(newDir));
      return this;
    }
    
    public Mkdir getMkdir() {
      return mkdir;
    }
  }
}
