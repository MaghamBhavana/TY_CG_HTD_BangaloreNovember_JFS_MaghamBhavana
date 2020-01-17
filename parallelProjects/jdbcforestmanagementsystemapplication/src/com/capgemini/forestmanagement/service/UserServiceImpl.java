package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.dao.UserDAO;
import com.capgemini.forestmanagement.dto.UserBean;
import com.capgemini.forestmanagement.factory.UserFactory;

public class UserServiceImpl implements UserService {

	UserDAO dao = UserFactory.instanceOfManagerDAOImpl();

	@Override
	public UserBean login(String email, String password, String role) {

		return dao.login(email, password, role);
	}

	@Override
	public boolean addUser(UserBean bean) {
		
		return dao.addUser(bean);
	}

	@Override
	public boolean deleteUser(String email) {
		
		return dao.deleteUser(email);
	}

	@Override
	public List<UserBean> getAllUsers() {
		
		return dao.getAllUsers();
	}

}
