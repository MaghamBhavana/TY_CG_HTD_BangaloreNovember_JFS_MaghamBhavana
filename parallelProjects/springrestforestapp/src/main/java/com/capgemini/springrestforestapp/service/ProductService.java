package com.capgemini.springrestforestapp.service;

import java.util.List;

import com.capgemini.springrestforestapp.dto.ProductBean;

public interface ProductService {
	public boolean addProduct(ProductBean bean);
	public  ProductBean getProduct(int productId);
	public List<ProductBean> getAllProducts();
	public boolean updateProduct(ProductBean bean);
	public boolean deleteProduct(int productId);
}
