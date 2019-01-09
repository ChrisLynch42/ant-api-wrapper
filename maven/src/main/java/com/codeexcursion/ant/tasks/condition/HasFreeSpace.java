/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks.condition;

import java.util.Optional;

import com.codeexcursion.ant.util.PathsUtil;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/**
 *
 * @author chris
 */
public class HasFreeSpace extends org.apache.tools.ant.taskdefs.condition.HasFreeSpace {

  private HasFreeSpace() {}
  
  public static class Builder {
    private HasFreeSpace hasFreeSpace;
    
    public Builder() {
      hasFreeSpace = new HasFreeSpace();
    }
    /**
     * Encapsulates the setPartition method.
     * @param partition - The directory/partition to be checked for free space.
     * @return this object
     */  
    public Builder setPartition(String partition) {
      hasFreeSpace.setPartition(partition);
      return this;
    }  
    
    /**
     * Encapsulates the  setNeeded method.
     * @param needed - Amount of space required to be available.
     * @return this object
     */  
    public Builder setNeeded(String needed) {
      hasFreeSpace.setNeeded(needed);
      return this;
    }  
    
    public HasFreeSpace getHasFreeSpace() {
      return hasFreeSpace;
    }
  }
}
