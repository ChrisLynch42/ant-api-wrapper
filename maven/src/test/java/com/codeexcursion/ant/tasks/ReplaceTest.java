package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.TestHelper;
import com.codeexcursion.ant.tasks.condition.FilesMatch;

import com.codeexcursion.ant.Project;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author chris
 */
public class ReplaceTest {
  
  @Test
  public void testReplace()  throws IOException {
    Project project = new Project();
    project.setName("Replace");
    
    String destDir = TestHelper.BASE_DIR + "replaceTest/";
    String sourceDir =  TestHelper.TREE_DIR;
    new Mkdir.Builder(project).setDir(destDir).getMkdir().execute();

    String filename = "test.txt";
    String sourceFile = sourceDir + filename;
    String compareFile = sourceDir + "replace.txt";
    String changedFile = destDir + filename;
    
    new Copy.Builder(project)
      .setTodir(destDir)
      .setFile(sourceFile).getCopy()
      .execute();    
    
    new Replace.Builder(project).setFile(destDir + filename).setToken("Test").setValue("Replace").getReplace().execute();
    Assert.assertTrue("Files did not match.", new FilesMatch.Builder().setFile1(compareFile).setFile2(changedFile).getFilesMatch().eval());

  }  

  
}
