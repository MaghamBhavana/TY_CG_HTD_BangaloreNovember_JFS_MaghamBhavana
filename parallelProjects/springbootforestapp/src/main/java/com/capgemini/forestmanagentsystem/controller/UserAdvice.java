package com.capgemini.forestmanagentsystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.forestmanagentsystem.dto.UserResponse;
import com.capgemini.forestmanagentsystem.exception.ManagerBeanException;

@RestControllerAdvice
public class UserAdvice {
	
	@ExceptionHandler(ManagerBeanException.class)
	public UserResponse handleManagerException (ManagerBeanException e) {
		UserResponse response = new UserResponse();
		response.setStatus(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}


}
