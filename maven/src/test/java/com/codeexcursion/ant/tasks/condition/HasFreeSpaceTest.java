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
public class HasFreeSpaceTest {
  
  @Test
  public void testIsValid()  throws IOException {
    Assert.assertTrue("Root did not have 10K disk space free.", new HasFreeSpace().setPartitionC("/").setNeededC("10K").eval());
  }  

  
  @Test
  public void testNotValid() throws IOException {
    Assert.assertFalse("Root should not have 1000G disk space free.", new HasFreeSpace().setPartitionC("/").setNeededC("1000G").eval());
  }  
  
  
  
}
