package com.udit.rules;

import java.util.regex.Pattern;

public class Rules {
// Rules for Inputs lines	
 public static Pattern inputrule1 = Pattern
	.compile("^(glob|prok|pish|tegj){1}.* is{1} (I|V|X|L){1}$");
 public static Pattern inputrule2 = Pattern
	.compile("^(glob|prok|pish|tegj){1}.* (glob|prok|pish|tegj){1}.* (Silver|Gold|Iron){1} .* Credits$");
 
 // Rules for output lines
 public static Pattern  outputRule1 = Pattern
	.compile("^((how much is)?) ((pish|tegj|glob|prok|\\?)\\s?){0,}$");
 public static Pattern outputRule2 = Pattern
	.compile("^((how many Credits is)?) ((pish|tegj|glob|prok)\\s?){0,}((Silver|Gold|Iron)\\s?){1}\\?$");
 
// Rules for Roman number
 public static Pattern romanNumberRules=Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

 
}