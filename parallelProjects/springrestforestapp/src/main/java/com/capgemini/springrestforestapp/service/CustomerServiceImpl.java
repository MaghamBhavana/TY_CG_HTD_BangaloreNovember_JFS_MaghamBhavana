package com.capgemini.springrestforestapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springrestforestapp.dao.CustomerDAO;
import com.capgemini.springrestforestapp.dto.CustomerBean;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDAO dao;
	
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
	public boolean updateCustomer(CustomerBean bean) {
		
		return dao.updateCustomer(bean);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
	
		return dao.deleteCustomer(customerId);
	}

}
