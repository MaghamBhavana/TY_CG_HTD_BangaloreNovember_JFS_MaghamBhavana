package com.capgemini.forestmanagentsystem.service;

import java.util.List;

import com.capgemini.forestmanagentsystem.dto.OrderBean;

public interface OrderService {
	public boolean addOrder(OrderBean bean);
	public  OrderBean getOrder(int orderNo);
	public List<OrderBean> getAllOrders();
	public boolean updateOrder(OrderBean bean);
	public boolean deleteOrder(int orderNo);
}
