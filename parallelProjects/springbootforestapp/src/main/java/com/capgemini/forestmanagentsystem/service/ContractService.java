package com.capgemini.forestmanagentsystem.service;

import java.util.List;

import com.capgemini.forestmanagentsystem.dto.ContractBean;

public interface ContractService {
	public boolean addContract(ContractBean bean);
	public  ContractBean getContract(int contractNo);
	public List<ContractBean> getAllContracts();
	public boolean updateContract(ContractBean bean);
	public boolean deleteContract(int contractNo);
}
