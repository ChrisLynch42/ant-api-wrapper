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
public class JavaVersionTest {
  
  @Test
  public void testIsValid()  throws IOException {
    Assert.assertTrue("Should have version greater than or equal to 7.", new JavaVersion.Builder().setAtLeast("1.7").getJavaVersion().eval());
  }  

  
  @Test
  public void testNotValid() throws IOException {
    Assert.assertFalse("Should not have a Java Version greater than or equal to 100.", new JavaVersion.Builder().setAtLeast("100").getJavaVersion().eval());
  }  
  
  
  
}
