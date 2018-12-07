/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import java.io.File;
import java.util.Optional;

import com.codeexcursion.ant.util.PathsUtil;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.condition.Condition;

/**
 *
 * @author chris
 * 
 * 
 */
public class WaitFor extends org.apache.tools.ant.taskdefs.WaitFor {

  public WaitFor(
    Project project
  ) {
		Optional.ofNullable(project).orElseThrow(() -> new BuildException("Task requires a valid project."));
		super.setProject(project);
  }

  /**
   * Encapsulates the parent setMaxWait method.
   * @param time
   * @return
   */
  public WaitFor setMaxWaitC(long time) {
		super.setMaxWait(time);
		return this;
  }

  /**
   * Encapsulates the WaitFor setMaxWaitUnit method.
   * @param time
   * @return
   */
  public WaitFor setMaxWaitUnitC(WaitFor.Unit timeUnit) {
		super.setMaxWaitUnit(timeUnit);
		return this;
  }  
  
  /**
   * Encapsulates the WaitFor setMaxWaitUnit method.
   * @param time
   * @return
   */
  public WaitFor addC(Condition condition) {
		super.add(condition);
		return this;
  }    
  
}
