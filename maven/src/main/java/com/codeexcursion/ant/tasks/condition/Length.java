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

  /**
   * Encapsulates the parent setFile method.
   * @param file1
   * @return this object
   */  
  public Length setFileC(String file1) {
    super.setFile(PathsUtil.getFile(file1));
    return this;
  }  

  /**
   * Encapsulates the parent setLength method.
   * @param length
   * @return this object
   */  
  public Length setLengthC(int length) {
    super.setLength(length);
    return this;
  }  
  
  /**
   * Encapsulates the parent setWhen method.
   * @param when
   * @return this object
   */  
  public Length setWhenC(String when) {
  	Length.When comparison = new Length.When();
  	comparison.setValue(when);
    super.setWhen(comparison);
    return this;
  }  

  
}
