package com.evaluation.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.evaluation.service.rule.ContainsDigitRule;
import com.evaluation.service.rule.DivisibleByRule;

@Service
public class NumberTransformer {
	private final List<ITransformationRule> rules;

	public NumberTransformer(List<ITransformationRule> rules) {
		this.rules = Arrays.asList(
				new DivisibleByRule(3, "FOO"),
				new DivisibleByRule(5, "BAR"),
				new DivisibleByRule(7, "QUIX"),
				new ContainsDigitRule('3', "FOO"),
				new ContainsDigitRule('5', "BAR"),
				new ContainsDigitRule('7', "QUIX"));
	}

	public String transform(int number) {
		StringBuilder result = new StringBuilder();
		//règles de divisibilité
		for (ITransformationRule rule : rules) {
			if (rule instanceof DivisibleByRule && rule.isApplicable(number)) {
				result.append(rule.apply());
			}
		}
		for (ITransformationRule rule : rules) {
			//règles contient
			if (rule instanceof ContainsDigitRule && rule.isApplicable(number)) {
				result.append(rule.apply());
			}
		}
		// Si aucune règle
		return result.length() > 0 ? result.toString() : String.valueOf(number);
	}
}
