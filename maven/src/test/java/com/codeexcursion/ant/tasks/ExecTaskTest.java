/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.Project;
import com.codeexcursion.ant.TestHelper;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import org.junit.Assert;
import org.apache.tools.ant.Target;
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
    
    Target bob = new Target();
    
    
   Execute execute = new Execute.Builder(project)
      .setExecutable("ls")
      .addArgument("-alrt")
      .getExecute();

   bob.addTask(execute);
   
   
   Optional<String> result1 = execute.executeOutput();

    
    Assert.assertNotNull("Output should not be null.", result1.get());
    Assert.assertTrue("Output should not be empty.", result1.get().length() > 5);
    
    
    String filename = "deleteme_test_file.txt"; 
    new Execute.Builder(project)
    .setExecutable("touch")
    .addArgument(filename)
    .getExecute().execute();    
    
    
    new Sleep.Builder(project).setMilliseconds(1000).getSleep().execute();
    
    
    
    
    Optional<String> result2 = new Execute.Builder(project)
        .setExecutable("ls")
        .addArgument("-alrt")
        .getExecute().executeOutput();
    
    new Delete.Builder(project).setFile(filename).getDelete().execute();
    
    
    Assert.assertNotEquals("Result 1 and result 2 should not match: ----\n"  + result1.get() +"\n----\n" + result2.get() + "\n----\n", 
        result1.get(), result2.get());
  }

  @Test
  public void testRun2() {
    Project project = new Project();
    project.setName("Test Run Executable on host os.");
    
    Optional<String> result = new Execute.Builder(project)
          .setExecutable("ls")
          .addArgument("-alrt").getExecute()
          .executeOutput();
    
    
    Assert.assertNotNull("Output should not be null.", result.get());
    Assert.assertTrue("Output should not be empty.", result.get().length() > 5);
  }  
  
}
