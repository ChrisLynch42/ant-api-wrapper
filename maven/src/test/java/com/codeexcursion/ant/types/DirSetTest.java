/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.types;

import com.codeexcursion.ant.Project;
import com.codeexcursion.ant.TestHelper;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.tools.ant.types.Resource;
import org.junit.Test;
import org.junit.Assert;
import java.util.List;

/**
 *
 * @author chris
 */
public class DirSetTest {

  @Test
  public void testFindFiles() {
    Project project = new Project();
    project.setName("Directory set unit test.");
    String sourceDir = TestHelper.TREE_DIR;

    DirSet dirSet = new DirSet.Builder(project).setDir(sourceDir).setIncludes("**/*").getDirSet();


    List<String> directories = dirSet.stream()
    .filter(Objects::nonNull)
    .map(Resource::getName)
    .peek(System.out::println)
    .collect(Collectors.toList());

    Assert.assertTrue("Directory list should contain test", directories.contains("test"));
    Assert.assertTrue("Directory list should contain test/subTest", directories.contains("test/subTest"));
  }

}
