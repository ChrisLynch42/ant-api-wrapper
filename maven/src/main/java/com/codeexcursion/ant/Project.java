package com.codeexcursion.ant;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Project extends org.apache.tools.ant.Project {
  private ConcurrentHashMap<String, String> variables = new ConcurrentHashMap<>();

  /**
   * Override the setNewProperty and add functionality to track
   * transient values.
   *
   * @param name The name of property to set.
   *             Must not be <code>null</code>.
   * @param value The new value of the property.
   *              Must not be <code>null</code>.
   */
  @Override
  public void setNewProperty(final String name, final String value) {
    super.setNewProperty(name, value);
    setVariable(name, value);
  }
  
  
  /**
   * Override setProperty and add functionality to track
   * transient values.
   * @param name The name of property to set.
   *             Must not be <code>null</code>.
   * @param value The new value of the property.
   *              Must not be <code>null</code>.
   */
  @Override
  public void setProperty(final String name, final String value) {
    super.setProperty(name, value);
    setVariable(name, value);
  }  
  
  
  private void setVariable(final String name, final String value) {
    if(name != null && value != null) {
      variables.put(name, value);
    }
  }
  
  /**
   * This returns the last value setNewProperty or
   * setProperty tried to set.  This will have the
   * values whether or not an existing property is
   * changed or not.
   * @param name The name of property to get.
   */  
  public Optional<String> getLastValue(String name) {
    return Optional.ofNullable(variables.get(name));
  }
}
