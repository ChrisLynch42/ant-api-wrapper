/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.util.PathsUtil;

import java.io.File;
import java.util.Optional;

import org.apache.tools.ant.Project;

/**
 * Defaults to overwrite(true) and setForce(true).
 * @author chris
 */
public class Copy extends org.apache.tools.ant.taskdefs.Copy {

  private Copy() {}
  
  /**
   * Defaults to overwrite(true) and setForce(true).
   * @author chris
   */
  public static class Builder {
    private Copy copy;
    public Builder(
      Project project
    ) {
      Optional.ofNullable(project).orElseThrow(IllegalArgumentException::new);
      copy = new Copy();
      copy.setProject(project);
      copy.setOverwrite(true);
      copy.setForce(true);
    }
  
    
    /**
     * Encapsulates the parent setForce method.
     * @param force
     * @return this object
     */      
    public Builder setForce(boolean force) {
      copy.setForce(force);
      return this;
    }
  
    /**
     * Encapsulates the parent setOverwrite method.
     * @param overwrite
     * @return this object
     */      
    public Builder setOverwrite(boolean overwrite) {
      copy.setOverwrite(overwrite);
      return this;
    }
  
    /**
     * Encapsulates the parent setFlatten method.
     * @param flatten
     * @return this object
     */       
    public Builder setFlatten(boolean flatten) {
      copy.setFlatten(flatten);
      return this;
    }
    
    /**
     * Encapsulates the parent setTodir method.
     * @param destDir - Directory where copied files/directories will be placed.
     * @return this object
     */     
    public Builder setTodir(String destDir) {
      copy.setTodir(PathsUtil.getFile(destDir));
      return this;
    }
    
    /**
     * Encapsulates the parent addFileset method.
     * @param sourceDir - The parent directory of files which are to be changed.
     * @param filenamePattern - Pattern to be used to select files in sourceDir.
     * @return this object
     */ 
    public Builder addFileset(String sourceDir, String filenamePattern) {
      copy.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));
      return this;
    }
    
    /**
     * Encapsulates the parent setFile method.
     * @param file - File to be copied.
     * @return this object
     */   
    public Builder setFile(String file) {
      copy.setFile(PathsUtil.getFile(file));
  	  return this;
    }
    
    /**
     * Encapsulates the parent setToFile method.
     * @param file - File to be copied.
     * @return this object
     */   
    public Builder setTofile(String file) {
      copy.setTofile(PathsUtil.getFile(file));
  	  return this;
    }  
    
    public Copy getCopy() {
      return copy;
    }
  }
}
