package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.dto.UserBean;

public interface UserService {
	
	public boolean addUser(UserBean bean);

	public UserBean login(String email, String password,String role);
	
	public boolean deleteUser(String email);
	
	public List<UserBean> getAllUsers();
}
