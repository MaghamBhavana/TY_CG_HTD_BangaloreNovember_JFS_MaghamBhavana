package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.dto.CustomerBean;

public interface CustomerService {
	public boolean addCustomer(CustomerBean bean);
	public  CustomerBean getCustomer(int customerId);
	public List<CustomerBean> getAllCustomers();
	public boolean updateCustomer(int customerId, CustomerBean bean);
	public boolean deleteCustomer(int customerId);
	
}
