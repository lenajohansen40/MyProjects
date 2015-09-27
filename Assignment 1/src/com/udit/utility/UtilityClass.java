package com.udit.utility;

import static com.udit.rules.Rules.romanNumberRules;

import java.util.HashMap;
import java.util.regex.Pattern;
import static  com.udit.builder.BaseAndCreditListBuilder.baseList;
import static  com.udit.builder.BaseAndCreditListBuilder.creditList;
import static  com.udit.builder.BaseAndCreditListBuilder.getBaseAndCreditList;
import com.udit.builder.RomanNumbersToValueMapBuilder;
import com.udit.customexception.InvalidInputStringException;
public class UtilityClass {
	
	// to convert roman number into numeric value
	public static int romanToNumber(String inputString,HashMap<Character, Integer> maplist)
	{
		int outputNumber = 0;
		for(int i=0,j=1;j<=inputString.length();i++,j++)
		{
		  if(j==inputString.length()){
			  outputNumber +=maplist.get(inputString.charAt(i));
		  }
		  else if(maplist.get(inputString.charAt(i)) >= maplist.get(inputString.charAt(j)))
			{
				outputNumber += maplist.get(inputString.charAt(i));
			}
			else if(maplist.get(inputString.charAt(i)) < maplist.get(inputString.charAt(j)))
			{
				outputNumber += maplist.get(inputString.charAt(j)) - maplist.get(inputString.charAt(i));
				i++;j++;
			}
		}
		return outputNumber;
	}
	
	// getting the credit value from given string eg. silver,gold,iron numeric values
	public static float getCreditValue(HashMap<String, Character> baseList,
			String input) throws InvalidInputStringException {
		String romanValue = baseList.get(input.substring(0, 4)).toString()
				+ baseList.get(input.substring(5, 9)).toString();
		int decimal_value = convertRomanToNumber(romanValue);
		
		int start = input.indexOf(" is ");
		int end = input.indexOf(" Credits");
		String creditValueStr = input.substring(start + 3, end);
		return (Float.valueOf(creditValueStr) / decimal_value);
	}
	
	
	//to validate the Roman number and Converting it into numeric value
	public static int convertRomanToNumber(String input) throws InvalidInputStringException {
        HashMap<Character, Integer> maplist = RomanNumbersToValueMapBuilder.romanToNumberMap;
        String inputString = input.trim();
        // Check the roman number rules for given string
		boolean applyRules=applyRules(inputString,romanNumberRules);
		if(applyRules==false){
			throw new InvalidInputStringException("input string is invalid");
		}
       return UtilityClass.romanToNumber(inputString, maplist);

	}
	
	
    // to  apply pattern rules to input string,roman number and output string
	public static boolean applyRules(String inputString,Pattern pattern ) {
		return pattern.matcher(inputString).find();
	}
	
	public static String findCreditName(String outputString) {
		outputString = outputString.trim();
		int found = outputString.lastIndexOf(" ");
		return outputString.substring(found + 1);
	}
	
	public static int processtTokens(String str) throws InvalidInputStringException {
		String[] tokens = str.split(" ");
		String tempStr = "";
		for (int counter = 0; counter < tokens.length; counter++) {
			String t = tokens[counter];
			if (baseList.get(t) != null)
				tempStr += baseList.get(t);
		}
		return convertRomanToNumber(tempStr);
	}
}
