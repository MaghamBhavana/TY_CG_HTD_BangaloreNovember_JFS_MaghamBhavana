package com.capgemini.forestmanagement.dao;

import java.util.List;

import com.capgemini.forestmanagement.dto.ProductBean;



public interface ProductDAO {
	
	public boolean addProduct(ProductBean bean);
	public  ProductBean getProduct(int productId);
	public List<ProductBean> getAllProducts();
	public boolean updateProduct(int productId, ProductBean bean);
	public boolean deleteProduct(int productId);

}
