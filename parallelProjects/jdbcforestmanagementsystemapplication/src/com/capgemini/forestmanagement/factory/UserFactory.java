package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.UserDAO;
import com.capgemini.forestmanagement.dao.UserDAOImpl;
import com.capgemini.forestmanagement.service.UserService;
import com.capgemini.forestmanagement.service.UserServiceImpl;

public class UserFactory {
	public static UserDAO instanceOfManagerDAOImpl() {
		return new UserDAOImpl();
	}

	public static UserService instanceOfManagerServiceImpl() {
		return new UserServiceImpl();
	}

}
