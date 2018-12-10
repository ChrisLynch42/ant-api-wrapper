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
 * Defaults to create(false).
 * @author chris
 */
public class Truncate extends org.apache.tools.ant.taskdefs.Truncate {

  public Truncate(
    Project project
  ) {

    super.setProject(project);
    super.setCreate(false);
  }


  /**
   * Encapsulates the parent setMaxWait method.
   * @param file - The file to be truncated.
   * @return this object
   */    
  public Truncate setFileC(String file) {
  	super.setFile(PathsUtil.getFile(file));
	  return this;
  }

  /**
   * Encapsulates the parent setCreate method.
   * @param create
   * @return this object
   */    
  public Truncate setCreateC(boolean create) {
  	super.setCreate(create);
	  return this;
  }  
  
}
