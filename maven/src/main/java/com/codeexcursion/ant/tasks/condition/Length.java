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
public class Length extends org.apache.tools.ant.taskdefs.Length {

  private Length() {}
  
  public static class Builder {
    private Length length;
    
    public Builder() {
      length = new Length();
    }
    /**
     * Encapsulates the setFile method.
     * @param file1
     * @return this object
     */  
    public Builder setFile(String file1) {
      length.setFile(PathsUtil.getFile(file1));
      return this;
    }  
  
    /**
     * Encapsulates the setLength method.
     * @param length
     * @return this object
     */  
    public Builder setLength(int lengthExpected) {
      length.setLength(lengthExpected);
      return this;
    }  
    
    /**
     * Encapsulates the setWhen method.
     * @param when
     * @return this object
     */  
    public Builder setWhen(String when) {
    	Length.When comparison = new Length.When();
    	comparison.setValue(when);
    	length.setWhen(comparison);
      return this;
    }  

    
    public Length getLength() {
      return length;
    }
  }
}

