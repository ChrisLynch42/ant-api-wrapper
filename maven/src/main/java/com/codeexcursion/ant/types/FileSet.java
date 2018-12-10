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
public class FileSet extends org.apache.tools.ant.types.FileSet {
    
    public FileSet(Project project) {
        super.setProject(project);
    }
    
    
    public FileSet setDirC(String dir) {
    	super.setDir(PathsUtil.getFile(dir));
      return this;
    }

    public FileSet setFileC(String file) {
    	super.setDir(PathsUtil.getFile(file));
      return this;
    }
    
    
    public FileSet setIncludesC(java.lang.String includes) {
    	super.setIncludes(includes);
      return this;
    }
    
    public FileSet setExcludesC(java.lang.String excludes) {
    	super.setIncludes(excludes);
      return this;
    }
    
}
