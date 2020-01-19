package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.dto.CustomerBean;
import com.capgemini.forestmanagement.dto.HaulierBean;
import com.capgemini.forestmanagement.dto.OrderBean;
import com.capgemini.forestmanagement.dto.ProductBean;

public interface OrderService {
	public boolean addOrder(OrderBean bean);

	public OrderBean getOrder(int orderNo);

	public List<OrderBean> getAllOrders();

	public boolean updateOrder(int orderNo, OrderBean bean);

	public boolean deleteOrder(int orderNo);

	public CustomerBean getCustomer(int customerId);

	public ProductBean getProduct(int productId);

	public HaulierBean getHaulier(int haulierId);
}
