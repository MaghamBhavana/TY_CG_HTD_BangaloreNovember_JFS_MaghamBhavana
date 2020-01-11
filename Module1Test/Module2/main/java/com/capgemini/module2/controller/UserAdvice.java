package com.capgemini.module2.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.module2.dto.UserInfoBeanResponse;
import com.capgemini.module2.exception.UserException;

@RestControllerAdvice
public class UserAdvice {

	@ExceptionHandler(UserException.class)
	public UserInfoBeanResponse authException(UserException e) {
		UserInfoBeanResponse response = new UserInfoBeanResponse();
		response.setStatusCode(501);
		response.setDescription("Exception");
		response.setMessage(e.getMessage());
		return response;
	}

}
