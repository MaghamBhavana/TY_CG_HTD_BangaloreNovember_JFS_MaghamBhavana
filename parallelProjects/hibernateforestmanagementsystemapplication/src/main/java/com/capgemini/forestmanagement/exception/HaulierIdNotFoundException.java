package com.capgemini.forestmanagement.exception;

public class HaulierIdNotFoundException extends RuntimeException {
	public HaulierIdNotFoundException() {
		super("Haulier number not found");
	}

}
