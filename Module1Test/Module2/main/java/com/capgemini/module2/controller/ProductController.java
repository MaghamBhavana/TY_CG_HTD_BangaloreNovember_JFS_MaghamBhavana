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

import com.capgemini.module2.dto.ProductInfoBean;
import com.capgemini.module2.dto.ProductInfoBeanResponse;
import com.capgemini.module2.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping(path = "/add-product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductInfoBeanResponse addProduct(@RequestBody ProductInfoBean product) {
		ProductInfoBeanResponse response = new ProductInfoBeanResponse();
		if (service.addProduct(product)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product added successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product is already exsists with the same name");
		}
		return response;
	}

	@GetMapping(path = "/get-product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductInfoBeanResponse searchProduct(@PathVariable("id") int id) {
		ProductInfoBeanResponse response = new ProductInfoBeanResponse();
		ProductInfoBean product = service.searchProduct(id);
		if (product != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product is found");
			response.setProduct(Arrays.asList(product));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product doesn't exsist with this Id");
		}
		return response;
	}

	@GetMapping(path = "/get-allproducts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductInfoBeanResponse getAllProducts() {
		ProductInfoBeanResponse response = new ProductInfoBeanResponse();
		List<ProductInfoBean> list = service.getAllProducts();
		if (!list.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Products are found");
			response.setProduct(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data found");
		}
		return response;

	}
}
