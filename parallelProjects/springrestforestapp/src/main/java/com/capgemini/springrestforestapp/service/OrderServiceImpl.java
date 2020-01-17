package com.capgemini.springrestforestapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springrestforestapp.dao.OrderDAO;
import com.capgemini.springrestforestapp.dto.OrderBean;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO dao;
	@Override
	public boolean addOrder(OrderBean bean) {
		
		return dao.addOrder(bean);
	}

	@Override
	public OrderBean getOrder(int orderNo) {
		
		return dao.getOrder(orderNo);
	}

	@Override
	public List<OrderBean> getAllOrders() {
		
		return dao.getAllOrders();
	}

	@Override
	public boolean updateOrder(OrderBean bean) {
		
		return dao.updateOrder(bean);
	}

	@Override
	public boolean deleteOrder(int orderNo) {
		
		return dao.deleteOrder(orderNo);
	}

}
