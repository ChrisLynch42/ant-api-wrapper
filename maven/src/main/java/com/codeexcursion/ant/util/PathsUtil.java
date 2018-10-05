package com.codeexcursion.ant.util;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.selectors.FilenameSelector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chris
 */
public class PathsUtil {

  public static File getFile(String filePath) {
    if(filePath == null) {
      throw new IllegalArgumentException("File path may not be null.");
    }
    File file = null;

    try {
      file = Paths.get(filePath).toFile();
    } catch (InvalidPathException exception) {
      throw new BuildException(exception);
    }
    if (file == null) {
      throw new BuildException("Unable to get file object for:  " + filePath);
    }
    return file;
  }

  public static FileSet getFileSet(
    String dirPath,
    String fileNamePattern
  ) {
    if(dirPath == null) {
      throw new IllegalArgumentException("Directory path may not be null.");
    }
    if(fileNamePattern == null) {
      throw new IllegalArgumentException("File name pattern may not be null.");
    }
    FileSet fileSet = new FileSet();
    File file = getFile(dirPath);
    FilenameSelector selector = new FilenameSelector();
    selector.setName(fileNamePattern);
    
    fileSet.setDir(file);
    fileSet.add(selector);
    return fileSet;
  }

}
