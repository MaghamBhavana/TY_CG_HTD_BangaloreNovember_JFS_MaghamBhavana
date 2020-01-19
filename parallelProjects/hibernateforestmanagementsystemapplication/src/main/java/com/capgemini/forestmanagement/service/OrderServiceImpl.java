package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.dao.OrderDAO;
import com.capgemini.forestmanagement.dto.CustomerBean;
import com.capgemini.forestmanagement.dto.HaulierBean;
import com.capgemini.forestmanagement.dto.OrderBean;
import com.capgemini.forestmanagement.dto.ProductBean;
import com.capgemini.forestmanagement.factory.OrderFactory;

public class OrderServiceImpl implements OrderService {

	OrderDAO dao = OrderFactory.instanceofOrderDAOImpl();
	
	public boolean addOrder(OrderBean bean) {
		
		return dao.addOrder(bean);
	}

	
	public OrderBean getOrder(int orderNo) {
		
		return dao.getOrder(orderNo);
	}

	
	public List<OrderBean> getAllOrders() {
		
		return dao.getAllOrders();
	}

	
	public boolean updateOrder(int orderNo, OrderBean bean) {
		
		return dao.updateOrder(orderNo, bean);
	}

	
	public boolean deleteOrder(int orderNo) {
		
		return dao.deleteOrder(orderNo);
	}


	@Override
	public CustomerBean getCustomer(int customerId) {
		
		return dao.getCustomer(customerId);
	}


	@Override
	public ProductBean getProduct(int productId) {
		
		return dao.getProduct(productId);
	}


	@Override
	public HaulierBean getHaulier(int haulierId) {
		
		return dao.getHaulier(haulierId);
	}

}
