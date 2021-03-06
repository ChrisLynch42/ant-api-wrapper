/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.Project;
import com.codeexcursion.ant.TestHelper;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Test;
/**
 *
 * @author chris
 */
public class CopyTest {
  
  @Test
  public void testFlattenCopy() {
    Project project = new Project();
    project.setName("Flatten copy unit test.");
    
    String destDir = TestHelper.BASE_DIR + "copyDeleteDest/";
    String sourceDir =  TestHelper.TREE_DIR;
    new Mkdir.Builder(project).setDir(destDir).getMkdir().execute();

    new Copy.Builder(project)
      .setTodir(destDir)
      .addFileset(sourceDir, "**/*")
      .setFlatten(true).getCopy()
      .execute();
    
    String filename = destDir + "/test.txt";
    Assert.assertTrue("File " + filename + " should exist.", Files.exists(Paths.get(filename)));
    filename = destDir + "/test4.txt";
    Assert.assertTrue("File " + filename + " should exist.", Files.exists(Paths.get(filename)));
    
    new Delete.Builder(project).setDir(destDir).getDelete().execute();
  }

  @Test
  public void testCopyAndDeleteTree() {
    Project project = new Project();
    project.setName("Copy/Delete Tree unit test.");
    
    String destDir = TestHelper.BASE_DIR + "copyDeleteDest/";
    testCopyAndDeleteTree1(project, destDir);
    testCopyAndDeleteTree2(project, destDir);
  }  
  
  
  public final static void testCopyAndDeleteTree1(Project project, String destDir) {
    
    String sourceDir =  TestHelper.TREE_DIR;

    String filename = destDir + "/test.txt";
    String dirname = destDir + "/test";
    String subDirname = destDir + "/test/subTest";
    String subFilename = subDirname + "/test4.txt";

    new Delete.Builder(project).setQuiet(true).addFileset(destDir, "**/*").getDelete().execute();
    new Copy.Builder(project)
      .setTodir(destDir)
      .addFileset(sourceDir, "**/*").getCopy()
      .execute();
    Assert.assertTrue("File " + filename + " should exist.", Files.exists(Paths.get(filename)));
    Assert.assertTrue("Directory " + dirname + " should exist.", Files.exists(Paths.get(dirname)));
    Assert.assertTrue("Directory " + subDirname + " should exist.", Files.exists(Paths.get(subDirname)));
    Assert.assertTrue("File " + subFilename + " should exist.", Files.exists(Paths.get(subFilename)));
    
  }

  public static final void testCopyAndDeleteTree2(Project project, String destDir) {
    
    new Delete.Builder(project).setDir(destDir).getDelete().execute();
    Assert.assertFalse("Directory " + destDir + " should not exist.", Files.exists(Paths.get(destDir)));
  }    
  
}
