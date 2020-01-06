package com.capgemini.forestmangement.service;

import java.util.HashMap;
import java.util.Map.Entry;

import com.capgemini.forestmanagement.dao.OrderDAO;
import com.capgemini.forestmanagement.dto.OrderBean;
import com.capgemini.forestmanagement.factory.OrderFactory;

public class OrderServiceImpl implements OrderService {

	OrderDAO dao = OrderFactory.instanceOfOrderDAOImpl();

	@Override
	public boolean addOrder(int orderNo, OrderBean bean) {

		return dao.addOrder(orderNo, bean);
	}

	@Override
	public HashMap<Integer, OrderBean> getAllOrders() {

		return dao.getAllOrders();
	}

	@Override
	public Entry<Integer, OrderBean> getOrder(int orderNo) {

		return dao.getOrder(orderNo);
	}

	@Override
	public boolean updateOrder(int orderNo, OrderBean bean) {

		return dao.updateOrder(orderNo, bean);
	}

	@Override
	public boolean deleteOrder(int orderNo) {

		return dao.deleteOrder(orderNo);
	}

}
