package com.capgemini.forestmanagement.dao;

import java.util.List;

import com.capgemini.forestmanagement.dto.UserBean;

public interface UserDAO {
	public boolean addUser(UserBean bean);

	public UserBean login(String email, String password, String role);
	
	public boolean deleteUser(String email);
	
	public List<UserBean> getAllUsers();

}
