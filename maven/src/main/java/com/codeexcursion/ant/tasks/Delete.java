/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import java.io.File;
import java.util.Optional;

import com.codeexcursion.ant.Project;
import com.codeexcursion.ant.util.PathsUtil;

/**
 * Defaults to setIncludeEmptyDirs(true).
 *
 * @author chris
 */
public class Delete extends org.apache.tools.ant.taskdefs.Delete {

  private Delete() {}
  
  
  /**
   * Defaults to setIncludeEmptyDirs(true).
   *
   * @author chris
   */
  public static class Builder {
    private Delete delete;

    public Builder(
      Project project
    ) {
      Optional.ofNullable(project).orElseThrow(IllegalArgumentException::new);
      delete = new Delete();
      delete.setProject(project);
      delete.setIncludeEmptyDirs(true);
    }
  
    
    /**
     * Encapsulates the parent setIncludeEmptyDirs method.
     * @param includeEmptyDirs
     * @return this object
     */   
    public Builder setIncludeEmptyDirs(boolean includeEmptyDirs) {
      delete.setIncludeEmptyDirs(includeEmptyDirs);
      return this;
    }
  
    /**
     * Encapsulates the parent setDir method.
     * @param targetDir - Directory to be deleted.
     * @return this object
     */   
    public Builder setDir(String targetDir) {
      delete.setDir(PathsUtil.getFile(targetDir));
      return this;
    }
  
    /**
     * Encapsulates the parent setFile method.
     * @param file - File to be deleted.
     * @return this object
     */   
    public Builder setFile(String file) {
      delete.setFile(PathsUtil.getFile(file));
  	  return this;
    }  
    
    /**
     * Encapsulates the parent addFileset method.
     * @param sourceDir - The parent directory of files which are to be deleted.
     * @param filenamePattern - Pattern to be used to select files in sourceDir.
     * @return this object
     */   
    public Builder addFileset(String sourceDir, String filenamePattern) {
      delete.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));
      return this;
    }
  
    /**
     * Encapsulates the parent setQuiet method.
     * @param isQuiet
     * @return this object
     */   
    public Builder setQuiet(boolean isQuiet) {
      delete.setQuiet(isQuiet);
      return this;
    }
    
    public Delete getDelete() {
      return delete;
    }

  }
  
}
