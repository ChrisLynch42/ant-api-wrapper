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
  public void testFlattenCopy() {
    Project project = new Project();
    project.setName("Test Run Executable on host os.");

    String os = System.getProperty("os.name");
    
    if(os == null || os.isEmpty()) {
        Assert.fail("Failed to detect operating system.");
    }
    
    if(os.toLowerCase().contains("inux")) {
        new Execute(project)
          .setExecutableC("ls")
          .addArgumentC("-alrt")
          .execute();
    }
    
    if(os.toLowerCase().contains("indow")) {
        new Execute(project)
          .setExecutableC("dir")
          .addArgumentC("/w")
          .execute();
    }
  }

  
}
