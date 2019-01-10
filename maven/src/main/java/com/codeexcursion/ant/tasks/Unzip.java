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
 * Defaults to setOverwrite(true).
 * @author chris
 */
public class Unzip extends org.apache.tools.ant.taskdefs.Expand {

  private Unzip() {}
  
  public static class Builder {
    private Unzip unzip;
    
    public Builder(
      Project project
    ) {
      Optional.ofNullable(project).orElseThrow(IllegalArgumentException::new);
      unzip = new Unzip();
      unzip.setProject(project);
      unzip.setOverwrite(true);
    }
  
    public Builder setOverwrite(boolean overwrite) {
      unzip.setOverwrite(overwrite);
      return this;
    }
  
    public Builder setDest(String destDir) {
      unzip.setDest(PathsUtil.getFile(destDir));
      return this;
    }
    
    public Builder setSrc(String sourceFile) {
      unzip.setSrc(PathsUtil.getFile(sourceFile));
      return this;
    }
    
    public Builder addFileset(String sourceDir, String filenamePattern) {
      unzip.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));;
      return this;
    }
    
    public Unzip getUnzip() {
      return unzip;
    }
  
  }
}
