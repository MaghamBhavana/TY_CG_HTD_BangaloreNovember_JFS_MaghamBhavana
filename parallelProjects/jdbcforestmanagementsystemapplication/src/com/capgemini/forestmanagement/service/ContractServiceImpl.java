package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.dao.ContractDAO;
import com.capgemini.forestmanagement.dto.ContractBean;
import com.capgemini.forestmanagement.factory.ContractFactory;

public class ContractServiceImpl implements ContractService {

	ContractDAO dao = ContractFactory.instanceOfContractDAOImpl();

	@Override
	public boolean addContract(ContractBean bean) {

		return dao.addContract(bean);
	}

	@Override
	public ContractBean getContract(int contractNo) {

		return dao.getContract(contractNo);
	}

	@Override
	public List<ContractBean> getAllContracts() {

		return dao.getAllContracts();
	}

	@Override
	public boolean updateContract(int contractNo, ContractBean bean) {

		return dao.updateContract(contractNo, bean);
	}

	@Override
	public boolean deleteContract(int contractNo) {

		return dao.deleteContract(contractNo);
	}

}
