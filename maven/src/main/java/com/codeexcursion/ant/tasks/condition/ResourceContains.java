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

  public ResourceContains(
    Project project
  ) {
		Optional.ofNullable(project).orElseThrow(() -> new BuildException("Task requires a valid project."));
		super.setProject(project);
  }

  /**
   * Encapsulates the parent setSubstring method.
   * @param substring
   * @return this object
   */  
  public ResourceContains setSubstringC(String substring) {
    super.setSubstring(substring);
    return this;
  }  
  
  /**
   * Encapsulates the parent setCasesensitive method.
   * @param casesensitive
   * @return this object
   */  
  public ResourceContains setCasesensitiveC(boolean casesensitive) {
    super.setCasesensitive(casesensitive);
    return this;
  }  
  
  
  /**
   * Encapsulates the parent setResource method.
   * @param resource
   * @return this object
   */  
  public ResourceContains setResourceC(String resource) {
    super.setResource(resource);
    return this;
  }  

}
