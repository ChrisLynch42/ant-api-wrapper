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

	public FixCRLF setDestdir(String destDir) {
		super.setDestdir(PathsUtil.getFile(destDir));
		return this;
	}

	public FixCRLF addFilename(String filenamePattern) {
		FilenameSelector filenameSelector = new FilenameSelector();
		filenameSelector.setName(filenamePattern);
		super.addFilename(filenameSelector);
		return this;
	}

	public FixCRLF setSrcdir(String sourceDir) {
		super.setSrcdir(PathsUtil.getFile(sourceDir));
		return this;
	}

	public FixCRLF setEol(String eol) {
		org.apache.tools.ant.taskdefs.FixCRLF.CrLf lineEnding = 
				new org.apache.tools.ant.taskdefs.FixCRLF.CrLf();
		lineEnding.setValue(eol);
		super.setEol(lineEnding);
		return this;
	}
	
	
}
