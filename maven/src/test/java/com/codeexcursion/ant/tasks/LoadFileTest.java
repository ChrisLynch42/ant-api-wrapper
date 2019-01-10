/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.tasks;
import com.codeexcursion.ant.Project;
import com.codeexcursion.ant.TestHelper;
import com.codeexcursion.ant.filters.TokenFilter;
import com.codeexcursion.ant.tasks.condition.FilesMatch;
import com.codeexcursion.ant.types.FilterChain;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import org.junit.Assert;
import org.apache.tools.ant.filters.StripLineBreaks;
import org.junit.Test;
/**
 *
 * @author chris
 */
public class LoadFileTest {
  
  @Test
  public void testFindPasswordDoubleQuotes() {
    Project project = new Project();
    project.setName("Flatten copy unit test.");
    
    String expectedResult = "password";
    String fileName = "context.xml";
    
    String sourceDir =  TestHelper.TREE_DIR;
    String sourceFile = sourceDir + fileName;

    Assert.assertTrue("Source file doesn't exist.", new Available.Builder(project).setFile(sourceFile).getAvailable().eval());    
    
    TokenFilter tokenFilter = new TokenFilter.Builder(project).addContainsString("password=\"").addReplaceRegex("\\s*password=\\\"", "")
    		.addReplaceRegex("\"", "").getTokenFilter();
    
    Optional<String> result = new LoadFile.Builder(project).setSrcFile(sourceFile)
    		.addFilterChain(new FilterChain.Builder().add(tokenFilter).add(new StripLineBreaks()).getFilterChain())
    		.getLoadFile().executeResult();

    Assert.assertTrue("Result should have a value.", result.isPresent());    
    Assert.assertEquals("Result should match:" + expectedResult, expectedResult, result.get() );    
    
  }

  @Test
  public void testFindPasswordSingleQuotes() {
    Project project = new Project();
    project.setName("Flatten copy unit test.");
    
    String expectedResult = "password2";
    String fileName = "context.xml";
    
    String sourceDir =  TestHelper.TREE_DIR;
    String sourceFile = sourceDir + fileName;

    Assert.assertTrue("Source file doesn't exist.", new Available.Builder(project).setFile(sourceFile).getAvailable().eval());    
    
    TokenFilter tokenFilter = new TokenFilter.Builder(project).addContainsString("password='").addReplaceRegex("\\s*password='", "")
    		.addReplaceRegex("\'", "").getTokenFilter();
    
    Optional<String> result = new LoadFile.Builder(project).setSrcFile(sourceFile)
    		.addFilterChain(new FilterChain.Builder().add(tokenFilter).add(new StripLineBreaks()).getFilterChain())
    		.getLoadFile().executeResult();

    Assert.assertTrue("Result should have a value.", result.isPresent());    
    Assert.assertEquals("Result should match:" + expectedResult, expectedResult, result.get() );    
    
  }
  
  
}
