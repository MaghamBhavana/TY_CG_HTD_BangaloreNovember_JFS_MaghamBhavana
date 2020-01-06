package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.ProductDAO;
import com.capgemini.forestmanagement.dao.ProductDAOImpl;
import com.capgemini.forestmangement.service.ProductService;
import com.capgemini.forestmangement.service.ProductServiceImpl;

public class ProductFactory {

	public static ProductDAO instanceOfProductDAOImpl() {
		return new ProductDAOImpl();
	}

	public static ProductService instanceOfProductServiceImpl() {
		return new ProductServiceImpl();
	}

}
