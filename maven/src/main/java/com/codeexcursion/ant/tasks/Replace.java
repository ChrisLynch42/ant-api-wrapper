/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.util.PathsUtil;
import org.apache.tools.ant.Project;

/**
 *
 * @author chris
 */
public class Replace extends org.apache.tools.ant.taskdefs.Replace {
  public Replace(
    Project project
  ) {
    super.setProject(project);
  }

  public Replace setTokenC(String token) {
  	super.setToken(token);
    return this;
  }

  public Replace setValueC(String value) {
  	super.setValue(value);
    return this;
  }

  public Replace setFileC(String targetFile) {
  	super.setFile(PathsUtil.getFile(targetFile));
    return this;
  }
  
}
