package com.capgemini.module2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.module2.dao.OrderDAO;
import com.capgemini.module2.dto.OrderInfoBean;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO dao;
	
	@Override
	public boolean addOrder(OrderInfoBean orderBean) {
		
		return dao.addOrder(orderBean);
	}

	@Override
	public List<OrderInfoBean> getAllOrders() {
		
		return dao.getAllOrders();
	}

	@Override
	public OrderInfoBean searchOrder(int id) {
		
		return dao.searchOrder(id);
	}

}
