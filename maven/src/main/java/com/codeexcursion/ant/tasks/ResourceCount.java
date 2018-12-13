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

  public ResourceCount(
    Project project
  ) {
	Optional.ofNullable(project).orElseThrow(() -> new BuildException("Task requires a valid project."));
	super.setProject(project);
  }

  
  /**
   * Encapsulates the parent add method.
   * @param time
   * @return this object
   */  
  public ResourceCount addC(ResourceCollection resources) {
    super.add(resources);
    return this;
  }  

  /**
   * Encapsulates the parent setCount method.
   * @param expectedCount - expected results
   * @return this object
   */  
  public ResourceCount setCountC(int expectedCount) {
    super.setCount(expectedCount);
    return this;
  }  
  
  
}
