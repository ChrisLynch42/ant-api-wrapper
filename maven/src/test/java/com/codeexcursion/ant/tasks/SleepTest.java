package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.Project;

import java.io.IOException;
import org.junit.Assert;
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

    new Sleep.Builder(project).setMilliseconds(500).getSleep().execute();

    long end = System.currentTimeMillis();
    long result = end - start;
    
    boolean isAcceptable = (400 < result && result < 600);
     
    Assert.assertTrue("Sleep duration outside acceptable parameters.", isAcceptable);
    
    
  }  

  
}
