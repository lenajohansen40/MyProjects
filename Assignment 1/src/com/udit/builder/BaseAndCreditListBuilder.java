package com.udit.builder;

import static com.udit.rules.Rules.inputrule1;
import static com.udit.rules.Rules.inputrule2;
import static com.udit.utility.UtilityClass.*;

import java.util.HashMap;
import java.util.List;

import com.udit.customexception.InvalidInputStringException;

public class BaseAndCreditListBuilder {
	// Hashmap for baselist like <glob,I> 
	public static HashMap<String, Character> baseList = new HashMap<String, Character>();
	// Hashmap for metals and their values like <silver,X> 
	public static HashMap<String, Float> creditList = new HashMap<String, Float>();
	
	public static void getBaseAndCreditList(List<String> list) throws InvalidInputStringException {

		for (int index = 0; index < list.size(); index++) {
			String input = list.get(index);
            if (true == applyRules(input,inputrule1)) {
				String key = input.substring(0, 4);
				String value = input.substring(input.length() - 1,
						input.length());
				baseList.put(key, value.charAt(0));
			} else if (true == applyRules(input,inputrule2)) {
				float creditValue = 0.0f;
				if (input.contains("Gold") != false) {
					creditValue = getCreditValue(baseList, input);
					creditList.put("Gold", creditValue);
				} else if (input.contains("Silver") != false) {
					creditValue = getCreditValue(baseList, input);
					creditList.put("Silver", creditValue);
				} else if (input.contains("Iron") != false) {
					creditValue = getCreditValue(baseList, input);
					creditList.put("Iron", creditValue);
				} else {
					System.out
							.println("Gold/Silver/Iron only currently allowed");
				}
			}
		}
		
	}
}
