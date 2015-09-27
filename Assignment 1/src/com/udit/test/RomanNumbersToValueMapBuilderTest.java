package com.udit.test;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.udit.builder.RomanNumbersToValueMapBuilder;

public class RomanNumbersToValueMapBuilderTest {
	private RomanNumbersToValueMapBuilder mapBuilder;
	
    @Test
    public void testRomanNumbersToValueMapBuilder() {
        Assert.assertNotNull(mapBuilder.romanToNumberMap);
        
    }
 
}
