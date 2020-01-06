package com.capgemini.forestmangement.service;

import java.util.HashMap;
import java.util.Map.Entry;
import com.capgemini.forestmanagement.dto.CustomerBean;

public interface CustomerService {
	boolean addCustomer(int customerId, CustomerBean bean);

	HashMap<Integer, CustomerBean> getAllCustomers();

	Entry<Integer, CustomerBean> getCustomer(int customerId);

	boolean updateCustomer(int customerId, CustomerBean bean);

	boolean deleteCustomer(int customerId);
}
