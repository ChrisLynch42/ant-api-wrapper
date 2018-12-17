/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.TestHelper;
import com.codeexcursion.ant.tasks.condition.FilesMatch;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Assert;
import org.apache.tools.ant.Project;
import org.junit.Test;
/**
 *
 * @author chris
 */
public class FixCRLFTest {
  
  @Test
  public void testChangeLineEndings() {
    Project project = new Project();
    project.setName("Flatten copy unit test.");
    
    String fileName = "test.txt";
    String destDir = TestHelper.BASE_DIR + "fixCRLFTest/";
    String destFile = destDir + "/" + fileName;    
    
    String sourceDir =  TestHelper.TREE_DIR;
    String sourceFile = sourceDir + "/" + fileName;
    
    new Mkdir(project).setDirC(destDir).execute();

    new Copy(project)
      .setTodirC(destDir)
      .addFilesetC(sourceDir, "**/*")
      .execute();

    Assert.assertTrue("Files should match.", new FilesMatch().setFile1C(sourceFile).setFile2C(destFile).eval());    
    
    new FixCRLF(project).setSrcdirC(destDir).addFilenameC("test.txt").setEolC("dos").execute();
    Assert.assertFalse("Files should match.", new FilesMatch().setFile1C(sourceFile).setFile2C(destFile).eval());
    
    new FixCRLF(project).setSrcdirC(destDir).addFilenameC("test.txt").setEolC("unix").execute();
    Assert.assertTrue("Files should match.", new FilesMatch().setFile1C(sourceFile).setFile2C(destFile).eval());
    
    new Delete(project).setDirC(destDir).execute();
  }
  
}
