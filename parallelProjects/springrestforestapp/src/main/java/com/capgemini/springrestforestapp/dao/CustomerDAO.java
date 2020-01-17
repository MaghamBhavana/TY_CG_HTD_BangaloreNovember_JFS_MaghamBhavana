package com.capgemini.springrestforestapp.dao;

import java.util.List;

import com.capgemini.springrestforestapp.dto.CustomerBean;

public interface CustomerDAO {
	public boolean addCustomer(CustomerBean bean);

	public CustomerBean getCustomer(int customerId);

	public List<CustomerBean> getAllCustomers();

	public boolean updateCustomer(CustomerBean bean);

	public boolean deleteCustomer(int customerId);

}
