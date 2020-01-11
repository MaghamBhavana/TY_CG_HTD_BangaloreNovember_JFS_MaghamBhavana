package com.capgemini.module2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.module2.dao.ProductDAO;
import com.capgemini.module2.dto.ProductInfoBean;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO dao;
	
	@Override
	public boolean addProduct(ProductInfoBean productBean) {
		
		return dao.addProduct(productBean);
	}

	@Override
	public List<ProductInfoBean> getAllProducts() {
		
		return dao.getAllProducts();
	}

	@Override
	public ProductInfoBean searchProduct(int id) {
		
		return dao.searchProduct(id);
	}

}
