package com.capgemini.forestmanagentsystem.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestmanagentsystem.dto.UserBean;
import com.capgemini.forestmanagentsystem.dto.UserResponse;
import com.capgemini.forestmanagentsystem.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse register(@RequestBody UserBean user) {
		UserResponse response = new UserResponse();
		if (service.add(user)) {
			response.setStatus(201);
			response.setDescription("Success");
			response.setMessage("Account created successfully");
		} else {
			response.setStatus(405);
			response.setDescription("Failure");
			response.setMessage("Account already exists");
		}
		return response;
	}
	
	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse login(@RequestBody UserBean bean) {
		UserResponse response = new UserResponse();
		UserBean account = service.login(bean.getEmail(),bean.getPassword(),bean.getRole());
		if (account != null) {
			response.setStatus(201);
			response.setDescription("Success");
			response.setMessage("Logged in");
			response.setManager(Arrays.asList(account));
		} else {
			response.setStatus(401);
			response.setDescription("Failure");
			response.setMessage("Provide valid credentials");
		}
		return response;
	}
	
	@PutMapping(path = "/change-password", produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
		public UserResponse changePassword(@RequestBody UserBean bean) {
		
		UserResponse response = new UserResponse();
		if(service.updatePassword(bean.getEmail(),bean.getPassword())) {
			response.setStatus(201);
			response.setMessage("success");
			response.setDescription("Updated successfulyyy");
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("Not updated");
		}
		return response;
	}

}
