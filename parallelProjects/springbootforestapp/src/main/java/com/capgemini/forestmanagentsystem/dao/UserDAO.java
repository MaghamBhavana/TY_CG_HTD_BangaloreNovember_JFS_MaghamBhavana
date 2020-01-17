package com.capgemini.forestmanagentsystem.dao;

import com.capgemini.forestmanagentsystem.dto.UserBean;

public interface UserDAO {

	public boolean add(UserBean bean);

	public UserBean login(String email, String password,String role);
	
	public boolean updatePassword(String email, String password);

}
