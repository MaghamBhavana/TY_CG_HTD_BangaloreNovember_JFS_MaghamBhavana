package com.capgemini.forestmanagement.service;

import java.util.List;
import com.capgemini.forestmanagement.dto.ContractBean;
import com.capgemini.forestmanagement.dto.CustomerBean;
import com.capgemini.forestmanagement.dto.HaulierBean;
import com.capgemini.forestmanagement.dto.ProductBean;

public interface ContractService {
	public boolean addContract(ContractBean bean);

	public ContractBean getContract(int contractNo);

	public List<ContractBean> getAllContracts();

	public boolean updateContract(int contractNo, ContractBean bean);

	public boolean deleteContract(int contractNo);

	public CustomerBean getCustomer(int customerId);

	public ProductBean getProduct(int productId);

	public HaulierBean getHaulier(int haulierId);
}
