package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.HaulierDAO;
import com.capgemini.forestmanagement.dao.HaulierDAOImpl;
import com.capgemini.forestmangement.service.HaulierService;
import com.capgemini.forestmangement.service.HaulierServiceImpl;

public class HaulierFactory {

	public static HaulierDAO instanceOfHaulierDAOImpl() {
		return new HaulierDAOImpl();
	}

	public static HaulierService instanceOfHaulierServiceImpl() {
		return new HaulierServiceImpl();
	}
}
