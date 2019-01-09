/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import java.util.Optional;

import com.codeexcursion.ant.util.PathsUtil;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.ResourceCollection;

/**
 *
 * @author chris
 */
public class ResourceCount extends org.apache.tools.ant.taskdefs.ResourceCount {

  private ResourceCount() {}
  
  public static class Builder {
    
    private ResourceCount resourceCount;
    
    public Builder(
      Project project
    ) {
    	Optional.ofNullable(project).orElseThrow(() -> new BuildException("Task requires a valid project."));
    	resourceCount = new ResourceCount();
    	resourceCount.setProject(project);
    }
  
    
    /**
     * Encapsulates the parent add method.
     * @param time
     * @return this object
     */  
    public Builder add(ResourceCollection resources) {
      resourceCount.add(resources);
      return this;
    }  
  
    /**
     * Encapsulates the parent setCount method.
     * @param expectedCount - expected results
     * @return this object
     */  
    public Builder setCount(int expectedCount) {
      resourceCount.setCount(expectedCount);
      return this;
    }
    
    public ResourceCount getResourceCount() {
      return resourceCount;
    }
  
  }
}
