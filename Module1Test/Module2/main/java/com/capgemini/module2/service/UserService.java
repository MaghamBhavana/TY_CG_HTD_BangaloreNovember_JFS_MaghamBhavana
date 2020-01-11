package com.capgemini.module2.service;

import com.capgemini.module2.dto.UserInfoBean;

public interface UserService {
	
	public boolean register(UserInfoBean account);
	
	public UserInfoBean login(UserInfoBean credentials);
	
	public boolean updatePassword(String email, String password);

}
