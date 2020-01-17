package com.capgemini.forestmanagentsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagentsystem.dao.UserDAO;
import com.capgemini.forestmanagentsystem.dto.UserBean;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO dao;

	@Override
	public boolean add(UserBean bean) {

		return dao.add(bean);
	}

	@Override
	public UserBean login(String email, String password,String role) {

		return dao.login(email, password,role);
	}

	@Override
	public boolean updatePassword(String email, String password) {
		
		return dao.updatePassword(email,password);
	}

}
