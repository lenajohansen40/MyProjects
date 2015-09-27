package com.udit.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.udit.builder.BaseAndCreditListBuilder;
import com.udit.customexception.InvalidInputStringException;
import com.udit.utility.UtilityClass;

public class UtilityTest {
	
	@Test
    public void testprocesstTokens() throws InvalidInputStringException {
		 String input1="glob is I";
   	     String input2=" Silver is 34 Credits";
   	     String input3="glob glob";
		 List <String> inputList=new ArrayList <String>();
		 inputList.add(input1);
    	 inputList.add(input2);
    	 BaseAndCreditListBuilder.getBaseAndCreditList(inputList);
		 Assert.assertEquals(2,UtilityClass.processtTokens(input3));	 
    }
	
	@Test
    public void testconvertRomanToNumber() throws InvalidInputStringException {
		 String input="XXXVI";
   	     Assert.assertEquals(36,UtilityClass.convertRomanToNumber(input));
		
    }
	
	
	
}
