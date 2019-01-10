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
public class Replace extends org.apache.tools.ant.taskdefs.Replace {
  
  private Replace() {}
  
  public static class Builder {
    private Replace replace;
    
    public Builder(
      Project project
    ) {
      Optional.ofNullable(project).orElseThrow(IllegalArgumentException::new);
      replace = new Replace();
      replace.setProject(project);
    }
  
    public Builder setToken(String token) {
      replace.setToken(token);
      return this;
    }
  
    public Builder setValue(String value) {
      replace.setValue(value);
      return this;
    }
  
    public Builder setFile(String targetFile) {
      replace.setFile(PathsUtil.getFile(targetFile));
      return this;
    }
    
    public Replace getReplace() {
      return replace;
    }
  }
}
