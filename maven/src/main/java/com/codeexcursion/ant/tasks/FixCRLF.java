/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.Project;
import com.codeexcursion.ant.util.PathsUtil;

import java.util.Optional;

import org.apache.tools.ant.types.selectors.FilenameSelector;

/**
 *
 * @author chris
 */
public class FixCRLF extends org.apache.tools.ant.taskdefs.FixCRLF {

  private FixCRLF() {}
  
  public static class Builder {
    private FixCRLF fixCRLF;
  	
    public Builder(Project project) {
      Optional.ofNullable(project).orElseThrow(IllegalArgumentException::new);
      fixCRLF = new FixCRLF();
      fixCRLF.setProject(project);
  	}
  
  	
    /**
     * Encapsulates the parent setDestdir method.
     * @param destDir
     * @return this object
     */  	
  	public Builder setDestdir(String destDir) {
  	  fixCRLF.setDestdir(PathsUtil.getFile(destDir));
  		return this;
  	}
  
  	
    /**
     * Encapsulates the parent addFilename method.
     * @param filenamePattern
     * @return this object
     */ 	
  	public Builder addFilename(String filenamePattern) {
  		FilenameSelector filenameSelector = new FilenameSelector();
  		filenameSelector.setName(filenamePattern);
  		fixCRLF.addFilename(filenameSelector);
  		return this;
  	}
  
    /**
     * Encapsulates the parent setSrcdir method.
     * @param sourceDir
     * @return this object
     */ 	
  	public Builder setSrcdir(String sourceDir) {
  	  fixCRLF.setSrcdir(PathsUtil.getFile(sourceDir));
  		return this;
  	}
  
    /**
     * Encapsulates the parent setEolC method.
     * @param eol - unix, dos, mac
     * @return this object
     */ 	
  	public Builder setEol(String eol) {
  		org.apache.tools.ant.taskdefs.FixCRLF.CrLf lineEnding = 
  				new org.apache.tools.ant.taskdefs.FixCRLF.CrLf();
  		lineEnding.setValue(eol);
  		fixCRLF.setEol(lineEnding);
  		return this;
  	}
  	
  	public FixCRLF getFixCRLF() {
  	  return fixCRLF;
  	}
  }
	
}
