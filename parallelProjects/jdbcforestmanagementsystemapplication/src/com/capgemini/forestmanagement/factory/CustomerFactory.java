package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.CustomerDAO;
import com.capgemini.forestmanagement.dao.CustomerDAOImpl;
import com.capgemini.forestmanagement.service.CustomerService;
import com.capgemini.forestmanagement.service.CustomerServiceImpl;

public class CustomerFactory {
	public static CustomerDAO instanceOfCustomerDAOImpl() {
		return new CustomerDAOImpl();
	}

	public static CustomerService instanceOfCustomerServiceImpl() {
		return new CustomerServiceImpl();
	}

}
