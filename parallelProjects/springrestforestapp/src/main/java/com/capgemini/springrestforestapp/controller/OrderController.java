package com.capgemini.springrestforestapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springrestforestapp.dto.OrderBean;
import com.capgemini.springrestforestapp.dto.OrderResponse;
import com.capgemini.springrestforestapp.service.OrderService;


@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class OrderController {

	@Autowired
	OrderService service;
	
	@PostMapping(path = "/add-order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OrderResponse addOrder(@RequestBody OrderBean order) {
		OrderResponse orderResponse = new OrderResponse();
		if (service.addOrder(order)) {
			orderResponse.setStatus(201);
			orderResponse.setMessage("Success");
			orderResponse.setDescription("Successfully...Order is added");
		} else {
			orderResponse.setStatus(401);
			orderResponse.setMessage("Failure");
			orderResponse.setDescription("Order already exists");
		}
		return orderResponse;
	}
	
	@GetMapping(path = "/get-allorders", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderResponse viewAllOrders() {
		OrderResponse orderResponse = new OrderResponse();
		List<OrderBean> list = service.getAllOrders();
		if (list.size() != 0) {
			orderResponse.setStatus(201);
			orderResponse.setMessage("Success");
			orderResponse.setDescription("Successfully found your orders");
			orderResponse.setOrder(list);
		} else {
			orderResponse.setStatus(401);
			orderResponse.setMessage("Failure");
			orderResponse.setDescription("No data found");
		}
		return orderResponse;
		
	}
	@GetMapping(path = "/get-order/{orderNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderResponse viewProduct(@PathVariable("orderNo") int orderNo) {
		OrderResponse orderResponse = new OrderResponse();
		OrderBean order = service.getOrder(orderNo);
		if (order != null) {
			orderResponse.setStatus(201);
			orderResponse.setMessage("Success");
			orderResponse.setDescription("Order is found");
			orderResponse.setOrder(Arrays.asList(order));
		} else {
			orderResponse.setStatus(401);
			orderResponse.setMessage("Failure");
			orderResponse.setDescription("This Order doesn't exsist");
		}
		return orderResponse;
	}
	@DeleteMapping(path = "/delete-order/{orderNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderResponse deleteOrder(@PathVariable("orderNo") int orderNo) {
		OrderResponse orderResponse = new OrderResponse();
		if (service.deleteOrder(orderNo)) {
			orderResponse.setStatus(201);
			orderResponse.setMessage("Success");
			orderResponse.setDescription("Product deleted");
		} else {
			orderResponse.setStatus(401);
			orderResponse.setMessage("Failure");
			orderResponse.setDescription("Product is not found with this Id");
		}
		return orderResponse;
	}
	
	@PutMapping(path = "/update-order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OrderResponse updateOrder(@RequestBody OrderBean order) {
		OrderResponse response = new OrderResponse();
		if (service.updateOrder(order)) {
			response.setStatus(201);
			response.setMessage("Success");
			response.setDescription("Order details updated");
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("Order not found");
		}
		return response;
	}
}
