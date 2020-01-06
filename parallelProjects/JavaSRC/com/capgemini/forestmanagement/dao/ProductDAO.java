package com.capgemini.forestmanagement.dao;

import java.util.HashMap;
import java.util.Map.Entry;
import com.capgemini.forestmanagement.dto.ProductBean;

public interface ProductDAO {

	boolean addProduct(int productId, ProductBean bean);

	HashMap<Integer, ProductBean> getAllProducts();

	Entry<Integer, ProductBean> getProduct(int productId);

	boolean updateProduct(int productId, ProductBean bean);

	boolean deleteProduct(int productId);
}
