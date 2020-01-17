package com.capgemini.forestmanagentsystem.dao;

import java.util.List;

import com.capgemini.forestmanagentsystem.dto.OrderBean;


public interface OrderDAO {
	public boolean addOrder(OrderBean bean);
	public  OrderBean getOrder(int orderNo);
	public List<OrderBean> getAllOrders();
	public boolean updateOrder(OrderBean bean);
	public boolean deleteOrder(int orderNo);

}
