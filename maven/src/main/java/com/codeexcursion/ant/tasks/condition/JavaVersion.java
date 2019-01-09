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
public class JavaVersion extends org.apache.tools.ant.taskdefs.condition.JavaVersion {

  private JavaVersion() {}
  
  public static class Builder {
    private JavaVersion javaVersion;
    
    public Builder() {
      javaVersion = new JavaVersion();
    }
    /**
     * Encapsulates the parent atLeast method.
     * @param version - the minimum version of Java.
     * @return this object
     */  
    public Builder setAtLeast(String version) {
      javaVersion.setAtLeast(version);
      return this;
    }  
    
    public JavaVersion getJavaVersion() {
      return javaVersion;
    }
  }
}
