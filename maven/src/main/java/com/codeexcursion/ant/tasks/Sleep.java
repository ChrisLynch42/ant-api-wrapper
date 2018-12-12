package com.codeexcursion.ant.tasks;

import org.apache.tools.ant.Project;

public class Sleep extends org.apache.tools.ant.taskdefs.Sleep {

  public Sleep(
    Project project
  ) {
    super.setProject(project);
  }

  public Sleep setMillisecondsC(int milliseconds) {
  	super.setMilliseconds(milliseconds);
    return this;
  }
  
  
}
