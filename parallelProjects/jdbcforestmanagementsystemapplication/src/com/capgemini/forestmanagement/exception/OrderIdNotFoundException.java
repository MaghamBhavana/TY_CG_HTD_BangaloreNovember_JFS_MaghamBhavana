package com.capgemini.forestmanagement.exception;

public class OrderIdNotFoundException extends RuntimeException {
	public OrderIdNotFoundException() {
		super("Order not found with this Id");
	}

}
