/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.TestHelper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;
import junit.framework.Assert;
import com.codeexcursion.ant.tasks.Chmod;
import com.codeexcursion.ant.tasks.Copy;
import com.codeexcursion.ant.tasks.Delete;
import com.codeexcursion.ant.tasks.ExecTask;
import com.codeexcursion.ant.tasks.Mkdir;
import org.apache.commons.configuration2.Configuration;
import org.apache.tools.ant.Project;
import static org.mockito.Mockito.*;
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
    new Mkdir(project).setDir(destDir).execute();

    new Copy(project)
      .setToDir(destDir)
      .addFileset(sourceDir, "**/*")
      .setFlatten(true)
      .execute();
    
    String filename = destDir + "/test.txt";
    Assert.assertTrue("File " + filename + " should exist.", Files.exists(Paths.get(filename)));
    filename = destDir + "/test4.txt";
    Assert.assertTrue("File " + filename + " should exist.", Files.exists(Paths.get(filename)));
    
    new Delete(project).setDir(destDir).execute();
  }

  @Test
  public void testCopyAndDeleteTree() {
    Project project = new Project();
    project.setName("Copy/Delete Tree unit test.");
    
    String destDir = TestHelper.BASE_DIR + "copyDeleteDest/";
    String sourceDir =  TestHelper.TREE_DIR;

    String filename = destDir + "/test.txt";
    String dirname = destDir + "/test";
    String subDirname = destDir + "/test/subTest";
    String subFilename = subDirname + "/test4.txt";

    new Delete(project).setQuiet(true).addFileset(destDir, "**/*").execute();
    new Copy(project)
      .setToDir(destDir)
      .addFileset(sourceDir, "**/*")
      .execute();
    Assert.assertTrue("File " + filename + " should exist.", Files.exists(Paths.get(filename)));
    Assert.assertTrue("Directory " + dirname + " should exist.", Files.exists(Paths.get(dirname)));
    Assert.assertTrue("Directory " + subDirname + " should exist.", Files.exists(Paths.get(subDirname)));
    Assert.assertTrue("File " + subFilename + " should exist.", Files.exists(Paths.get(subFilename)));
    
    new Delete(project).addFileset(destDir, "**/*").execute();
    Assert.assertFalse("File " + filename + " should not exist.", Files.exists(Paths.get(filename)));
    Assert.assertFalse("Directory " + dirname + " should not exist.", Files.exists(Paths.get(dirname)));
  }  
  
}
