
package com.capgemini.forestmanagement.dao;

import java.util.HashMap;
import java.util.Map.Entry;
import com.capgemini.forestmanagement.dto.CustomerBean;
import com.capgemini.forestmangement.exceptions.CustomerIdNotFoundException;

public class CustomerDAOImpl implements CustomerDAO {

	HashMap<Integer, CustomerBean> customerBean = new HashMap<Integer, CustomerBean>();
	CustomerBean bean = new CustomerBean();

	@Override
	public boolean addCustomer(int customerId, CustomerBean bean) {
		for (Entry<Integer, CustomerBean> entry : customerBean.entrySet()) {
			if (entry.getKey() == bean.getCustomerId()) {
				return false;
			}
		}
		customerBean.put(customerId, bean);
		return true;
	}

	@Override
	public HashMap<Integer, CustomerBean> getAllCustomers() {
		if (customerBean != null) {
			return customerBean;
		} else {
			return null;
		}
	}

	@Override
	public Entry<Integer, CustomerBean> getCustomer(int customerId) {
		if (customerId < 0) {
			throw new CustomerIdNotFoundException();
		} else {
			for (Entry<Integer, CustomerBean> entry : customerBean.entrySet()) {
				if (entry.getKey() == customerId) {
					return entry;
				}
			}
			return null;
		}
	}

	@Override
	public boolean updateCustomer(int customerId, CustomerBean bean2) {

		if (!customerBean.isEmpty()) {

			customerBean.replace(customerId, bean2);

			return true;

		} else {
			return false;
		}
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		if (customerId < 0) {
			throw new CustomerIdNotFoundException();
		} else {

			for (Entry<Integer, CustomerBean> entry : customerBean.entrySet()) {
				if (entry.getKey() == customerId) {
					customerBean.remove(customerId);
					return true;
				}
			}
			return false;
		}

	}
}
