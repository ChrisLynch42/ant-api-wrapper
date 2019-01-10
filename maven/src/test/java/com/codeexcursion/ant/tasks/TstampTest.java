package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.TestHelper;
import static com.codeexcursion.ant.tasks.CopyTest.testCopyAndDeleteTree1;
import static com.codeexcursion.ant.tasks.CopyTest.testCopyAndDeleteTree2;

import com.codeexcursion.ant.Project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Optional;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author chris
 */
public class TstampTest {
  
  @Test
  public void testValidResult()  throws IOException {
    Project project = new Project();
    project.setName("Is available unit test.");
    String propertyName = "tStamp";
    Optional<String> first = new Tstamp.Builder(project, "yyyy-MM-dd-HH-mm-ss-SSS").getTstamp().executeResult();
    
    Assert.assertNotNull("Result should not be null.", first.get());
    Assert.assertTrue("Result is to short..", first.get().length() > 18);
    String regex = "^\\d{4}-\\d{2}-\\d{2}-\\d{2}-\\d{2}-\\d{2}-\\d{3}.*";
    Assert.assertTrue("Result does not match regex " + regex, first.get().matches(regex));
    
    
    
  }  

  
}
