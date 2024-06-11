package com.evaluation.service.rule;

import com.evaluation.service.ITransformationRule;

public class DivisibleByRule implements ITransformationRule {
	
	private final int divisor;
	private final String result;

	public DivisibleByRule(int divisor, String result) {
        this.divisor = divisor;
        this.result = result;
    }

    @Override
    public boolean isApplicable(int number) {
        return number % divisor == 0;
    }

    @Override
    public String apply() {
        return result;
    }
}
