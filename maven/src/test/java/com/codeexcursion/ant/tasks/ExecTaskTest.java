/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.TestHelper;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Assert;
import org.apache.tools.ant.Project;
import org.junit.Test;
/**
 *
 * @author chris
 */
public class ExecTaskTest {
  
  @Test
  public void testRun() {
    Project project = new Project();
    project.setName("Test Run Executable on host os.");
    String outputK3y = "test_output";
    
    String os = System.getProperty("os.name");
    
    if(os == null || os.isEmpty()) {
        Assert.fail("Failed to detect operating system.");
    }
    
    if(os.toLowerCase().contains("inux")) {
        new Execute.Builder(project)
          .setExecutable("ls")
          .addArgument("-alrt")
          .setOutputproperty(outputK3y).getExecute()
          .execute();
    }
    
    if(os.toLowerCase().contains("indow")) {
        new Execute.Builder(project)
          .setExecutable("dir")
          .addArgument("/w")
          .setOutputproperty(outputK3y).getExecute()
          .execute();
    }
    
    Assert.assertNotNull("Output should not be null.", project.getProperty(outputK3y));
    Assert.assertTrue("Output should not be null.", project.getProperty(outputK3y).length() > 5);
  }

  @Test
  public void testRun2() {
    Project project = new Project();
    project.setName("Test Run Executable on host os.");
    
    String result = new Execute.Builder(project)
          .setExecutable("ls")
          .addArgument("-alrt").getExecute()
          .executeOutput();
    
    
    Assert.assertNotNull("Output should not be null.", result);
    Assert.assertTrue("Output should not be null.", result.length() > 5);
  }  
  
}
