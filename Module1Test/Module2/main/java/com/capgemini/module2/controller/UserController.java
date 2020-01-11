package com.capgemini.module2.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.module2.dto.UserInfoBean;
import com.capgemini.module2.dto.UserInfoBeanResponse;
import com.capgemini.module2.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserInfoBeanResponse register(@RequestBody UserInfoBean account) {
		UserInfoBeanResponse response = new UserInfoBeanResponse();
		service.register(account);
		response.setStatusCode(201);
		response.setDescription("Success");
		response.setMessage("Registered Successfully");
		return response;
	}
	
	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserInfoBeanResponse login(@RequestBody UserInfoBean credentials) {
		UserInfoBeanResponse response = new UserInfoBeanResponse();
		UserInfoBean user = service.login(credentials);
		if (user != null) {
			response.setStatusCode(201);
			response.setDescription("Success");
			response.setMessage("Logged in Successfully");
			response.setUser(Arrays.asList(user));
		} else {
			response.setStatusCode(405);
			response.setDescription("Failure");
			response.setMessage("Invalid credentials");
		}
		return response;
	}
	
	@PutMapping(path = "/update-password", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserInfoBeanResponse modifyPassword(@RequestBody UserInfoBean user) {
		UserInfoBeanResponse response = new UserInfoBeanResponse();
		if (service.updatePassword(user.getEmail(), user.getPassword())) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Password updated successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Not updated");
		}
		return response;
	}

}
