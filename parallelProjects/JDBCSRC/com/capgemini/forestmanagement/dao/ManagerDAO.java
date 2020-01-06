package com.capgemini.forestmanagement.dao;

import com.capgemini.forestmanagement.dto.ManagerBean;

public interface ManagerDAO {

	public boolean add(String username, String password);

	public ManagerBean login(String username, String password);

}
