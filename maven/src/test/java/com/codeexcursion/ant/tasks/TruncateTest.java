package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.TestHelper;
import com.codeexcursion.ant.tasks.condition.Length;

import com.codeexcursion.ant.Project;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author chris
 */
public class TruncateTest {
  
  @Test
  public void testReplace()  throws IOException {
    Project project = new Project();
    project.setName("Replace");
    
    String destDir = TestHelper.BASE_DIR + "truncateTest/";
    String sourceDir =  TestHelper.TREE_DIR;
    new Mkdir.Builder(project).setDir(destDir).getMkdir().execute();

    String filename = "test.txt";
    String sourceFile = sourceDir + filename;
    String changedFile = destDir + filename;

    new Copy.Builder(project)
    .setTodir(destDir)
    .setFile(sourceFile).getCopy()
    .execute();    
        
    new Truncate.Builder(project).setFile(changedFile).getTruncate().execute();
    
    Assert.assertTrue("File size greater than 0.", new Length.Builder().setFile(changedFile).setWhen("equal").setLength(0).getLength().eval());

  }  

  
}
