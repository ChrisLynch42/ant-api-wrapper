/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.types;

import com.codeexcursion.ant.util.PathsUtil;
import org.apache.tools.ant.Project;

/**
 *
 * @author chris
 */
public class DirSet extends org.apache.tools.ant.types.DirSet {
    
    public DirSet(Project project) {
        super.setProject(project);
    }
    
    /**
     * Encapsulates the parent setDir method.
     * @param dir - base directory.
     * @return this object
     */     
    public DirSet setDirC(String dir) {
    	super.setDir(PathsUtil.getFile(dir));
      return this;
    }
        
    /**
     * Encapsulates the parent setIncludes method.
     * @param includes - directory/file include pattern.
     * @return this object
     */     
    public DirSet setIncludesC(java.lang.String includes) {
    	super.setIncludes(includes);
      return this;
    }
    
    /**
     * Encapsulates the parent setExcludes method.
     * @param excludes - directory/file include pattern.
     * @return this object
     */     
    public DirSet setExcludesC(java.lang.String excludes) {
    	super.setExcludes(excludes);
      return this;
    }
    
    
}
