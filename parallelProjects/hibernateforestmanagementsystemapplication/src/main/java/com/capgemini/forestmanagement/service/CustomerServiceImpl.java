package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.dao.CustomerDAO;
import com.capgemini.forestmanagement.dto.CustomerBean;
import com.capgemini.forestmanagement.factory.CustomerFactory;

public class CustomerServiceImpl implements CustomerService {
	
	CustomerDAO dao = CustomerFactory.instanceOfCustomerDAOImpl();
	
	public boolean addCustomer(CustomerBean bean) {
		
		return dao.addCustomer(bean);
	}

	
	public CustomerBean getCustomer(int customerId) {
		
		return dao.getCustomer(customerId);
	}

	
	public List<CustomerBean> getAllCustomers() {
		
		return dao.getAllCustomers();
	}

	
	public boolean updateCustomer(int customerId, CustomerBean bean) {
		
		return dao.updateCustomer(customerId, bean);
	}


	public boolean deleteCustomer(int customerId) {
	
		return dao.deleteCustomer(customerId);
	}

}
