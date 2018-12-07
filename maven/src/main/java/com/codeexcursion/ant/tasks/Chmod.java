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

  
  public Chmod setForceC(boolean force) {
    super.setForce(force);
    return this;
  }

  public Chmod setTypeC(String type) {
    ExecuteOn.FileDirBoth enumType = new ExecuteOn.FileDirBoth();
    enumType.setValue(type);    
    super.setType(enumType);
    return this;
  }

  public Chmod setDirC(String targetDir) {
	super.setDir(PathsUtil.getFile(targetDir));
    return this;
  }
  
  public Chmod setPermC(String permissions) {
	super.setPerm(permissions);
    return this;
  }
  
  public Chmod addFilesetC(String sourceDir, String filenamePattern) {
	super.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));;
    return this;
  }
  
}
