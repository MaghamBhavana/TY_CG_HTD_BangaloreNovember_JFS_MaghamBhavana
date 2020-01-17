package com.capgemini.forestmanagentsystem.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

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

import com.capgemini.forestmanagentsystem.dto.ProductBean;
import com.capgemini.forestmanagentsystem.dto.ProductResponse;
import com.capgemini.forestmanagentsystem.service.ProductService;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping(path = "/add-product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse addProduct(@Valid @RequestBody ProductBean product) {
		ProductResponse productResponse = new ProductResponse();
		if (service.addProduct(product)) {
			productResponse.setStatus(201);
			productResponse.setMessage("Success");
			productResponse.setDescription("Successfully...Product is added");
		} else {
			productResponse.setStatus(401);
			productResponse.setMessage("Failure");
			productResponse.setDescription("Product already exists");
		}
		return productResponse;
	}
	@GetMapping(path = "/get-allproducts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse viewAllProducts() {
		ProductResponse productResponse = new ProductResponse();
		List<ProductBean> list = service.getAllProducts();
		if (list.size() != 0) {
			productResponse.setStatus(201);
			productResponse.setMessage("Success");
			productResponse.setDescription("Successfully found your products");
			productResponse.setProduct(list);
		} else {
			productResponse.setStatus(401);
			productResponse.setMessage("Failure");
			productResponse.setDescription("No data found");
		}
		return productResponse;
		
	}

	@GetMapping(path = "/get-product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse viewProduct(@PathVariable("productId") int productId) {
		ProductResponse productResponse = new ProductResponse();
		ProductBean product = service.getProduct(productId);
		if (product != null) {
			productResponse.setStatus(201);
			productResponse.setMessage("Success");
			productResponse.setDescription("Product is found");
			productResponse.setProduct(Arrays.asList(product));
		} else {
			productResponse.setStatus(401);
			productResponse.setMessage("Failure");
			productResponse.setDescription("This Product doesn't exsist");
		}
		return productResponse;
	}

	@PutMapping(path = "/update-product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse updateProduct(@RequestBody ProductBean product) {
		ProductResponse productResponse = new ProductResponse();
		if (service.updateProduct(product)) {
			productResponse.setStatus(201);
			productResponse.setMessage("Success");
			productResponse.setDescription("Product was modified successfully");
		} else {
			productResponse.setStatus(401);
			productResponse.setMessage("Failure");
			productResponse.setDescription("Product is not found with this Id");
		}
		return productResponse;
	}

	@DeleteMapping(path = "/delete-product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse deleteProduct(@PathVariable("productId") int productId) {
		ProductResponse productResponse = new ProductResponse();
		if (service.deleteProduct(productId)) {
			productResponse.setStatus(201);
			productResponse.setMessage("Success");
			productResponse.setDescription("Product deleted");
		} else {
			productResponse.setStatus(401);
			productResponse.setMessage("Failure");
			productResponse.setDescription("Product is not found with this Id");
		}
		return productResponse;
	}


}
