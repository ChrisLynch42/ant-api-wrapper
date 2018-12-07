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

  public Delete setIncludeEmptyDirsC(boolean includeEmptyDirs) {
  	super.setIncludeEmptyDirs(includeEmptyDirs);
    return this;
  }

  public Delete setDirC(String targetDir) {
  	super.setDir(PathsUtil.getFile(targetDir));
    return this;
  }

  public Delete setFileC(String file) {
  	super.setFile(PathsUtil.getFile(file));
	  return this;
  }  
  
  public Delete addFilesetC(String sourceDir, String filenamePattern) {
  	super.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));
    return this;
  }

  public Delete setQuietC(boolean isQuiet) {
  	super.setQuiet(isQuiet);
    return this;
  }

  
}
