package com.capgemini.module2.dao;

import java.util.List;

import com.capgemini.module2.dto.ProductInfoBean;

public interface ProductDAO {

	boolean addProduct(ProductInfoBean productBean);

	List<ProductInfoBean> getAllProducts();

	ProductInfoBean searchProduct(int id);
}
