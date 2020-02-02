package com.capgemini.stockmanagement.exception;

public class MaxStocksExceedsException extends Exception {
	String message;

	public MaxStocksExceedsException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
