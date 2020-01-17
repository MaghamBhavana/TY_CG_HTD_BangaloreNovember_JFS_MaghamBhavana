package com.capgemini.forestmanagentsystem.service;

import java.util.List;

import com.capgemini.forestmanagentsystem.dto.ProductBean;

public interface ProductService {
	public boolean addProduct(ProductBean bean);
	public  ProductBean getProduct(int productId);
	public List<ProductBean> getAllProducts();
	public boolean updateProduct(ProductBean bean);
	public boolean deleteProduct(int productId);
}
