package com.capgemini.healthcaresystem.dao;

import com.capgemini.healthcaresystem.dto.User;

public interface UserDAO {

	boolean register(User user);
	
	User login(String emailId, String userPassword);

}
