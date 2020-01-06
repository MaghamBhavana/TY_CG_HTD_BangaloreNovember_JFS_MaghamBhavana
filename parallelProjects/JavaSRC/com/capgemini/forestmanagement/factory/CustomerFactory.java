package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.CustomerDAO;
import com.capgemini.forestmanagement.dao.CustomerDAOImpl;
import com.capgemini.forestmangement.service.CustomerService;
import com.capgemini.forestmangement.service.CustomerServiceImpl;

public class CustomerFactory {

	public static CustomerDAO instanceOfCustomerDAOImpl() {
		return new CustomerDAOImpl();
	}

	public static CustomerService instanceOfCustomerServiceImpl() {
		return new CustomerServiceImpl();
	}

}
