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
public class MoveTest {
  
  @Test
  public void testMoveFile() {
    Project project = new Project();
    project.setName("Move File.");
    
    String destDir = TestHelper.BASE_DIR + "copyDest/";
    String moveDestDir = TestHelper.BASE_DIR + "moveDest/";
    String sourceDir =  TestHelper.TREE_DIR;
    new Mkdir.Builder(project).setDir(destDir).getMkdir().execute();
    new Mkdir.Builder(project).setDir(moveDestDir).getMkdir().execute();

    new Copy.Builder(project)
      .setTodir(destDir)
      .addFileset(sourceDir, "**/*").getCopy()
      .execute();
        
    String filename = destDir + "/test.txt";
    new Move(project).setFileC(filename).setTodirC(moveDestDir).execute();    
    
    Assert.assertFalse("File " + filename + " should exist.", Files.exists(Paths.get(filename)));
    filename = moveDestDir + "/test.txt";
    Assert.assertTrue("File " + filename + " should exist.", Files.exists(Paths.get(filename)));
    
    new Delete.Builder(project).setDir(destDir).getDelete().execute();
    new Delete.Builder(project).setDir(moveDestDir).getDelete().execute();
  }

  @Test
  public void testMoveDirectoriesAndFiles() {
    Project project = new Project();
    project.setName("Move files and directories.");
    
    String destDir = TestHelper.BASE_DIR + "copyDest/";
    String moveDestDir = TestHelper.BASE_DIR + "moveDest/";
    String sourceDir =  TestHelper.TREE_DIR;
    new Mkdir.Builder(project).setDir(destDir).getMkdir().execute();
    new Mkdir.Builder(project).setDir(moveDestDir).getMkdir().execute();

    new Copy.Builder(project)
      .setTodir(destDir)
      .addFileset(sourceDir, "**/*").getCopy()
      .execute();
        
    String filename = "test.txt";
    String subFilename = "test/subTest/test4.txt";
    new Move(project).addFilesetC(destDir, "**/*").setTodirC(moveDestDir).execute();    
    
    String filepath = destDir + filename;
    Assert.assertFalse("File " + filename + " should exist.", Files.exists(Paths.get(filepath)));
    filepath = destDir + subFilename;
    Assert.assertFalse("File " + filename + " should exist.", Files.exists(Paths.get(filepath)));

    filepath = moveDestDir + "/test.txt";
    Assert.assertTrue("File " + filename + " should exist.", Files.exists(Paths.get(filepath)));
    filepath = moveDestDir + subFilename;
    Assert.assertTrue("File " + filename + " should exist.", Files.exists(Paths.get(filepath)));
    
    new Delete.Builder(project).setDir(destDir).getDelete().execute();
    new Delete.Builder(project).setDir(moveDestDir).getDelete().execute();
  }  
  
}
