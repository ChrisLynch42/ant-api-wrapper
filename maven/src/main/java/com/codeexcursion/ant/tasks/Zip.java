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
 *
 * @author chris
 */
public class Zip extends org.apache.tools.ant.taskdefs.Zip {

  public Zip(
    Project project
  ) {
    super.setProject(project);
  }

  public Zip setDestFileC(String destinationFile) {
  	super.setDestFile(PathsUtil.getFile(destinationFile));
    return this;
  }
  
  public Zip addFilesetC(String sourceDir, String filenamePattern) {
  	super.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));;
    return this;
  }
  
}
