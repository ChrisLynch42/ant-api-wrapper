/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import java.util.Optional;

import com.codeexcursion.ant.filters.TokenFilter;
import com.codeexcursion.ant.util.PathsUtil;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.FilterChain;

/**
 * Defaults to setProperty("loadFileResult").
 * @author chris
 */
public class LoadFile extends org.apache.tools.ant.taskdefs.LoadFile {

	private String propertyName = "loadFileResult";
	
  public LoadFile(
    Project project
  ) {
		Optional.ofNullable(project).orElseThrow(() -> new BuildException("Task requires a valid project."));
		super.setProject(project);
		super.setProperty(propertyName);
  }

  
  /**
   * Encapsulates the parent setProperty method.
   * @param file - The file to be loaded
   * @return
   */  
  public LoadFile setPropertyC(String propertyName) {
    super.setProperty(propertyName);
    return this;
  }  
  
  /**
   * Encapsulates the parent setSrcFile method.
   * @param file - The file to be loaded
   * @return
   */  
  public LoadFile setSrcFileC(String file) {
    super.setSrcFile(PathsUtil.getFile(file));
    return this;
  }  

  /**
   * Encapsulates the parent setMaxWait method.
   * @param time
   * @return
   */  
  public LoadFile addFilterChainC(FilterChain filter) {
    super.addFilterChain(filter);
    return this;
  }  
  
  /**
   * Encapsulates the parent replaceRegex method.
   * @return this object.
   */  
  public LoadFile executeC() {
  	super.execute();
    return this;
  }   

  /**
   * Encapsulates the parent replaceRegex method.
   * @return this object.
   */  
  public Optional<String> getResult() {
  	return Optional.ofNullable(getProject().getProperty(propertyName));
  }   
  
  
}
