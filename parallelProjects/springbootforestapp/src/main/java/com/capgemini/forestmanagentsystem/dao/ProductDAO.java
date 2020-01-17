package com.capgemini.forestmanagentsystem.dao;

import java.util.List;

import com.capgemini.forestmanagentsystem.dto.ProductBean;



public interface ProductDAO {
	
	public boolean addProduct(ProductBean bean);
	public  ProductBean getProduct(int productId);
	public List<ProductBean> getAllProducts();
	public boolean updateProduct(ProductBean bean);
	public boolean deleteProduct(int productId);

}
