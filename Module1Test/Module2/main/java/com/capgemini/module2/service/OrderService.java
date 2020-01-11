package com.capgemini.module2.service;

import java.util.List;

import com.capgemini.module2.dto.OrderInfoBean;

public interface OrderService {
	
	boolean addOrder(OrderInfoBean orderBean);
	
	List<OrderInfoBean> getAllOrders();
	
	OrderInfoBean searchOrder(int id);

}
