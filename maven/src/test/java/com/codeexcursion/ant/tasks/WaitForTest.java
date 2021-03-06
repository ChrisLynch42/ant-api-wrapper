package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.TestHelper;

import com.codeexcursion.ant.Project;

import java.io.IOException;
import org.junit.Assert;
import org.apache.tools.ant.BuildException;
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

    new WaitFor.Builder(project).setMaxWait(400).setMaxWaitUnit(WaitFor.Unit.MILLISECOND)
  	.add(new Available.Builder(project).setFile("xxxxxxxxxxxxxxxxxxxx").getAvailable()).getWaitFor().execute();

    long end = System.currentTimeMillis();
    long result = end - start;
    
    boolean isAcceptable = (400 < result && result < 600);
     
    Assert.assertTrue("WaitFor duration outside acceptable parameters:  " + result, isAcceptable);
    
  }  
  
  @Test(expected = BuildException.class)
  public void testNoFileException()  throws IOException {
    Project project = new Project();
    project.setName("Is available unit test.");
    

    new WaitFor.Builder(project).setMaxWait(400).setMaxWaitUnit(WaitFor.Unit.MILLISECOND)
    .add(new Available.Builder(project).setFile("xxxxxxxxxxxxxxxxxxxx").getAvailable()).getWaitFor().executeWithFail();

    
  }  

  @Test
  public void testIsFile()  throws IOException {
    Project project = new Project();
    project.setName("Is available unit test.");
    
    String sourceDir =  TestHelper.TREE_DIR;
    String filename = "test.txt";
    String sourceFile = sourceDir + filename;    
    long start = System.currentTimeMillis();

    new WaitFor.Builder(project).setMaxWait(100).setMaxWaitUnit(WaitFor.Unit.MILLISECOND)
  	.add(new Available.Builder(project).setFile(sourceFile).getAvailable()).getWaitFor()
  	.execute();

    long end = System.currentTimeMillis();
    long result = end - start;
    
    boolean isAcceptable = (result < 3);
     
    Assert.assertTrue("WaitFor duration outside acceptable parameters.", isAcceptable);
    
  }  

  
  
  
}
