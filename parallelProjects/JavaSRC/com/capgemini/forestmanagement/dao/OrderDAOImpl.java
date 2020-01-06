package com.capgemini.forestmanagement.dao;

import java.util.HashMap;
import java.util.Map.Entry;
import com.capgemini.forestmanagement.dto.OrderBean;
import com.capgemini.forestmangement.exceptions.OrderIdNotFoundException;

public class OrderDAOImpl implements OrderDAO {

	HashMap<Integer, OrderBean> orderBean = new HashMap<Integer, OrderBean>();
	OrderBean bean = new OrderBean();

	@Override
	public boolean addOrder(int orderNo, OrderBean bean) {
		for (Entry<Integer, OrderBean> entry : orderBean.entrySet()) {
			if (entry.getKey() == bean.getOrderNo()) {
				return false;
			}
		}
		orderBean.put(orderNo, bean);
		return true;
	}

	@Override
	public HashMap<Integer, OrderBean> getAllOrders() {

		return orderBean;
	}

	@Override
	public Entry<Integer, OrderBean> getOrder(int orderNo) {
		if (orderNo < 0) {
			throw new OrderIdNotFoundException();
		} else {
			for (Entry<Integer, OrderBean> entry : orderBean.entrySet()) {
				if (entry.getKey() == orderNo) {
					return entry;
				}
			}
		}
		return null;
	}

	@Override
	public boolean updateOrder(int orderNo, OrderBean bean) {

		if (!orderBean.isEmpty()) {

			orderBean.replace(orderNo, bean);

			return true;

		} else {
			return false;
		}
	}

	@Override
	public boolean deleteOrder(int orderNo) {
		if (orderNo < 0) {
			throw new OrderIdNotFoundException();
		} else {
			for (Entry<Integer, OrderBean> entry : orderBean.entrySet()) {
				if (entry.getKey() == orderNo)
					orderBean.remove(orderNo);
				return true;
			}
		}
		return false;
	}

}
