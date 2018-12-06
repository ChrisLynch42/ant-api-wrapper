/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.TestHelper;
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
public class DeleteTest {
  
  @Test
  public void testDeleteSingleFile()  throws IOException, InterruptedException {
    Project project = new Project();
    project.setName("Delete unit test.");
    
    String destDir = TestHelper.BASE_DIR + "deleteFileTest/";
    String fileName = "test.txt";
    String sourceFile = "src/test/artifacts/treeSrc/" + fileName;
    String destFile = destDir + fileName;
    
    new Mkdir(project).setDir(destDir).execute();
    new Copy(project).setFile(sourceFile).setToDir(destDir).execute();
    Assert.assertTrue("Test file doesn't exist.", Files.exists(Paths.get(destFile)));
    new Delete(project).setFile(destFile).execute();

    Assert.assertFalse("Test file exists when it shouldn't.", Files.exists(Paths.get(destFile)));
  }  
  
}
