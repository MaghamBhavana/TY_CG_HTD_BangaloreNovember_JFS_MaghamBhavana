package com.capgemini.module2.service;

import java.util.List;

import com.capgemini.module2.dto.ProductInfoBean;

public interface ProductService {
	
	boolean addProduct(ProductInfoBean productBean);

	List<ProductInfoBean> getAllProducts();

	ProductInfoBean searchProduct(int id);

}
