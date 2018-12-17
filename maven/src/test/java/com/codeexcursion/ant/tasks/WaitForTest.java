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
public class WaitForTest {
  
  @Test
  public void testNoFile()  throws IOException {
    Project project = new Project();
    project.setName("Is available unit test.");
    
    long start = System.currentTimeMillis();

    new WaitFor(project).setMaxWaitC(400).setMaxWaitUnitC(WaitFor.Unit.MILLISECOND)
  	.addC(new Available(project).setFileC("xxxxxxxxxxxxxxxxxxxx"))
  	.execute();

    long end = System.currentTimeMillis();
    long result = end - start;
    
    boolean isAcceptable = (400 < result && result < 600);
     
    Assert.assertTrue("WaitFor duration outside acceptable parameters.", isAcceptable);
    
  }  

  @Test
  public void testIsFile()  throws IOException {
    Project project = new Project();
    project.setName("Is available unit test.");
    
    String sourceDir =  TestHelper.TREE_DIR;
    String filename = "test.txt";
    String sourceFile = sourceDir + filename;    
    long start = System.currentTimeMillis();

    new WaitFor(project).setMaxWaitC(100).setMaxWaitUnitC(WaitFor.Unit.MILLISECOND)
  	.addC(new Available(project).setFileC(sourceFile))
  	.execute();

    long end = System.currentTimeMillis();
    long result = end - start;
    
    boolean isAcceptable = (1 < result && result < 100);
     
    Assert.assertTrue("WaitFor duration outside acceptable parameters.", isAcceptable);
    
  }  

  
}
