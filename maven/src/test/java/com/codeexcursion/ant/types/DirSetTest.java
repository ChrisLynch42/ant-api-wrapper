/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.types;
import com.codeexcursion.ant.TestHelper;
import java.util.Objects;
import org.apache.tools.ant.Project;
import org.junit.Test;
/**
 *
 * @author chris
 */
public class DirSetTest {
  
  @Test
  public void testFindFiles() {
    Project project = new Project();
    project.setName("Directory set unit test.");      
    DirSet dirSet = new DirSet(project);
      
    String sourceDir =  TestHelper.TREE_DIR;
    
    dirSet.setDir(sourceDir);
    dirSet.setIncludes("**/*.txt");
    
    
    System.out.println("xxxxxxxxxxxxxxxxxx");
    System.out.println("xxxxxxxxxxxxxxxxxx");
    System.out.println("xxxxxxxxxxxxxxxxxx");
    System.out.println("xxxxxxxxxxxxxxxxxx");
    System.out.println("xxxxxxxxxxxxxxxxxx");
    System.out.println("xxxxxxxxxxxxxxxxxx");
    dirSet.getAntType().stream().filter(Objects::nonNull).forEach((item) -> System.out.println(item.getName()));
    System.out.println("yyyyyyyyyyyyyyyyyyy");
    System.out.println("yyyyyyyyyyyyyyyyyyy");
    System.out.println("yyyyyyyyyyyyyyyyyyy");
    System.out.println("yyyyyyyyyyyyyyyyyyy");
    System.out.println("yyyyyyyyyyyyyyyyyyy");
    System.out.println("yyyyyyyyyyyyyyyyyyy");
    
   System.out.println(dirSet.getAntType().toString());
    System.out.println("zzzzzzzzzzzzzzzzzzzzzzz");
    System.out.println("zzzzzzzzzzzzzzzzzzzzzzz");
    System.out.println("zzzzzzzzzzzzzzzzzzzzzzz");
    System.out.println("zzzzzzzzzzzzzzzzzzzzzzz");
    System.out.println("zzzzzzzzzzzzzzzzzzzzzzz");

  }

  
  
}
