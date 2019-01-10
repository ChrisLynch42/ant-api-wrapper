/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.Project;

import java.util.Enumeration;
import java.util.Optional;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.taskdefs.condition.Condition;

/**
 *
 * @author chris
 * 
 * 
 */
public class WaitFor extends org.apache.tools.ant.taskdefs.WaitFor {

  private String failMessage;
  
  private WaitFor() {
    
  }
  
  /**
   * Boolean AND result of all condition boolean results.
   * @return
   */
  public boolean eval() {
    Enumeration<Condition> conditions = this.getConditions();
    boolean returnValue = true;
    while(conditions.hasMoreElements()) {
      returnValue = conditions.nextElement().eval() && returnValue;
    }
    return returnValue;
  }  
  
  public void executeWithFail() {
    Optional.ofNullable(this.getFailMessage()).orElseThrow(() -> new BuildException("Fail message must be supplied"));    
    super.execute();
    if(!eval()) {
      throw new BuildException(failMessage);
    }
  }
  
  public String getFailMessage() {
    return failMessage;
  }
  
  public void setFailMessage(String failMessage) {
    this.failMessage=failMessage;
  }  
  
  public static class Builder {
    private WaitFor waitFor;
    
      public Builder(Project project) {
        Optional.ofNullable(project).orElseThrow(IllegalArgumentException::new);
        waitFor = new WaitFor();
        waitFor.setProject(project);
      }
  
    /**
     * Encapsulates the setMaxWait method.
     * @param time
     * @return
     */
    public Builder setMaxWait(long time) {
      waitFor.setMaxWait(time);
  		return this;
    }
  
    /**
     * Encapsulates the setMaxWaitUnit method.
     * @param time
     * @return
     */
    public Builder setMaxWaitUnit(String timeUnit) {
    	WaitFor.Unit unit = new WaitFor.Unit();
    	unit.setValue(timeUnit);
    	waitFor.setMaxWaitUnit(unit);
  		return this;
    }  
    
    /**
     * Encapsulates the setMaxWaitUnit method.
     * @param time
     * @return
     */
    public Builder add(Condition condition) {
      waitFor.add(condition);
  		return this;
    }
    
    public WaitFor getWaitFor() {
      return waitFor;
    }
  } 
}
