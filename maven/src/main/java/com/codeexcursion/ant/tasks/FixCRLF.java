/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.util.PathsUtil;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.selectors.FilenameSelector;

/**
 *
 * @author chris
 */
public class FixCRLF extends org.apache.tools.ant.taskdefs.FixCRLF {

	public FixCRLF(Project project) {
		super.setProject(project);
	}

	
  /**
   * Encapsulates the parent setDestdir method.
   * @param destDir
   * @return this object
   */  	
	public FixCRLF setDestdirC(String destDir) {
		super.setDestdir(PathsUtil.getFile(destDir));
		return this;
	}

	
  /**
   * Encapsulates the parent addFilename method.
   * @param filenamePattern
   * @return this object
   */ 	
	public FixCRLF addFilenameC(String filenamePattern) {
		FilenameSelector filenameSelector = new FilenameSelector();
		filenameSelector.setName(filenamePattern);
		super.addFilename(filenameSelector);
		return this;
	}

  /**
   * Encapsulates the parent setSrcdir method.
   * @param sourceDir
   * @return this object
   */ 	
	public FixCRLF setSrcdirC(String sourceDir) {
		super.setSrcdir(PathsUtil.getFile(sourceDir));
		return this;
	}

  /**
   * Encapsulates the parent setEolC method.
   * @param eol - unix, dos, mac
   * @return this object
   */ 	
	public FixCRLF setEolC(String eol) {
		org.apache.tools.ant.taskdefs.FixCRLF.CrLf lineEnding = 
				new org.apache.tools.ant.taskdefs.FixCRLF.CrLf();
		lineEnding.setValue(eol);
		super.setEol(lineEnding);
		return this;
	}
	
	
}
