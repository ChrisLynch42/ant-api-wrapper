package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.TestHelper;

import com.codeexcursion.ant.Project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import org.junit.Assert;
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
