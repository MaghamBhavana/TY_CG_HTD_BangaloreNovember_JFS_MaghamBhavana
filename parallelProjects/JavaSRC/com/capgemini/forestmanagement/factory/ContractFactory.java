package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.ContractDAO;
import com.capgemini.forestmanagement.dao.ContractDAOImpl;
import com.capgemini.forestmangement.service.ContractService;
import com.capgemini.forestmangement.service.ContractServiceImpl;

public class ContractFactory {

	public static ContractDAO instanceOfContractorDAOImpl() {
		return new ContractDAOImpl();
	}

	public static ContractService instanceOfContractServiceImpl() {
		return new ContractServiceImpl();
	}

}
