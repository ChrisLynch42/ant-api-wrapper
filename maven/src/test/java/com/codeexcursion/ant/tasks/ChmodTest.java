/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.TestHelper;
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
public class ChmodTest {
  
  @Test
  public void testChmod()  throws IOException {
    Project project = new Project();
    project.setName("Chmod unit test.");
    
    String destDir = TestHelper.BASE_DIR + "copyDeleteDest/";
    testCopyAndDeleteTree1(project, destDir);
    
    new Chmod(project)
      .setDirC(destDir)
      .setPermC("u+rwx,g-rwx,o-rwx")
      .setTypeC("dir")
      .execute();
    
    Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(Paths.get(destDir), LinkOption.NOFOLLOW_LINKS);
    Assert.assertTrue("User did not have read permission.", permissions.contains(PosixFilePermission.OWNER_READ));
    Assert.assertTrue("User did not have execute permission.", permissions.contains(PosixFilePermission.OWNER_EXECUTE));
    Assert.assertTrue("User did not have write permission.", permissions.contains(PosixFilePermission.OWNER_WRITE));
    
    Assert.assertFalse("Group did have read permission.", permissions.contains(PosixFilePermission.GROUP_READ));
    Assert.assertFalse("Group did have execute permission.", permissions.contains(PosixFilePermission.GROUP_EXECUTE));
    Assert.assertFalse("Group did have write permission.", permissions.contains(PosixFilePermission.GROUP_WRITE));
    
    Assert.assertFalse("Others did have read permission.", permissions.contains(PosixFilePermission.OTHERS_READ));
    Assert.assertFalse("Others did have execute permission.", permissions.contains(PosixFilePermission.OTHERS_EXECUTE));
    Assert.assertFalse("Others did have write permission.", permissions.contains(PosixFilePermission.OTHERS_WRITE));    
    
    new Chmod(project)
      .setDirC(destDir)
      .setPermC("u+rwx,g+rwx,o+rwx")
      .setTypeC("dir")
      .execute();

    permissions = Files.getPosixFilePermissions(Paths.get(destDir), LinkOption.NOFOLLOW_LINKS);
    Assert.assertTrue("User did not have read permission.", permissions.contains(PosixFilePermission.OWNER_READ));
    Assert.assertTrue("User did not have execute permission.", permissions.contains(PosixFilePermission.OWNER_EXECUTE));
    Assert.assertTrue("User did not have write permission.", permissions.contains(PosixFilePermission.OWNER_WRITE));
    
    Assert.assertTrue("Group did not have read permission.", permissions.contains(PosixFilePermission.GROUP_READ));
    Assert.assertTrue("Group did not have execute permission.", permissions.contains(PosixFilePermission.GROUP_EXECUTE));
    Assert.assertTrue("Group did not have write permission.", permissions.contains(PosixFilePermission.GROUP_WRITE));
    
    Assert.assertTrue("Others did not have read permission.", permissions.contains(PosixFilePermission.OTHERS_READ));
    Assert.assertTrue("Others did not have execute permission.", permissions.contains(PosixFilePermission.OTHERS_EXECUTE));
    Assert.assertTrue("Others did not have write permission.", permissions.contains(PosixFilePermission.OTHERS_WRITE));    
    
    testCopyAndDeleteTree2(project, destDir);
  }  
  
}
