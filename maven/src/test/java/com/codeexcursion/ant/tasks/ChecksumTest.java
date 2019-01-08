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
    new Checksum.Builder(project).setAlgorithm(algorithm).setFile(sourceFile).setTodir(TestHelper.TREE_DIR).getChecksum().execute();

    Assert.assertTrue("File was not found.", new Available.Builder(project).setFile(sourceFile).getAvailable().eval());
    
    Assert.assertTrue("Hash was not valid.", new Checksum.Builder(project).setAlgorithm(algorithm).setFile(sourceFile).getChecksum().eval());
    new Delete.Builder(project).setFile(hashFile).getDelete().execute();    
  }  
 
  
  @Test
  public void testNotValid()  throws IOException {
    Project project = new Project();
    project.setName("Is available unit test.");

    String algorithm = "SHA-256";
    String sourceFile = TestHelper.TREE_DIR + "test.txt";
    String hashFile = sourceFile + "." + algorithm;
    new Checksum.Builder(project).setAlgorithm(algorithm).setFile(sourceFile).setTodir(TestHelper.TREE_DIR).getChecksum().execute();

    Assert.assertTrue("File was not found.", new Available.Builder(project).setFile(sourceFile).getAvailable().eval());
    
    Files.write(Paths.get(hashFile), "xxxxx".getBytes(), StandardOpenOption.WRITE);    
    
    Assert.assertFalse("Hash was not valid.", new Checksum.Builder(project).setAlgorithm(algorithm).setFile(sourceFile).getChecksum().eval());
    new Delete.Builder(project).setFile(hashFile).getDelete().execute();    
  }    
  
}
