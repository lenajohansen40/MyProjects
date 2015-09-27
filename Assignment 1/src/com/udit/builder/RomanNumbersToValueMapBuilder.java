package com.udit.builder;

import java.util.HashMap;

public class RomanNumbersToValueMapBuilder {
   public final static HashMap<Character, Integer> romanToNumberMap=new HashMap<Character, Integer>();
  static {
	   romanToNumberMap.put('I', 1);
	   romanToNumberMap.put('V', 5);
	   romanToNumberMap.put('X', 10);
	   romanToNumberMap.put('L', 50);
	   romanToNumberMap.put('C', 100);
	   romanToNumberMap.put('D', 500);
	   romanToNumberMap.put('M', 1000);
   }
  
	
}
