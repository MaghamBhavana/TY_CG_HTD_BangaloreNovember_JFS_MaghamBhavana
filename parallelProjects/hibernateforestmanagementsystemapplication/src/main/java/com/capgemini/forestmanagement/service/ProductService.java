package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.dto.ProductBean;

public interface ProductService {
	public boolean addProduct(ProductBean bean);
	public  ProductBean getProduct(int productId);
	public List<ProductBean> getAllProducts();
	public boolean updateProduct(int productId, ProductBean bean);
	public boolean deleteProduct(int productId);
}
