package com.capgemini.forestmangement.service;

import java.util.HashMap;
import java.util.Map.Entry;

import com.capgemini.forestmanagement.dao.ContractDAO;
import com.capgemini.forestmanagement.dto.ContractBean;
import com.capgemini.forestmanagement.factory.ContractFactory;

public class ContractServiceImpl implements ContractService {

	ContractDAO dao = ContractFactory.instanceOfContractorDAOImpl();
	
	@Override
	public boolean addContract(int contractorNo, ContractBean bean) {

		return dao.addContract(contractorNo, bean);
	}

	@Override
	public boolean deleteContract(int contractorNo) {

		return dao.deleteContract(contractorNo);
	}

	@Override
	public HashMap<Integer, ContractBean> getAllContracts() {

		return dao.getAllContracts();
	}

	@Override
	public Entry<Integer, ContractBean> getContract(int contractNo) {

		return dao.getContract(contractNo);
	}

	@Override
	public boolean updateContract(int contractNo, ContractBean bean) {

		return dao.updateContract(contractNo, bean);
	}

}
