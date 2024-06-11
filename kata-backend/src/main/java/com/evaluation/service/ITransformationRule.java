package com.evaluation.service;

public interface ITransformationRule {

	boolean isApplicable(int number);

	String apply();
}