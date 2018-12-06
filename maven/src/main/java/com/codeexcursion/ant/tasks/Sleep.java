package com.codeexcursion.ant.tasks;

import org.apache.tools.ant.Project;

public class Sleep extends BaseTask {
  private org.apache.tools.ant.taskdefs.Sleep task = new org.apache.tools.ant.taskdefs.Sleep();

  public Sleep(
    Project project
  ) {
    super(project);
    task.setProject(project);
  }

  public Sleep execute() {
    task.execute();
    return this;
  }
	  
  public Sleep setMilliseconds(int milliseconds) {
    task.setMilliseconds(milliseconds);
    return this;
  }
  
  
}
