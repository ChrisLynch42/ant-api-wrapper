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
public class FixCRLF extends BaseTask {
	private org.apache.tools.ant.taskdefs.FixCRLF task = new org.apache.tools.ant.taskdefs.FixCRLF();

	public FixCRLF(Project project) {
		super(project);
		task.setProject(project);
	}

	public org.apache.tools.ant.taskdefs.FixCRLF getTask() {
		return task;
	}

	public FixCRLF execute() {
		task.execute();
		return this;
	}

	public FixCRLF setDestdir(String destDir) {
		task.setDestdir(PathsUtil.getFile(destDir));
		return this;
	}

	public FixCRLF addFilename(String filenamePattern) {
		FilenameSelector filenameSelector = new FilenameSelector();
		filenameSelector.setName(filenamePattern);
		task.addFilename(filenameSelector);
		return this;
	}

	public FixCRLF setSrcdir(String sourceDir) {
		task.setSrcdir(PathsUtil.getFile(sourceDir));
		return this;
	}

	public FixCRLF setEol(String eol) {
		org.apache.tools.ant.taskdefs.FixCRLF.CrLf lineEnding = 
				new org.apache.tools.ant.taskdefs.FixCRLF.CrLf();
		lineEnding.setValue(eol);
		task.setEol(lineEnding);
		return this;
	}
	
	
}
