package com.capgemini.healthcaresystem.service;

import com.capgemini.healthcaresystem.dto.User;

public interface UserService {

	boolean register(User user);
	
	User login(String emailId, String userPassword);
}
