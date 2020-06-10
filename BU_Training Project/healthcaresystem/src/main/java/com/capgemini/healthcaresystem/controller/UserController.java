package com.capgemini.healthcaresystem.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaresystem.dto.User;
import com.capgemini.healthcaresystem.dto.UserResponse;
import com.capgemini.healthcaresystem.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse register(@RequestBody User user) {
		UserResponse response = new UserResponse();
		if (service.register(user)) {
			response.setStatusCode(201);
			response.setDescription("Account created successfully");
			response.setMessage("Success");
		} else {
			response.setStatusCode(401);
			response.setDescription("Account already exists");
			response.setMessage("Failure");
		}
		return response;
	}

	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse login(@RequestBody User user) {
		UserResponse response = new UserResponse();
		User account = service.login(user.getEmailId(), user.getUserPassword());
		if (account != null) {
			response.setStatusCode(201);
			response.setDescription("Logged in successfully");
			response.setMessage("Success");
			List<User> userList = new ArrayList<User>();
			userList.add(account);
			response.setUser(userList);
		} else {
			response.setStatusCode(401);
			response.setDescription("Provide valid credentials");
			response.setMessage("Failure");
		}
		return response;
	}
}
