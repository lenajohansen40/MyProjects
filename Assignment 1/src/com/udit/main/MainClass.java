package com.udit.main;

import static com.udit.builder.BaseAndCreditListBuilder.getBaseAndCreditList;
import static com.udit.builder.BaseAndCreditListBuilder.creditList;
import static com.udit.builder.BaseAndCreditListBuilder.baseList;
import static com.udit.rules.Rules.outputRule1;
import static com.udit.rules.Rules.outputRule2;
import static com.udit.utility.UtilityClass.applyRules;
import static com.udit.utility.UtilityClass.findCreditName;
import static com.udit.utility.UtilityClass.processtTokens;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.udit.customexception.InvalidInputStringException;

public class MainClass {
	public static void main(String[] args) {
		doProcessing();

	}

	public static void doProcessing() {
		// code to build inputs
		try {
			List<String> list = MainClass.buildInput();
			getBaseAndCreditList(list);
			String queryRequest = "";
			List<String> queryList = MainClass.buildRequestQuery();
			Iterator<String> it = queryList.iterator();
			BufferedWriter bufferedWriter;

			bufferedWriter = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(".//data//output.txt")));

			while (it.hasNext()) {
				String outPutString = getOutput(it.next().toString(),
						creditList);
				System.out.println(outPutString);
				bufferedWriter.write(outPutString);
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
		} catch (InvalidInputStringException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("Output File not found:");
		} catch (IOException e) {
			System.out.println("Output File not found:");
		}
	}

	private static String getOutput(String requestQuery,
			HashMap<String, Float> creditList)
			throws InvalidInputStringException {
		// Output Format Rules
		String finaloutput;
		if (true == applyRules(requestQuery, outputRule1)) {
			String outputString = getResult(requestQuery);
			finaloutput = outputString + "is " + processtTokens(outputString);
		} else if (true == applyRules(requestQuery, outputRule2)) {
			String outputString = getResult(requestQuery);
			String keyForCreditList = findCreditName(outputString);
			float creditVal = creditList.get(keyForCreditList);
			float processToken = processtTokens(outputString);
			finaloutput = outputString + " is " + creditVal * processToken
					+ " Credits";
		} else {
			finaloutput = "I have no idea what you are talking about";
		}
		return finaloutput;
	}

	public static List<String> buildInput() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(".//data//input.txt")));
			ArrayList<String> list = new ArrayList<String>();
			String inputLine = null;
			while ((inputLine = br.readLine()) != null) {
				list.add(inputLine);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<String> buildRequestQuery() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(".//data//query.txt")));
			ArrayList<String> list = new ArrayList<String>();
			String inputLine = null;
			while ((inputLine = br.readLine()) != null) {
				list.add(inputLine);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static String getResult(String request) {
		int start = request.indexOf("is ");
		int end = request.indexOf(" ?");
		String outPutString = request.substring(start + 3, end);
		return outPutString;
	}

}
