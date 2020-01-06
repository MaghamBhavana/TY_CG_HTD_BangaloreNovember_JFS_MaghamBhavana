package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.OrderDAO;
import com.capgemini.forestmanagement.dao.OrderDAOImpl;
import com.capgemini.forestmanagement.service.OrderService;
import com.capgemini.forestmanagement.service.OrderServiceImpl;

public class OrderFactory {
	public static OrderDAO instanceofOrderDAOImpl() {
		return new OrderDAOImpl();
	}
	public static OrderService instanceOfOrderServiceImpl() {
		return new OrderServiceImpl();
	}
}
