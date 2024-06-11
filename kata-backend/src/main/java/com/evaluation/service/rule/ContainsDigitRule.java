package com.evaluation.service.rule;

import com.evaluation.service.ITransformationRule;

public class ContainsDigitRule implements ITransformationRule {

	private final char digit;
	private final String result;

	public ContainsDigitRule(char digit, String result) {
		this.digit = digit;
		this.result = result;
	}

	@Override
	public boolean isApplicable(int number) {
		return String.valueOf(number).indexOf(digit) != -1;
	}

	@Override
	public String apply() {
		return result;
	}

}
