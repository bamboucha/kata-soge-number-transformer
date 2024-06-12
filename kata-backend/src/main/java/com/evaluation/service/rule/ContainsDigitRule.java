package com.evaluation.service.rule;

import java.util.Arrays;

import com.evaluation.service.ITransformationRule;

public class ContainsDigitRule implements ITransformationRule {

	private final char digit;
	private final String result;

	public ContainsDigitRule(char digit, String result) {
		this.digit = digit;
		this.result = result;
	}

	public boolean isApplicable(int number) {
		return String.valueOf(number).indexOf(digit) != -1;
	}

	@Override
	public String apply(int number) {
		StringBuilder val = new StringBuilder();
		int[] intArray = String.valueOf(number).chars().map(Character::getNumericValue).toArray();
		
		Arrays.stream(intArray).forEach(value -> {
			if (isApplicable(value)) {
				val.append(result);
			}
		});
		return val.toString();
	}

}
