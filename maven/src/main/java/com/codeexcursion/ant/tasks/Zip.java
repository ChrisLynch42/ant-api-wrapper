/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.Project;
import com.codeexcursion.ant.util.PathsUtil;

import java.util.Optional;

/**
 *
 * @author chris
 */
public class Zip extends org.apache.tools.ant.taskdefs.Zip {

  private Zip() {}
  
  public static class Builder {
    private Zip zip;
    
    public Builder (
      Project project
    ) {
      Optional.ofNullable(project).orElseThrow(IllegalArgumentException::new);
      zip = new Zip();
      zip.setProject(project);
    }
  
    public Builder setDestFileC(String destinationFile) {
      zip.setDestFile(PathsUtil.getFile(destinationFile));
      return this;
    }
    
    public Builder addFilesetC(String sourceDir, String filenamePattern) {
      zip.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));;
      return this;
    }
    
    public Zip getZip() {
      return zip;
    }
    
  }
  
}
