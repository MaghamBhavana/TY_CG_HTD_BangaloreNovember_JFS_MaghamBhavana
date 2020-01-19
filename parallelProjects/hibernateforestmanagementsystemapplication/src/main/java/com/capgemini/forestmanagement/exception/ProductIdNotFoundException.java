package com.capgemini.forestmanagement.exception;

public class ProductIdNotFoundException extends RuntimeException {
	public ProductIdNotFoundException() {
		super("Product number not found");
	}

}
