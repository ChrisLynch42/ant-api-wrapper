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
public class DirSetTest {

  @Test
  public void testFindFiles() {
    Project project = new Project();
    project.setName("Directory set unit test.");
    DirSet dirSet = new DirSet(project);

    String sourceDir = TestHelper.TREE_DIR;

    dirSet.setDir(sourceDir);
    dirSet.setIncludes("**/*");

    System.out.println(PathsUtil.getFile(sourceDir).getAbsolutePath());

    List<String> directories = dirSet.getAntType().stream()
    .filter(Objects::nonNull)
    .map(Resource::getName)
    .peek(System.out::println)
    .collect(Collectors.toList());

    Assert.assertTrue("Directory list should contain test", directories.contains("test"));
    Assert.assertTrue("Directory list should contain test/subTest", directories.contains("test/subTest"));

    System.out.println(dirSet.getAntType().toString());

  }

}
