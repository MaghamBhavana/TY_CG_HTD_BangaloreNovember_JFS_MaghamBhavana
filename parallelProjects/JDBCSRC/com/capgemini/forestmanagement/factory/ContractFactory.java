package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.ContractDAO;
import com.capgemini.forestmanagement.dao.ContractDAOImpl;
import com.capgemini.forestmanagement.service.ContractService;
import com.capgemini.forestmanagement.service.ContractServiceImpl;

public class ContractFactory {
	public static ContractDAO instanceOfContractDAOImpl() {
		return new ContractDAOImpl();
	}
	public static ContractService instanceOfContractServiceimpl() {
		return new ContractServiceImpl();
	}
}
