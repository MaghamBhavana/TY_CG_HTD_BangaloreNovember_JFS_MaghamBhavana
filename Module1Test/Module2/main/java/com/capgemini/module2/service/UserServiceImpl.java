package com.capgemini.module2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.module2.dao.UserDAO;
import com.capgemini.module2.dto.UserInfoBean;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO dao;
	
	@Override
	public boolean register(UserInfoBean account) {
		
		return dao.register(account);
	}

	@Override
	public UserInfoBean login(UserInfoBean credentials) {
		
		return dao.login(credentials);
	}

	@Override
	public boolean updatePassword(String email, String password) {
		
		return dao.updatePassword(email, password);
	}

}
