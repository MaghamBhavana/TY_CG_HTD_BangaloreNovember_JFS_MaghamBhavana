package com.capgemini.stockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagement.dao.UserDAO;
import com.capgemini.stockmanagement.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO dao;

	@Override
	public boolean addUser(User user) {
		return dao.addUser(user);
	}

	@Override
	public boolean deleteUser(int userId) {
		return dao.deleteUser(userId);
	}

	@Override
	public boolean updatePassword(int userId, String password) {
		return dao.updatePassword(userId, password);
	}

	@Override
	public User loginUser(String email, String password) {
		return dao.loginUser(email, password);
	}

	@Override
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}
}
