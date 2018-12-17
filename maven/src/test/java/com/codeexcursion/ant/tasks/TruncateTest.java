package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.TestHelper;
import com.codeexcursion.ant.tasks.condition.FilesMatch;
import com.codeexcursion.ant.tasks.condition.Length;

import static com.codeexcursion.ant.tasks.CopyTest.testCopyAndDeleteTree1;
import static com.codeexcursion.ant.tasks.CopyTest.testCopyAndDeleteTree2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;
import org.junit.Assert;
import org.apache.tools.ant.Project;
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
    new Mkdir(project).setDirC(destDir).execute();

    String filename = "test.txt";
    String sourceFile = sourceDir + filename;
    String changedFile = destDir + filename;

    new Copy(project)
    .setTodirC(destDir)
    .setFileC(sourceFile)
    .execute();    
        
    new Truncate(project).setFileC(changedFile).execute();
    
    Assert.assertTrue("File size greater than 0.", new Length().setFileC(changedFile).setWhenC("equal").setLengthC(0).eval());

  }  

  
}
