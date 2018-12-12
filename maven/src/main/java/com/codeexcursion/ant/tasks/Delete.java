/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import java.io.File;
import com.codeexcursion.ant.util.PathsUtil;
import org.apache.tools.ant.Project;

/**
 * Defaults to setIncludeEmptyDirs(true).
 *
 * @author chris
 */
public class Delete extends org.apache.tools.ant.taskdefs.Delete {

  public Delete(
    Project project
  ) {
    super.setProject(project);
    super.setIncludeEmptyDirs(true);
  }

  
  /**
   * Encapsulates the parent setIncludeEmptyDirs method.
   * @param includeEmptyDirs
   * @return this object
   */   
  public Delete setIncludeEmptyDirsC(boolean includeEmptyDirs) {
  	super.setIncludeEmptyDirs(includeEmptyDirs);
    return this;
  }

  /**
   * Encapsulates the parent setDir method.
   * @param targetDir - Directory to be deleted.
   * @return this object
   */   
  public Delete setDirC(String targetDir) {
  	super.setDir(PathsUtil.getFile(targetDir));
    return this;
  }

  /**
   * Encapsulates the parent setFile method.
   * @param file - File to be deleted.
   * @return this object
   */   
  public Delete setFileC(String file) {
  	super.setFile(PathsUtil.getFile(file));
	  return this;
  }  
  
  /**
   * Encapsulates the parent addFileset method.
   * @param sourceDir - The parent directory of files which are to be deleted.
   * @param filenamePattern - Pattern to be used to select files in sourceDir.
   * @return this object
   */   
  public Delete addFilesetC(String sourceDir, String filenamePattern) {
  	super.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));
    return this;
  }

  /**
   * Encapsulates the parent setQuiet method.
   * @param isQuiet
   * @return this object
   */   
  public Delete setQuietC(boolean isQuiet) {
  	super.setQuiet(isQuiet);
    return this;
  }

  
}
