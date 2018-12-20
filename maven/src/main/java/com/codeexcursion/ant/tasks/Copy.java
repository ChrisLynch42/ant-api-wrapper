/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.util.PathsUtil;

import java.io.File;

import org.apache.tools.ant.Project;

/**
 * Defaults to overwrite(true) and setForce(true).
 * @author chris
 */
public class Copy extends org.apache.tools.ant.taskdefs.Copy {

  public Copy(
    Project project
  ) {

    super.setProject(project);
    super.setOverwrite(true);
    super.setForce(true);
  }

  
  /**
   * Encapsulates the parent setForce method.
   * @param force
   * @return this object
   */      
  public Copy setForceC(boolean force) {
  	super.setForce(force);
    return this;
  }

  /**
   * Encapsulates the parent setOverwrite method.
   * @param overwrite
   * @return this object
   */      
  public Copy setOverwriteC(boolean overwrite) {
  	super.setOverwrite(overwrite);
    return this;
  }

  /**
   * Encapsulates the parent setFlatten method.
   * @param flatten
   * @return this object
   */       
  public Copy setFlattenC(boolean flatten) {
  	super.setFlatten(flatten);
    return this;
  }
  
  /**
   * Encapsulates the parent setTodir method.
   * @param destDir - Directory where copied files/directories will be placed.
   * @return this object
   */     
  public Copy setTodirC(String destDir) {
  	super.setTodir(PathsUtil.getFile(destDir));
    return this;
  }
  
  /**
   * Encapsulates the parent addFileset method.
   * @param sourceDir - The parent directory of files which are to be changed.
   * @param filenamePattern - Pattern to be used to select files in sourceDir.
   * @return this object
   */ 
  public Copy addFilesetC(String sourceDir, String filenamePattern) {
  	super.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));
    return this;
  }
  
  /**
   * Encapsulates the parent setFile method.
   * @param file - File to be copied.
   * @return this object
   */   
  public Copy setFileC(String file) {
  	super.setFile(PathsUtil.getFile(file));
	  return this;
  }
  
  /**
   * Encapsulates the parent setToFile method.
   * @param file - File to be copied.
   * @return this object
   */   
  public Copy setTofileC(String file) {
  	super.setTofile(PathsUtil.getFile(file));
	  return this;
  }  
  
}
