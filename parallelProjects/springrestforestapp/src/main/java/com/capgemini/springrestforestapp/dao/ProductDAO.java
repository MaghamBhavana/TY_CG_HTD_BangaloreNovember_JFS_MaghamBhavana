package com.capgemini.springrestforestapp.dao;

import java.util.List;

import com.capgemini.springrestforestapp.dto.ProductBean;



public interface ProductDAO {
	
	public boolean addProduct(ProductBean bean);
	public  ProductBean getProduct(int productId);
	public List<ProductBean> getAllProducts();
	public boolean updateProduct(ProductBean bean);
	public boolean deleteProduct(int productId);

}
