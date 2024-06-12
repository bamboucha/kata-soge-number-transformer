package com.evaluation.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.evaluation.service.rule.ContainsDigitRule;
import com.evaluation.service.rule.DivisibleByRule;

@Service
public class NumberTransformer {
	private final List<ITransformationRule> rules;

	public NumberTransformer(final List<ITransformationRule> rules) {
		this.rules = Arrays.asList(
				new DivisibleByRule(3, "FOO"),
				new DivisibleByRule(5, "BAR"),
				new ContainsDigitRule('5', "BAR"),
				new ContainsDigitRule('3', "FOO"),
				new ContainsDigitRule('7', "QUIX"));
	}

	public String transform(int number) {
		StringBuilder result = new StringBuilder();
		if (number > 0 && number <= 100) {
			this.rules.stream().forEach(rule -> {
					result.append(rule.apply(number));
			});
		}
		// Si aucune règle
		return result.length() > 0 ? result.toString() : String.valueOf(number);
	}
}
