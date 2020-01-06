package com.capgemini.forestmanagement.service;

import com.capgemini.forestmanagement.dto.ManagerBean;

public interface ManagerService {
	public boolean add(String username, String password);

	public ManagerBean login(String username, String password);
}
