package com.capgemini.forestmanagement.service;

import com.capgemini.forestmanagement.dao.ManagerDAO;
import com.capgemini.forestmanagement.dao.ManagerDAOImpl;
import com.capgemini.forestmanagement.dto.ManagerBean;

public class ManagerServiceImpl implements ManagerService {

	ManagerDAO dao = new ManagerDAOImpl();

	@Override
	public boolean add(String username, String password) {

		return dao.add(username, password);
	}

	@Override
	public ManagerBean login(String username, String password) {

		return dao.login(username, password);
	}

}
