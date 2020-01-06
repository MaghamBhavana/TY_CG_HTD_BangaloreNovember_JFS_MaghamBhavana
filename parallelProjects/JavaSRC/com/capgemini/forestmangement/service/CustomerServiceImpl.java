package com.capgemini.forestmangement.service;

import java.util.HashMap;
import java.util.Map.Entry;

import com.capgemini.forestmanagement.dao.CustomerDAO;
import com.capgemini.forestmanagement.dto.CustomerBean;
import com.capgemini.forestmanagement.factory.CustomerFactory;

public class CustomerServiceImpl implements CustomerService {

	CustomerDAO dao = CustomerFactory.instanceOfCustomerDAOImpl();

	@Override
	public boolean addCustomer(int customerId, CustomerBean bean) {

		return dao.addCustomer(customerId, bean);
	}

	@Override
	public HashMap<Integer, CustomerBean> getAllCustomers() {

		return dao.getAllCustomers();
	}

	@Override
	public Entry<Integer, CustomerBean> getCustomer(int customerId) {

		return dao.getCustomer(customerId);
	}

	@Override
	public boolean updateCustomer(int customerId, CustomerBean bean) {

		return dao.updateCustomer(customerId, bean);
	}

	@Override
	public boolean deleteCustomer(int customerId) {

		return dao.deleteCustomer(customerId);
	}

}
