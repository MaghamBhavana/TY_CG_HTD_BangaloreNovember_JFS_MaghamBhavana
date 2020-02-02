package com.capgemini.stockmanagement.exception;

public class MaxAmountExceedsException extends Exception {

	String message;

	public MaxAmountExceedsException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
