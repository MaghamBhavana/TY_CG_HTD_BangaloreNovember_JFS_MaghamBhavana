package com.capgemini.module2.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.module2.dto.OrderInfoBean;
import com.capgemini.module2.dto.OrderInfoBeanResponse;
import com.capgemini.module2.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService service; 
	
	@PostMapping(path = "/add-order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OrderInfoBeanResponse addProduct(@RequestBody OrderInfoBean order) {
		OrderInfoBeanResponse response = new OrderInfoBeanResponse();
		if (service.addOrder(order)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Order added successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Order with same id already exists");
		}
		return response;
	}
	
	@GetMapping(path = "/get-order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderInfoBeanResponse getProduct(@PathVariable("id") int id) {
		OrderInfoBeanResponse response = new OrderInfoBeanResponse();
		OrderInfoBean order = service.searchOrder(id);
		if (order != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Order is found");
			response.setOrder(Arrays.asList(order));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Order id does not exist");
		}
		return response;
	}
	
	@GetMapping(path = "/get-allorders", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderInfoBeanResponse getAllProducts() {
		OrderInfoBeanResponse response = new OrderInfoBeanResponse();
		List<OrderInfoBean> list = service.getAllOrders();
		if (list.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Products found");
			response.setOrder(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data");
		}
		return response;

	}


}
