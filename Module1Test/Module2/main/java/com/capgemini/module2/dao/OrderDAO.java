package com.capgemini.module2.dao;

import java.util.List;

import com.capgemini.module2.dto.OrderInfoBean;

public interface OrderDAO {

	boolean addOrder(OrderInfoBean orderBean);
	
	List<OrderInfoBean> getAllOrders();
	
	OrderInfoBean searchOrder(int id);
	
	
}
