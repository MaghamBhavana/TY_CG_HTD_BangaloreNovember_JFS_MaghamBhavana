package com.capgemini.healthcaresystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.UserDAO;
import com.capgemini.healthcaresystem.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;
	
	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return dao.register(user);
	}

	@Override
	public User login(String emailId, String userPassword) {
		// TODO Auto-generated method stub
		return dao.login(emailId, userPassword);
	}
}
