package com.capgemini.forestmanagentsystem.dao;

import java.util.List;

import com.capgemini.forestmanagentsystem.dto.ContractBean;

public interface ContractDAO {

	public boolean addContract(ContractBean bean);

	public ContractBean getContract(int contractNo);

	public List<ContractBean> getAllContracts();

	public boolean updateContract(ContractBean bean);

	public boolean deleteContract(int contractNo);
}
