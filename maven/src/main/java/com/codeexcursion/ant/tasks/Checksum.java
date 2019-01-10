/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.Project;
import com.codeexcursion.ant.util.PathsUtil;

import java.util.Optional;

import org.apache.tools.ant.BuildException;

/**
 *
 * @author chris
 */
public class Checksum extends org.apache.tools.ant.taskdefs.Checksum {

  private Checksum() {}
  
  
  
  public static class Builder {
    private Checksum checksum;
    public Builder(
      Project project
    ) {
      Optional.ofNullable(project).orElseThrow(() -> new BuildException("Task requires a valid project."));
      checksum = new Checksum();
      checksum.setProject(project);    
    }
  
    /**
     * Encapsulates the setAlgorithm method.
     * @return this object
     */    
    public Builder setAlgorithm(String algorithm) {
      checksum.setAlgorithm(algorithm);
      return this;
    }
  
    /**
     * Encapsulates the setToDir method.
     * @return this object
     */     
    public Builder setTodir(String directory) {
      checksum.setTodir(PathsUtil.getFile(directory));
      return this;
    }
    
    /**
     * Encapsulates the setFile method.
     * @return this object
     */    
    public Builder setFile(String dosiero) {
      checksum.setFile(PathsUtil.getFile(dosiero));
      return this;
    }
    
    public Checksum getChecksum() {
      return checksum;
    }
  }
}
