/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant;
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
import org.apache.tools.ant.Project;
/**
 *
 * @author chris
 */
public class TestHelper {
  public final static String BASE_DIR = "src/test/artifacts/";
  public final static String TREE_DIR = BASE_DIR + "treeSrc/";

  
/*
  public void testMkdirAndDelete() {
    Project project = new Project();
    project.setName("Copy unit test.");
    
    String deleteDir = "src/test/artifacts/bob";
    String destDir = deleteDir + "/sam";
    if(Files.exists(Paths.get(deleteDir))) {
      new Delete(project).setDir(deleteDir).execute();
    }
    new Mkdir(project).setDir(destDir).execute();
    Assert.assertTrue("Directory " + destDir + " should exist.", Files.exists(Paths.get(destDir)));

    new Delete(project).setDir(deleteDir).execute();
    Assert.assertFalse("Directory " + destDir + " should not exist.", Files.exists(Paths.get(destDir)));
    Assert.assertFalse("Directory " + deleteDir + " should not exist.", Files.exists(Paths.get(deleteDir)));
    
  }
*/  
  
  
  
  public void testChmod() throws IOException {
    Project project = new Project();
    project.setName("Copy unit test.");
    
    String destDir = TestHelper.BASE_DIR + "copyDeleteDest/";
    String sourceDir =  TestHelper.TREE_DIR;


    String filename = destDir + "/esapi-2.1.0.jar";
    String dirname = destDir + "/esapi";

    new Chmod(project)
      .setDir(destDir)
      .setPerm("u+rwx,g-rwx,o-rwx")
      .setType("dir")
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
      .setDir(destDir)
      .setPerm("u+rwx,g+rwx,o+rwx")
      .setType("dir")
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
    
    new Copy(project)
      .setToDir(destDir)
      .addFileset(sourceDir, "**/*")
      .execute();

    new Chmod(project)
      .addFileset(destDir, "**/*")
      .setPerm("u+rwx,g-rwx,o-rwx")
      .setType("file")
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

    permissions = Files.getPosixFilePermissions(Paths.get(filename), LinkOption.NOFOLLOW_LINKS);
    Assert.assertTrue("User did not have read permission.", permissions.contains(PosixFilePermission.OWNER_READ));
    Assert.assertTrue("User did not have execute permission.", permissions.contains(PosixFilePermission.OWNER_EXECUTE));
    Assert.assertTrue("User did not have write permission.", permissions.contains(PosixFilePermission.OWNER_WRITE));
    
    Assert.assertFalse("Group did have read permission.", permissions.contains(PosixFilePermission.GROUP_READ));
    Assert.assertFalse("Group did have execute permission.", permissions.contains(PosixFilePermission.GROUP_EXECUTE));
    Assert.assertFalse("Group did have write permission.", permissions.contains(PosixFilePermission.GROUP_WRITE));
    
    Assert.assertFalse("Others did have read permission.", permissions.contains(PosixFilePermission.OTHERS_READ));
    Assert.assertFalse("Others did have execute permission.", permissions.contains(PosixFilePermission.OTHERS_EXECUTE));
    Assert.assertFalse("Others did have write permission.", permissions.contains(PosixFilePermission.OTHERS_WRITE));

    new Delete(project)
      .addFileset(destDir, "**/*")
      .execute();
  }

  
/*  
  public void testExecTar() {
    Project project = new Project();
    
    String sourceDir = templateBaseDir;
    String destDir = baseDir;
    String filename = "codeexcursion_DEV_configuration.tgz";
    String destFile = destDir + "/" + filename;
    
    new Delete(project)
      .addFileset(destDir, filename)
      .execute();

    new ExecTask(project)
      .setExecutable("tar")
      .addArgument("-czf")
      .addArgument(destFile)
      .addArgument("-C")
      .addArgument(sourceDir)
      .addArgument(".")
      .execute();
      
    Assert.assertTrue("Tar file does not exist:  " + destFile, Files.exists(Paths.get(destFile)));

    new Delete(project)
      .addFileset(destDir, filename)
      .execute();
  }

*/
}
