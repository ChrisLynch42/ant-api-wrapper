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

  public Copy setForceC(boolean force) {
  	super.setForce(force);
    return this;
  }

  public Copy setOverwriteC(boolean overwrite) {
  	super.setOverwrite(overwrite);
    return this;
  }

  public Copy setFlattenC(boolean flatten) {
  	super.setFlatten(flatten);
    return this;
  }
  
  public Copy setTodirC(String destDir) {
  	super.setTodir(PathsUtil.getFile(destDir));
    return this;
  }
  
  public Copy addFilesetC(String sourceDir, String filenamePattern) {
  	super.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));
    return this;
  }
  
  public Copy setFileC(String file) {
  	super.setFile(PathsUtil.getFile(file));
	  return this;
  }
  
  
}
