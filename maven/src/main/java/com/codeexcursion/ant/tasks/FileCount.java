/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/**
 *
 * @author chris
 */
public class FileCount {

  private String targetDir;
  private long count;

  public FileCount execute() {
  	Optional.ofNullable(targetDir).orElseThrow(() -> new BuildException("Directory for FileCount not set."));
    try {
      long result = Files.list(Paths.get(targetDir)).count();
      if (result != count) {
        String message = "Expected file count did not match."
          + result + " != " + count;
        throw new BuildException(message);
      }
    } catch (IOException exception) {
      String message = "File count failure targetDir=" + targetDir;
      BuildException error = new BuildException(message);
      error.addSuppressed(exception);
      throw error;
    }
    return this;
  }

  public FileCount setDir(String targetDir) {
    if (targetDir == null) {
      throw new IllegalArgumentException("Directory may not be null.");
    }
    this.targetDir = targetDir;
    return this;
  }

  public FileCount setCount(long count) {
    this.count = count;
    return this;
  }

}
