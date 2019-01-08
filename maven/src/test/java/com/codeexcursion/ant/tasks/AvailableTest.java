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
public class AvailableTest {
  
  @Test
  public void testIsAvailable()  throws IOException {
    Project project = new Project();
    project.setName("Is available unit test.");
    
    String sourceFile = "src/test/artifacts/treeSrc/test.txt";
    Assert.assertTrue("File was not found.", new Available.Builder(project).setFile(sourceFile).getAvailable().eval());
  }  

  
  @Test
  public void testNotAvailable() throws IOException {
    Project project = new Project();
    project.setName("Is available unit test.");
    
    String sourceFile = "src/test/artifacts/treeSrc/noSuchFile.txt";
    Assert.assertFalse("File shouldn't exist but was found.", new Available.Builder(project).setFile(sourceFile).getAvailable().eval());
  }  
  
  
  
}
