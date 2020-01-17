package com.capgemini.forestmanagentsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagentsystem.dao.ContractDAO;
import com.capgemini.forestmanagentsystem.dto.ContractBean;

@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	ContractDAO dao;
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
	public boolean updateContract(ContractBean bean) {
		
		return dao.updateContract(bean);
	}

	@Override
	public boolean deleteContract(int contractNo) {
		
		return dao.deleteContract(contractNo);
	}

}
