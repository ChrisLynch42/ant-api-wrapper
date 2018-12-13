
package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.TestHelper;
import com.codeexcursion.ant.types.FileSet;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Assert;
import org.apache.tools.ant.Project;
import org.junit.Test;
/**
 *
 * @author chris
 */
public class ResourceCountTest {
  
  @Test
  public void testValidInvalidCounts() {
    Project project = new Project();
    project.setName("Flatten copy unit test.");
    
    String sourceDir =  TestHelper.TREE_DIR + "test";
    FileSet fileSet = new FileSet(project);
    fileSet.setDirC(sourceDir).setIncludesC("*.txt");
    
    Assert.assertTrue("Resource count should be 3.", new ResourceCount(project).addC(fileSet).setCountC(3).eval());
    Assert.assertFalse("Resource count should be false.", new ResourceCount(project).addC(fileSet).setCountC(4).eval());
  }

   
}
