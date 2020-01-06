package com.capgemini.forestmanagement.dao;

import java.util.List;
import com.capgemini.forestmanagement.dto.ContractBean;

public interface ContractDAO {
	
	public boolean addContract(ContractBean bean);
	public  ContractBean getContract(int contractNo);
	public List<ContractBean> getAllContracts();
	public boolean updateContract(int contractNo, ContractBean bean);
	public boolean deleteContract(int contractNo);
}
