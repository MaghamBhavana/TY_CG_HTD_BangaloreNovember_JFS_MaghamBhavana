package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.dao.ProductDAO;
import com.capgemini.forestmanagement.dto.ProductBean;
import com.capgemini.forestmanagement.factory.ProductFactory;

public class ProductSeviceImpl implements ProductService {

	ProductDAO dao = ProductFactory.instanceOfProductDAOImpl();
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
	public boolean updateProduct(int productId, String newName) {
		
		return dao.updateProduct(productId, newName);
	}

	@Override
	public boolean deleteProduct(int productId) {
		
		return dao.deleteProduct(productId);
	}

}
