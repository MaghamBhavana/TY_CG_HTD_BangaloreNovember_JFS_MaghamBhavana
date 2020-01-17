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

import com.capgemini.springrestforestapp.dto.CustomerBean;
import com.capgemini.springrestforestapp.dto.CustomerResponse;
import com.capgemini.springrestforestapp.service.CustomerService;


@CrossOrigin(origins = "*",allowedHeaders = "*",allowCredentials = "true")
@RestController
public class CustomerController {


	@Autowired
	CustomerService service;
	
	@PostMapping(path = "/add-customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse addCustomer(@RequestBody CustomerBean customerBean) {
		CustomerResponse response = new CustomerResponse();
		if (service.addCustomer(customerBean)) {
			response.setStatus(201);
			response.setMessage("Success");
			response.setDescription("Customer is added successfully");
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("This customer is already exists");
		}
		return response;
	}
	
	@GetMapping(path = "/get-allcustomers", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse getAllCustomers() {
		CustomerResponse response = new CustomerResponse();
		List<CustomerBean> list = service.getAllCustomers();
		if (list.size() != 0) {
			response.setStatus(201);
			response.setMessage("Success");
			response.setDescription("You got all the customer details");
			response.setCustomer(list);
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("No data is present");
		}
		return response;
		
	}
	
	@GetMapping(path = "/get-customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse getCustomer(@PathVariable("customerId") int customerId) {
		CustomerResponse response = new CustomerResponse();
		CustomerBean customerBean = service.getCustomer(customerId);
		if (customerBean != null) {
			response.setStatus(201);
			response.setMessage("Success");
			response.setDescription("You found the customer details");
			response.setCustomer(Arrays.asList(customerBean));
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("No customer present with this Id");
		}
		return response;
	}
	
	@DeleteMapping(path = "/delete-customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse deleteCustomer(@PathVariable("customerId") int customerId) {
		CustomerResponse response = new CustomerResponse();
		if (service.deleteCustomer(customerId)) {
			response.setStatus(201);
			response.setMessage("Success");
			response.setDescription("Customer is deleted successfully");
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("Customer not found");
		}
		return response;
	}
	@PutMapping(path = "/update-customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse updateCustomer(@RequestBody CustomerBean customer) {
		CustomerResponse response = new CustomerResponse();
		if (service.updateCustomer(customer)) {
			response.setStatus(201);
			response.setMessage("Success");
			response.setDescription("Customer details updated");
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("Customer not found");
		}
		return response;
	}
}
