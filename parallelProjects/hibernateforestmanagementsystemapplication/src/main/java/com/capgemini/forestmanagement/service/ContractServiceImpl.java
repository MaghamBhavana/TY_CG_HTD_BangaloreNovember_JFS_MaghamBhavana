package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.dao.ContractDAO;
import com.capgemini.forestmanagement.dto.ContractBean;
import com.capgemini.forestmanagement.dto.CustomerBean;
import com.capgemini.forestmanagement.dto.HaulierBean;
import com.capgemini.forestmanagement.dto.ProductBean;
import com.capgemini.forestmanagement.factory.ContractFactory;

public class ContractServiceImpl implements ContractService {

	ContractDAO dao = ContractFactory.instanceOfContractDAOImpl();
	
	public boolean addContract(ContractBean bean) {
		
		return dao.addContract(bean);
	}

	
	public ContractBean getContract(int contractNo) {
		
		return dao.getContract(contractNo);
	}

	
	public List<ContractBean> getAllContracts() {
		
		return dao.getAllContracts();
	}

	
	public boolean updateContract(int contractNo, ContractBean bean) {
		
		return dao.updateContract(contractNo, bean);
	}

	
	public boolean deleteContract(int contractNo) {
		
		return dao.deleteContract(contractNo);
	}


	@Override
	public CustomerBean getCustomer(int customerId) {
		
		return dao.getCustomer(customerId);
	}


	@Override
	public ProductBean getProduct(int productId) {
		
		return dao.getProduct(productId);
	}


	@Override
	public HaulierBean getHaulier(int haulierId) {
		
		return dao.getHaulier(haulierId);
	}

}
