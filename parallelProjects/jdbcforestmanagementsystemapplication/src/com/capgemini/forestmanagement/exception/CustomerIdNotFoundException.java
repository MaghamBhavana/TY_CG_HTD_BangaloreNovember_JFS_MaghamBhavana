package com.capgemini.forestmanagement.exception;

public class CustomerIdNotFoundException extends RuntimeException {
	public CustomerIdNotFoundException() {
		super("Customer not found with this Id");
	}

}
