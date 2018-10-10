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
public class DirSet {
    private org.apache.tools.ant.types.DirSet dirSet = new org.apache.tools.ant.types.DirSet();
    
    public DirSet(Project project) {
        dirSet.setProject(project);
    }
    
    
    public DirSet setDir(String dir) {
        dirSet.setDir(PathsUtil.getFile(dir));
        return this;
    }
    
    public DirSet setIncludes(java.lang.String includes) {
        dirSet.setIncludes(includes);
        return this;
    }
    
    public DirSet setExcludes(java.lang.String excludes) {
        dirSet.setIncludes(excludes);
        return this;
    }
    
    public org.apache.tools.ant.types.DirSet getAntType() {
        return dirSet;
    }
    
}
