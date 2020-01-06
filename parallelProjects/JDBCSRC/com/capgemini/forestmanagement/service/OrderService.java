package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.dto.OrderBean;

public interface OrderService {
	public boolean addOrder(OrderBean bean);
	public  OrderBean getOrder(int orderNo);
	public List<OrderBean> getAllOrders();
	public boolean updateOrder(int orderNo, OrderBean bean);
	public boolean deleteOrder(int orderNo);
}
