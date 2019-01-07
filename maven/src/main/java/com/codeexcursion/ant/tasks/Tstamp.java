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

/**
 *
 * @author chris
 */
public class Tstamp extends org.apache.tools.ant.taskdefs.Tstamp {

  public Tstamp(
    Project project,
    String pattern,
    String propertyName
  ) {
		Optional.ofNullable(project).orElseThrow(() -> new BuildException("Task requires a valid project."));
		Optional.ofNullable(pattern).orElseThrow(() -> new BuildException("Task requires a valid pattern."));
		Optional.ofNullable(propertyName).orElseThrow(() -> new BuildException("Task requires a valid property name."));
	super.setProject(project);
	Tstamp.CustomFormat format = super.createFormat();
	format.setPattern(pattern);
	format.setProperty(propertyName);
  }

}
