/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;

import com.codeexcursion.ant.Project;
import com.codeexcursion.ant.types.FileSet;
import com.codeexcursion.ant.util.PathsUtil;

import java.util.Optional;


/**
 * Defaults to overwrite(true) and setForce(true).
 * @author chris
 */
public class Move extends org.apache.tools.ant.taskdefs.Move {

  private Move() {}
  
  @Override
  public Project getProject() {
    return (Project)super.getProject();
  }
  
  public static class Builder {
    private Move move;
    
    /**
     * Defaults to overwrite(true) and setForce(true).
     * @author chris
     */
    public Builder(
      Project project
    ) {
      Optional.ofNullable(project).orElseThrow(IllegalArgumentException::new);
      move = new Move();
      move.setProject(project);
      move.setOverwrite(true);
      move.setForce(true);
    }
  
    public Builder setForce(boolean force) {
      move.setForce(force);
      return this;
    }
  
    public Builder setOverwrite(boolean overwrite) {
      move.setOverwrite(overwrite);
      return this;
    }
  
    public Builder setFlatten(boolean flatten) {
      move.setFlatten(flatten);
      return this;
    }
    
    public Builder setTodir(String destDir) {
      move.setTodir(PathsUtil.getFile(destDir));
      return this;
    }
    
    public Builder addFileset(String sourceDir, String filenamePattern) {
      move.addFileset(PathsUtil.getFileSet(sourceDir, filenamePattern));
      return this;
    }
    
    public Builder addFileset(String sourceDir) {
      move.addFileset(new FileSet.Builder(move.getProject()).setDir(sourceDir).getFileSet());
      return this;
    }
    
    
    public Builder setFile(String file) {
      move.setFile(PathsUtil.getFile(file));
  	  return this;
    }
  
    
    public Move getMove() {
      return move;
    }
  }
}
