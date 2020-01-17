package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.HaulierDAO;
import com.capgemini.forestmanagement.dao.HaulierDAOImpl;
import com.capgemini.forestmanagement.service.HaulierService;
import com.capgemini.forestmanagement.service.HaulierServiceImpl;

public class HaulierFactory {
	public static HaulierDAO instanceOfHaulierDAOImpl() {
		return new HaulierDAOImpl();
	}

	public static HaulierService instanceOfHaulierServiceImpl() {
		return new HaulierServiceImpl();
	}

}
