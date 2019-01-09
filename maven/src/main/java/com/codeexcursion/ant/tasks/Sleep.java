package com.codeexcursion.ant.tasks;

import java.util.Optional;

import org.apache.tools.ant.Project;

public class Sleep extends org.apache.tools.ant.taskdefs.Sleep {

  private Sleep() {}
  
  public static class Builder {
    private Sleep sleep;
    
    public Builder(
      Project project
    ) {
      Optional.ofNullable(project).orElseThrow(IllegalArgumentException::new);
      sleep = new Sleep();
      sleep.setProject(project);
    }
  
    public Builder setMilliseconds(int milliseconds) {
      sleep.setMilliseconds(milliseconds);
      return this;
    }
    
    
    public Sleep getSleep() {
      return sleep;
    }
  }
}
