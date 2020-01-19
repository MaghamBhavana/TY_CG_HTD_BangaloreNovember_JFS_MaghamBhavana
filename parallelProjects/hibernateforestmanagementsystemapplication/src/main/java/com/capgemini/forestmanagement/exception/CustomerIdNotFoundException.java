package com.capgemini.forestmanagement.exception;

public class CustomerIdNotFoundException extends RuntimeException {
	public CustomerIdNotFoundException() {
		super("Customer number not found");
	}

}
