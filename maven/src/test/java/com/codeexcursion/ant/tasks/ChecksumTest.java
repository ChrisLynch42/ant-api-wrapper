package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.TestHelper;
import static com.codeexcursion.ant.tasks.CopyTest.testCopyAndDeleteTree1;
import static com.codeexcursion.ant.tasks.CopyTest.testCopyAndDeleteTree2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;
import org.junit.Assert;
import org.apache.tools.ant.Project;
import org.junit.Test;


/**
 *
 * @author chris
 */
public class ChecksumTest {
  
  @Test
  public void testIsValid()  throws IOException {
    Project project = new Project();
    project.setName("Is available unit test.");

    String algorithm = "SHA-256";
    String sourceFile = TestHelper.TREE_DIR + "test.txt";
    String hashFile = sourceFile + "." + algorithm;
    new Checksum(project).setAlgorithmC(algorithm).setFileC(sourceFile).setTodirC(TestHelper.TREE_DIR).execute();

    Assert.assertTrue("File was not found.", new Available(project).setFileC(sourceFile).eval());
    
    Assert.assertTrue("Hash was not valid.", new Checksum(project).setAlgorithmC(algorithm).setFileC(sourceFile).eval());
    new Delete(project).setFileC(hashFile).execute();    
  }  
 
  
  @Test
  public void testNotValid()  throws IOException {
    Project project = new Project();
    project.setName("Is available unit test.");

    String algorithm = "SHA-256";
    String sourceFile = TestHelper.TREE_DIR + "test.txt";
    String hashFile = sourceFile + "." + algorithm;
    new Checksum(project).setAlgorithmC(algorithm).setFileC(sourceFile).setTodirC(TestHelper.TREE_DIR).execute();

    Assert.assertTrue("File was not found.", new Available(project).setFileC(sourceFile).eval());
    
    Files.write(Paths.get(hashFile), "xxxxx".getBytes(), StandardOpenOption.WRITE);    
    
    Assert.assertFalse("Hash was not valid.", new Checksum(project).setAlgorithmC(algorithm).setFileC(sourceFile).eval());
    new Delete(project).setFileC(hashFile).execute();    
  }    
  
}
