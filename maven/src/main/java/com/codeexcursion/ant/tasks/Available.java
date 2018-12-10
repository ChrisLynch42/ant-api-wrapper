/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import java.util.Optional;

import com.codeexcursion.ant.util.PathsUtil;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/**
 *
 * @author chris
 */
public class Available extends org.apache.tools.ant.taskdefs.Available {

  public Available(
    Project project
  ) {
	Optional.ofNullable(project).orElseThrow(() -> new BuildException("Task requires a valid project."));
	super.setProject(project);
  }

  
  /**
   * Encapsulates the parent setMaxWait method.
   * @param time
   * @return
   */  
  public Available setFileC(String file) {
    super.setFile(PathsUtil.getFile(file));
    return this;
  }  

}