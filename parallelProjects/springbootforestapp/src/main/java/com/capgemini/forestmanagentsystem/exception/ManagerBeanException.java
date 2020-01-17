package com.capgemini.forestmanagentsystem.exception;

public class ManagerBeanException extends RuntimeException {
	
	String message;
	public ManagerBeanException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		
		return message;
	}

}
