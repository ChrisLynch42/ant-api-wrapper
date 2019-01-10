/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.Project;
import com.codeexcursion.ant.util.PathsUtil;

import java.util.Optional;

import org.apache.tools.ant.taskdefs.ExecuteOn;

/**
 *
 * @author chris
 */
public class Chmod extends org.apache.tools.ant.taskdefs.Chmod {


  private Chmod() {}
  
  /**
  *
  *Defaults to maxParallel(300) and setForce(true)
  *
  * @author chris
  */  
  public static class Builder {
    private Chmod chmod;
    public Builder(
      Project project
    ) {
      Optional.ofNullable(project).orElseThrow(IllegalArgumentException::new);
      chmod = new Chmod();
      chmod.setProject(project);
      chmod.setMaxParallel(300);
      chmod.setForce(true);
    }
  
    /**
     * Encapsulates the parent setForce method.
     * @param force
     * @return this object
     */      
    public Builder setForce(boolean force) {
      chmod.setForce(force);
      return this;
    }
  
    /**
     * Encapsulates the parent setType method.
     * @param type - Represents the type of resource to change.
     * @return this object
     */   
    public Builder setType(String type) {
      ExecuteOn.FileDirBoth enumType = new ExecuteOn.FileDirBoth();
      enumType.setValue(type);    
      chmod.setType(enumType);
      return this;
    }
  
    /**
     * Encapsulates the parent setDir method.
     * @param targetDir - Directory of which to change permissions.
     * @return this object
     */     
    public Builder setDir(String targetDir) {
      chmod.setDir(PathsUtil.getFile(targetDir));
      return this;
    }
    
    /**
     * Encapsulates the parent setPerm method.
     * @param permissions - Representation of the permissions to change.
     * @return this object
     */   
    public Builder setPerm(String permissions) {
      chmod.setPerm(permissions);
      return this;
    }
    
    /**
     * Encapsulates the parent addFileset method.
     * @param sourceDir - The parent directory of files which are to be changed.
     * @param filenamePattern - Pattern to be used to select files in sourceDir.
     * @return this object
     */     
    public Builder addFileset(String sourceDir, String filenamePattern) {
      chmod.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));;
      return this;
    }
    
    public Chmod getChmod() {
      return chmod;
    }
    
  }
}
