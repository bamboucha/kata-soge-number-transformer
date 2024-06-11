package com.evaluation.service;

public interface ITransformationRule {

	boolean isApplicable(int numbe);

	String apply();
}