package com.capgemini.forestmanagement.dao;

import java.util.List;

import com.capgemini.forestmanagement.dto.OrderBean;

public interface OrderDAO {
	public boolean addOrder(OrderBean bean);

	public OrderBean getOrder(int orderNo);

	public List<OrderBean> getAllOrders();

	public boolean updateOrder(int orderNo, OrderBean bean);

	public boolean deleteOrder(int orderNo);

}
