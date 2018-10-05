/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.packager.tasks;
import com.codeexcursion.packager.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;
import junit.framework.Assert;
import com.codeexcursion.ant.tasks.Chmod;
import com.codeexcursion.ant.tasks.Copy;
import com.codeexcursion.ant.tasks.Delete;
import com.codeexcursion.ant.tasks.ExecTask;
import com.codeexcursion.ant.tasks.Mkdir;
import org.apache.commons.configuration2.Configuration;
import org.apache.tools.ant.Project;
import static org.mockito.Mockito.*;
import org.junit.Test;
/**
 *
 * @author chris
 */
public class CopyTest {
  
  @Test
  public void testFlattenCopy() {
    Project project = new Project();
    project.setName("Copy unit test.");
    
    String destDir = "bob";
    new Mkdir(project).setDir(destDir).execute();
    String sourceDir = "./src/test/artifacts/maven/portlet-hooks";

    String filename = "**/target/*.jar";

    new Copy(project)
      .setToDir(destDir)
      .addFileset(sourceDir, filename)
      .setFlatten(true)
      .execute();
    
    filename = destDir + "/codeexcursion-shared-2.07.000.jar";
    Assert.assertTrue("File " + filename + " should exist.", Files.exists(Paths.get(filename)));
    
    new Delete(project).setDir(destDir).execute();
  }

}
