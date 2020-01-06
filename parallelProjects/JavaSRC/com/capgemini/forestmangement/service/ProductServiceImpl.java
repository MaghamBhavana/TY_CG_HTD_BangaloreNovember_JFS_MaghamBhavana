package com.capgemini.forestmangement.service;

import java.util.HashMap;
import java.util.Map.Entry;

import com.capgemini.forestmanagement.dao.ProductDAO;
import com.capgemini.forestmanagement.dto.ProductBean;
import com.capgemini.forestmanagement.factory.ProductFactory;

public class ProductServiceImpl implements ProductService {

	ProductDAO dao = ProductFactory.instanceOfProductDAOImpl();

	@Override
	public boolean addProduct(int productId, ProductBean bean) {

		return dao.addProduct(productId, bean);
	}

	@Override
	public HashMap<Integer, ProductBean> getAllProducts() {
		return dao.getAllProducts();
	}

	@Override
	public Entry<Integer, ProductBean> getProduct(int productId) {

		return dao.getProduct(productId);
	}

	@Override
	public boolean updateProduct(int productId, ProductBean bean) {

		return dao.updateProduct(productId, bean);
	}

	@Override
	public boolean deleteProduct(int productId) {

		return dao.deleteProduct(productId);
	}

}
