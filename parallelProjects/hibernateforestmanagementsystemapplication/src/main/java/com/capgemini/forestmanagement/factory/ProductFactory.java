package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.ProductDAO;
import com.capgemini.forestmanagement.dao.ProductDAOImpl;
import com.capgemini.forestmanagement.service.ProductService;
import com.capgemini.forestmanagement.service.ProductSeviceImpl;

public class ProductFactory {
	public static ProductDAO instanceOfProductDAOImpl() {
		return new ProductDAOImpl();
	}
	public static ProductService instanceOfProductServiceImpl() {
		return new ProductSeviceImpl();
	}

}
