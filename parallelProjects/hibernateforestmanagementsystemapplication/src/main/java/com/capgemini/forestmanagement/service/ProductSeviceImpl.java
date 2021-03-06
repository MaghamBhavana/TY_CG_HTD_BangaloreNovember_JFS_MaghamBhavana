package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.dao.ProductDAO;
import com.capgemini.forestmanagement.dto.ProductBean;
import com.capgemini.forestmanagement.factory.ProductFactory;

public class ProductSeviceImpl implements ProductService {

	ProductDAO dao = ProductFactory.instanceOfProductDAOImpl();
	
	public boolean addProduct(ProductBean bean) {
		
		return dao.addProduct(bean);
	}

	
	public ProductBean getProduct(int productId) {
		
		return dao.getProduct(productId);
	}

	
	public List<ProductBean> getAllProducts() {
		
		return dao.getAllProducts();
	}

	
	public boolean updateProduct(int productId, ProductBean bean) {
		
		return dao.updateProduct(productId, bean);
	}

	
	public boolean deleteProduct(int productId) {
		
		return dao.deleteProduct(productId);
	}

}
