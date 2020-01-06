package com.capgemini.forestmanagement.dao;

import java.util.HashMap;
import java.util.Map.Entry;

import com.capgemini.forestmanagement.dto.ContractBean;

public interface ContractDAO {

	boolean addContract(int contractorNo, ContractBean bean);

	HashMap<Integer, ContractBean> getAllContracts();

	Entry<Integer, ContractBean> getContract(int contractNo);

	boolean updateContract(int contractNo, ContractBean bean);

	boolean deleteContract(int contractNo);

}
