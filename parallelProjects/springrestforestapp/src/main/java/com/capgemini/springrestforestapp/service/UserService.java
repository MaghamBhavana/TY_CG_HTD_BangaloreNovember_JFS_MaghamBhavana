package com.capgemini.springrestforestapp.service;

import com.capgemini.springrestforestapp.dto.UserBean;

public interface UserService {
	public boolean add(UserBean bean);

	public UserBean login(String email, String password,String role);
	
	public boolean updatePassword(String email, String password);
}
