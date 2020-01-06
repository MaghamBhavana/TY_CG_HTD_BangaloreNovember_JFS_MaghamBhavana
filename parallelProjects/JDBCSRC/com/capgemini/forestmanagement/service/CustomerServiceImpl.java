package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.dao.CustomerDAO;
import com.capgemini.forestmanagement.dto.CustomerBean;
import com.capgemini.forestmanagement.factory.CustomerFactory;

public class CustomerServiceImpl implements CustomerService {
	
	CustomerDAO dao = CustomerFactory.instanceOfCustomerDAOImpl();
	@Override
	public boolean addCustomer(CustomerBean bean) {
		
		return dao.addCustomer(bean);
	}

	@Override
	public CustomerBean getCustomer(int customerId) {
		
		return dao.getCustomer(customerId);
	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		
		return dao.getAllCustomers();
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
