/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.ant.types;

import com.codeexcursion.ant.util.PathsUtil;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.filters.ChainableReader;

/**
 *
 * @author chris
 */
public class FilterChain extends org.apache.tools.ant.types.FilterChain {
    
    /**
     * Encapsulates the parent add method.
     * @param filter.
     * @return this object
     */     
    public FilterChain addC(ChainableReader filter) {
    	super.add(filter);
      return this;
    }
        
}
