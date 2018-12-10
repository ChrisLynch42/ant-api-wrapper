/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.types;

import com.codeexcursion.ant.TestHelper;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.Resource;
import org.junit.Test;
import org.junit.Assert;
import com.codeexcursion.ant.util.PathsUtil;
import java.util.List;
import java.io.File;

/**
 *
 * @author chris
 */
public class FileSetTest {

  @Test
  public void testFindFiles() {
    Project project = new Project();
    project.setName("File set unit test.");
    FileSet fileSet = new FileSet(project);

    String sourceDir = TestHelper.TREE_DIR;

    fileSet.setDirC(sourceDir);
    fileSet.setIncludesC("**/*");

    List<String> files = fileSet.stream()
    .filter(Objects::nonNull)
    .map(Resource::getName)
    .peek(System.out::println)
    .collect(Collectors.toList());

    Assert.assertTrue("File list should contain test.txt", files.contains("test.txt"));
    Assert.assertTrue("File list should contain test/subTest/test5.txt", files.contains("test/subTest/test5.txt"));

  }

}