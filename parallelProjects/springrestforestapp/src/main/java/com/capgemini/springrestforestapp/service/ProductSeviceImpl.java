package com.capgemini.springrestforestapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springrestforestapp.dao.ProductDAO;
import com.capgemini.springrestforestapp.dto.ProductBean;

@Service
public class ProductSeviceImpl implements ProductService {

	@Autowired
	ProductDAO dao;
	@Override
	public boolean addProduct(ProductBean bean) {
		
		return dao.addProduct(bean);
	}

	@Override
	public ProductBean getProduct(int productId) {
		
		return dao.getProduct(productId);
	}

	@Override
	public List<ProductBean> getAllProducts() {
		
		return dao.getAllProducts();
	}

	@Override
	public boolean updateProduct(ProductBean bean) {
		
		return dao.updateProduct(bean);
	}

	@Override
	public boolean deleteProduct(int productId) {
		
		return dao.deleteProduct(productId);
	}

}
