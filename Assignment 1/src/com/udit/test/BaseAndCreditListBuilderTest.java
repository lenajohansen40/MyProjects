package com.udit.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import com.udit.builder.BaseAndCreditListBuilder;
import com.udit.customexception.InvalidInputStringException;

import  static com.udit.builder.BaseAndCreditListBuilder.getBaseAndCreditList;

public class BaseAndCreditListBuilderTest {
private BaseAndCreditListBuilder baseAndCreditListBuilder;
	
    @Test
    public void testbaseAndCreditListBuilder() throws InvalidInputStringException {
    	 String input1="glob is I";
    	 String input2="glob glob Silver is 34 Credits";
    	 List <String> inputList=new ArrayList <String>();
    	 inputList.add(input1);
    	 inputList.add(input2);
         baseAndCreditListBuilder.getBaseAndCreditList(inputList);
		 Assert.assertTrue(baseAndCreditListBuilder.creditList.size()>0);
    	 Assert.assertTrue(baseAndCreditListBuilder.baseList.size()>0);
    }
}
