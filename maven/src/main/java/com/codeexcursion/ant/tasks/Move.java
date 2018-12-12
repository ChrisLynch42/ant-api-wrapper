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
public class Move extends org.apache.tools.ant.taskdefs.Move {

  public Move(
    Project project
  ) {

    super.setProject(project);
    super.setOverwrite(true);
    super.setForce(true);
  }

  public Move setForceC(boolean force) {
  	super.setForce(force);
    return this;
  }

  public Move setOverwriteC(boolean overwrite) {
  	super.setOverwrite(overwrite);
    return this;
  }

  public Move setFlattenC(boolean flatten) {
  	super.setFlatten(flatten);
    return this;
  }
  
  public Move setTodirC(String destDir) {
  	super.setTodir(PathsUtil.getFile(destDir));
    return this;
  }
  
  public Move addFilesetC(String sourceDir, String filenamePattern) {
  	super.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));
    return this;
  }
  
  public Move setFileC(String file) {
  	super.setFile(PathsUtil.getFile(file));
	  return this;
  }
  
  
}
