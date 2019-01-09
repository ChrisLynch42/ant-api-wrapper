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

	private static final String PROPERTY_NAME = "loadFileResult";
	
	private LoadFile() {}
	
  /**
   * Encapsulates the parent execute method and returns a result.
   * @return Optional string containing the result.
   */  
  public Optional<String> executeResult() {
    getProject().setProperty(PROPERTY_NAME, null);
    super.execute();
    return getResult();
  }   

  /**
   * Return the result form the project.
   * @return Optional string containing the result.
   */  
  public Optional<String> getResult() {
    return Optional.ofNullable(getProject().getProperty(PROPERTY_NAME));
  }	
	
	
	/**
	 * Defaults to setProperty("loadFileResult").
	 * @author chris
	 */
	public static class Builder {
	  private LoadFile loadFile;
	  
    public Builder(
      Project project
    ) {
  		Optional.ofNullable(project).orElseThrow(() -> new BuildException("Task requires a valid project."));
  		loadFile = new LoadFile();
  		loadFile.setProject(project);
  		loadFile.setProperty(PROPERTY_NAME);
    }
  
    
    /**
     * Encapsulates the parent setProperty method.
     * @param file - The file to be loaded
     * @return
     */  
    public Builder setProperty(String propertyName) {
      loadFile.setProperty(propertyName);
      return this;
    }  
    
    /**
     * Encapsulates the parent setSrcFile method.
     * @param file - The file to be loaded
     * @return
     */  
    public Builder setSrcFile(String file) {
      loadFile.setSrcFile(PathsUtil.getFile(file));
      return this;
    }  
  
    /**
     * Encapsulates the parent setMaxWait method.
     * @param time
     * @return
     */  
    public Builder addFilterChain(FilterChain filter) {
      loadFile.addFilterChain(filter);
      return this;
    }  
    
    public LoadFile getLoadFile() {
      return loadFile;
    }
  
	}
}
