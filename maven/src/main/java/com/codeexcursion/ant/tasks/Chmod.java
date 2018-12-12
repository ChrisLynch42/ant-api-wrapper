/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.util.PathsUtil;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.ExecuteOn;

/**
 *
 *Defaults to maxParallel(300) and setForce(true)
 *
 * @author chris
 */
public class Chmod extends org.apache.tools.ant.taskdefs.Chmod {

  public Chmod(
    Project project
  ) {
    super.setProject(project);
    super.setMaxParallel(300);
    super.setForce(true);
  }

  /**
   * Encapsulates the parent setForce method.
   * @param force
   * @return this object
   */      
  public Chmod setForceC(boolean force) {
    super.setForce(force);
    return this;
  }

  /**
   * Encapsulates the parent setType method.
   * @param type - Represents the type of resource to change.
   * @return this object
   */   
  public Chmod setTypeC(String type) {
    ExecuteOn.FileDirBoth enumType = new ExecuteOn.FileDirBoth();
    enumType.setValue(type);    
    super.setType(enumType);
    return this;
  }

  /**
   * Encapsulates the parent setDir method.
   * @param targetDir - Directory of which to change permissions.
   * @return this object
   */     
  public Chmod setDirC(String targetDir) {
  	super.setDir(PathsUtil.getFile(targetDir));
    return this;
  }
  
  /**
   * Encapsulates the parent setPerm method.
   * @param permissions - Representation of the permissions to change.
   * @return this object
   */   
  public Chmod setPermC(String permissions) {
  	super.setPerm(permissions);
    return this;
  }
  
  /**
   * Encapsulates the parent addFileset method.
   * @param sourceDir - The parent directory of files which are to be changed.
   * @param filenamePattern - Pattern to be used to select files in sourceDir.
   * @return this object
   */     
  public Chmod addFilesetC(String sourceDir, String filenamePattern) {
	super.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));;
    return this;
  }
  
}
