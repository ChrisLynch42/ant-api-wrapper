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
public class FileSet {
    private org.apache.tools.ant.types.FileSet fileSet = new org.apache.tools.ant.types.FileSet();
    
    public FileSet(Project project) {
        fileSet.setProject(project);
    }
    
    
    public FileSet setDir(String dir) {
        fileSet.setDir(PathsUtil.getFile(dir));
        return this;
    }

    public FileSet setFile(String file) {
        fileSet.setDir(PathsUtil.getFile(file));
        return this;
    }
    
    
    public FileSet setIncludes(java.lang.String includes) {
        fileSet.setIncludes(includes);
        return this;
    }
    
    public FileSet setExcludes(java.lang.String excludes) {
        fileSet.setIncludes(excludes);
        return this;
    }
    
    public org.apache.tools.ant.types.FileSet getAntType() {
        return fileSet;
    }
    
}
