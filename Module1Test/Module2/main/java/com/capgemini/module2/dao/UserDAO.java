package com.capgemini.module2.dao;

import com.capgemini.module2.dto.UserInfoBean;

public interface UserDAO {
	
	public boolean register(UserInfoBean account);
	
	public UserInfoBean login(UserInfoBean credentials);
	
	public boolean updatePassword(String email, String password);

}
