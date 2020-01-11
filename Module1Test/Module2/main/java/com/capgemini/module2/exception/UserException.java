package com.capgemini.module2.exception;

public class UserException extends RuntimeException {
	String message;
	public UserException (String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
