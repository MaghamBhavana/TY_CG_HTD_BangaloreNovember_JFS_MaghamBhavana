package com.capgemini.healthcaresystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.healthcaresystem.dto.TestResponse;
import com.capgemini.healthcaresystem.exception.TestLimitException;

@RestControllerAdvice
public class TestAdvice {

	@ExceptionHandler(TestLimitException.class)
	public TestResponse handleManagerException (TestLimitException e) {
		TestResponse response = new TestResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}
}
