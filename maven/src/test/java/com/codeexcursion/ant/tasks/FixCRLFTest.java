/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.Project;
import com.codeexcursion.ant.TestHelper;
import com.codeexcursion.ant.tasks.condition.FilesMatch;

import org.junit.Assert;
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
    
    new Mkdir.Builder(project).setDir(destDir).getMkdir().execute();

    new Copy.Builder(project)
      .setTodir(destDir)
      .addFileset(sourceDir, "**/*").getCopy()
      .execute();

    Assert.assertTrue("Files should match.", new FilesMatch.Builder().setFile1(sourceFile).setFile2(destFile).getFilesMatch().eval());    
    
    new FixCRLF.Builder(project).setSrcdir(destDir).addFilename("test.txt").setEol("dos").getFixCRLF().execute();
    Assert.assertFalse("Files should match.", new FilesMatch.Builder().setFile1(sourceFile).setFile2(destFile).getFilesMatch().eval());
    
    new FixCRLF.Builder(project).setSrcdir(destDir).addFilename("test.txt").setEol("unix").getFixCRLF().execute();
    Assert.assertTrue("Files should match.", new FilesMatch.Builder().setFile1(sourceFile).setFile2(destFile).getFilesMatch().eval());
    
    new Delete.Builder(project).setDir(destDir).getDelete().execute();
  }
  
}
