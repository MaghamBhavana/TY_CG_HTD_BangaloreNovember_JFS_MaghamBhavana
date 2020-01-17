package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.dao.OrderDAO;
import com.capgemini.forestmanagement.dto.OrderBean;
import com.capgemini.forestmanagement.factory.OrderFactory;

public class OrderServiceImpl implements OrderService {

	OrderDAO dao = OrderFactory.instanceofOrderDAOImpl();

	@Override
	public boolean addOrder(OrderBean bean) {

		return dao.addOrder(bean);
	}

	@Override
	public OrderBean getOrder(int orderNo) {

		return dao.getOrder(orderNo);
	}

	@Override
	public List<OrderBean> getAllOrders() {

		return dao.getAllOrders();
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
