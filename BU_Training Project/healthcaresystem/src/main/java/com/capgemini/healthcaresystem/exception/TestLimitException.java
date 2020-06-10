package com.capgemini.healthcaresystem.exception;

public class TestLimitException extends Exception {
	
	String message;

	public TestLimitException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
