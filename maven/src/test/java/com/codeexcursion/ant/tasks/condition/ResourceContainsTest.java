package com.codeexcursion.ant.tasks.condition;
import com.codeexcursion.ant.TestHelper;
import com.codeexcursion.ant.tasks.condition.HasFreeSpace;

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
public class ResourceContainsTest {
  
  @Test
  public void testDifferentSequentialSearches()  throws IOException {
    String filename = TestHelper.TREE_DIR + "contains.txt";

    Assert.assertTrue(filename + "missing", Files.exists(Paths.get(filename)));
    Project project = new Project();
    project.setName("Resource contains test");

    String searchFor = "One One";
    
    ResourceContains findLogEntry = new ResourceContains.Builder(project)
        .setResource(filename).setSubstring(searchFor)
        .setCasesensitive(true).getResourceContains();    
    
    Assert.assertTrue("One One should have been found in contains.txt", findLogEntry.eval());
    
    findLogEntry.setSubstring("Two Two");
    Assert.assertTrue("Two Two should have been found in contains.txt", findLogEntry.eval());
    
    
  }  

  @Test
  public void testCaseInsensitive()  throws IOException {
    String filename = TestHelper.TREE_DIR + "contains.txt";

    Assert.assertTrue(filename + "missing", Files.exists(Paths.get(filename)));
    Project project = new Project();
    project.setName("Resource contains test");

    String searchFor = "ONE ONE";
    
    ResourceContains findLogEntry = new ResourceContains.Builder(project)
        .setResource(filename).setSubstring(searchFor)
        .setCasesensitive(false).getResourceContains();    
    
    Assert.assertTrue("One One should have been found in contains.txt", findLogEntry.eval());
    
  }  
  
  
  @Test
  public void testNotFound()  throws IOException {
    String filename = TestHelper.TREE_DIR + "contains.txt";
    Project project = new Project();
    project.setName("Resource doesn't contains test");

    String searchFor = "adfsfafdask;lj;lj";
    
    ResourceContains findLogEntry = new ResourceContains.Builder(project)
        .setResource(filename).setSubstring(searchFor)
        .setCasesensitive(false).getResourceContains();    
    
    Assert.assertFalse(searchFor + " should have been found in contains.txt", findLogEntry.eval());
    
  } 
  
  
  
}
