package com.capgemini.forestmangement.service;

import java.util.HashMap;
import java.util.Map.Entry;

import com.capgemini.forestmanagement.dto.ContractBean;

public interface ContractService {

	boolean addContract(int contractorNo, ContractBean bean);

	HashMap<Integer, ContractBean> getAllContracts();

	Entry<Integer, ContractBean> getContract(int contractNo);

	boolean updateContract(int contractNo, ContractBean bean);

	boolean deleteContract(int contractorNo);
}
