/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import java.io.File;
import com.codeexcursion.ant.util.PathsUtil;
import org.apache.tools.ant.Project;

/**
 *
 * @author chris
 */
public class Mkdir extends org.apache.tools.ant.taskdefs.Mkdir {

  public Mkdir(
    Project project
  ) {
    super.setProject(project);

  }

  
  /**
   * Encapsulates the parent setDir method.
   * @param newDir - directory to be created.
   * @return this object
   */     
  public Mkdir setDirC(String newDir) {
    super.setDir(PathsUtil.getFile(newDir));
    return this;
  }
}
