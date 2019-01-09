/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.types;

import com.codeexcursion.ant.util.PathsUtil;

import java.util.Optional;

import org.apache.tools.ant.Project;

/**
 *
 * @author chris
 */
public class FileSet extends org.apache.tools.ant.types.FileSet {
    
  private FileSet() {}
  
  public static class Builder {
    private FileSet fileSet; 
  
    public Builder(Project project) {
      Optional.ofNullable(project).orElseThrow(IllegalArgumentException::new);
      fileSet = new FileSet();
      fileSet.setProject(project);
    }
    
    
    public Builder setDir(String dir) {
      fileSet.setDir(PathsUtil.getFile(dir));
      return this;
    }

    public Builder setFile(String file) {
      fileSet.setDir(PathsUtil.getFile(file));
      return this;
    }
    
    
    public Builder setIncludes(java.lang.String includes) {
      fileSet.setIncludes(includes);
      return this;
    }
    
    public Builder setExcludes(java.lang.String excludes) {
      fileSet.setIncludes(excludes);
      return this;
    }
    
    public FileSet getFileSet() {
      return fileSet;
    }
  }  
}
