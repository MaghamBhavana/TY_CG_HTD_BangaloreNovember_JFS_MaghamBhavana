package com.capgemini.forestmanagentsystem.dao;

import java.util.List;

import com.capgemini.forestmanagentsystem.dto.CustomerBean;

public interface CustomerDAO {
	public boolean addCustomer(CustomerBean bean);

	public CustomerBean getCustomer(int customerId);

	public List<CustomerBean> getAllCustomers();

	public boolean updateCustomer(CustomerBean bean);

	public boolean deleteCustomer(int customerId);

}
