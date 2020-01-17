package com.capgemini.forestmanagement.exception;

public class ProductIdNotFoundException extends RuntimeException {
	public ProductIdNotFoundException() {
		super("Product not found with this Id");
	}

}
