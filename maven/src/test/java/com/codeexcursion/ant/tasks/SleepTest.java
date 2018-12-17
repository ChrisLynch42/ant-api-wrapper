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
public class SleepTest {
  
  @Test
  public void testSleep()  throws IOException {
    Project project = new Project();
    project.setName("Is available unit test.");
    
    long start = System.currentTimeMillis();

    new Sleep(project).setMillisecondsC(500).execute();

    long end = System.currentTimeMillis();
    long result = end - start;
    
    boolean isAcceptable = (400 < result && result < 600);
     
    Assert.assertTrue("Sleep duration outside acceptable parameters.", isAcceptable);
    
    
  }  

  
}
