package com.capgemini.forestmangement.service;

import java.util.HashMap;
import java.util.Map.Entry;
import com.capgemini.forestmanagement.dto.OrderBean;

public interface OrderService {

	boolean addOrder(int orderNo, OrderBean bean);

	HashMap<Integer, OrderBean> getAllOrders();

	Entry<Integer, OrderBean> getOrder(int orderNo);

	boolean updateOrder(int orderNo, OrderBean bean);

	boolean deleteOrder(int orderNo);

	

}
