/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import org.apache.tools.ant.Project;



/**
 *
 * @author chris
 */
public abstract class BaseTask {
  private Project project;
  
  public BaseTask(
    Project project
  ) {
    if(project == null) {
      throw new IllegalArgumentException("Project may not be null.");
    }
    this.project=project;
  }

  public Project getProject() {
    return project;
  }
  
}
