package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.OrderDAO;
import com.capgemini.forestmanagement.dao.OrderDAOImpl;
import com.capgemini.forestmangement.service.OrderService;
import com.capgemini.forestmangement.service.OrderServiceImpl;

public class OrderFactory {

	public static OrderDAO instanceOfOrderDAOImpl() {
		return new OrderDAOImpl();
	}

	public static OrderService instanceOfOrderServiceImpl() {
		return new OrderServiceImpl();
	}

}
