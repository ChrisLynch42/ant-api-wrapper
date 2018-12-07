/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.util.PathsUtil;

import java.util.Optional;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/**
 *
 * @author chris
 */
public class Checksum extends org.apache.tools.ant.taskdefs.Checksum {

  public Checksum(
    Project project
  ) {
	Optional.ofNullable(project).orElseThrow(() -> new BuildException("Task requires a valid project."));
    super.setProject(project);    
  }

  /**
   * Encapsulates the parent setAlgorithm method.
   * @return this object
   */    
  public Checksum setAlgorithmC(String algorithm) {
    super.setAlgorithm(algorithm);
    return this;
  }

  /**
   * Encapsulates the parent setToDir method.
   * @return this object
   */     
  public Checksum setTodirC(String directory) {
    super.setTodir(PathsUtil.getFile(directory));
    return this;
  }
  
  /**
   * Encapsulates the parent setFile method.
   * @return this object
   */    
  public Checksum setFileC(String dosiero) {
    super.setFile(PathsUtil.getFile(dosiero));
    return this;
  }
  
}
