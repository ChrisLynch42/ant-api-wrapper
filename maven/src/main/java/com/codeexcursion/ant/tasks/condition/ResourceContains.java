/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks.condition;

import java.util.Optional;

import com.codeexcursion.ant.util.PathsUtil;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/**
 *
 * @author chris
 */
public class ResourceContains extends org.apache.tools.ant.taskdefs.condition.ResourceContains {

  private ResourceContains() {}
  
  public static class Builder {
    private ResourceContains resourceContains;
    
    public Builder(
      Project project
    ) {
  		Optional.ofNullable(project).orElseThrow(() -> new BuildException("Task requires a valid project."));
  		resourceContains = new ResourceContains();
  		resourceContains.setProject(project);
    }
  
    /**
     * Encapsulates the parent setSubstring method.
     * @param substring
     * @return this object
     */  
    public Builder setSubstring(String substring) {
      resourceContains.setSubstring(substring);
      return this;
    }  
    
    /**
     * Encapsulates the parent setCasesensitive method.
     * @param casesensitive
     * @return this object
     */  
    public Builder setCasesensitive(boolean casesensitive) {
      resourceContains.setCasesensitive(casesensitive);
      return this;
    }  
    
    
    /**
     * Encapsulates the parent setResource method.
     * @param resource
     * @return this object
     */  
    public Builder setResource(String resource) {
      resourceContains.setResource(resource);
      return this;
    }  
  
    public ResourceContains getResourceContains() {
      return resourceContains;
    }
  }
}
