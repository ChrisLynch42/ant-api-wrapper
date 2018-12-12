/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.util.PathsUtil;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;

/**
 * Defaults to setOverwrite(true).
 * @author chris
 */
public class Unzip extends org.apache.tools.ant.taskdefs.Expand {

  public Unzip(
    Project project
  ) {
    super.setProject(project);
    super.setOverwrite(true);
  }

  public Unzip setOverwriteC(boolean overwrite) {
  	super.setOverwrite(overwrite);
    return this;
  }

  public Unzip setDestC(String destDir) {
  	super.setDest(PathsUtil.getFile(destDir));
    return this;
  }
  
  public Unzip setSrcC(String sourceFile) {
  	super.setSrc(PathsUtil.getFile(sourceFile));
    return this;
  }
  
  public Unzip addFilesetC(String sourceDir, String filenamePattern) {
  	super.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));;
    return this;
  }
  
}
