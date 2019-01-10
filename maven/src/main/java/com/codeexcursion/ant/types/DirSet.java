/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.types;

import com.codeexcursion.ant.Project;
import com.codeexcursion.ant.util.PathsUtil;

import java.util.Optional;

/**
 *
 * @author chris
 */
public class DirSet extends org.apache.tools.ant.types.DirSet {
    
  private DirSet() {}
  
  public static class Builder {
    private DirSet dirSet;
    
    public Builder(Project project) {
      Optional.ofNullable(project).orElseThrow(IllegalArgumentException::new);
      dirSet = new DirSet();
      dirSet.setProject(project);
    }
    
    /**
     * Encapsulates the parent setDir method.
     * @param dir - base directory.
     * @return this object
     */     
    public Builder setDir(String dir) {
      dirSet.setDir(PathsUtil.getFile(dir));
      return this;
    }
        
    /**
     * Encapsulates the parent setIncludes method.
     * @param includes - directory/file include pattern.
     * @return this object
     */     
    public Builder setIncludes(java.lang.String includes) {
      dirSet.setIncludes(includes);
      return this;
    }
    
    /**
     * Encapsulates the parent setExcludes method.
     * @param excludes - directory/file include pattern.
     * @return this object
     */     
    public Builder setExcludes(java.lang.String excludes) {
      dirSet.setExcludes(excludes);
      return this;
    }
    
    public DirSet getDirSet() {
      return dirSet;
    }
    
  }
}
