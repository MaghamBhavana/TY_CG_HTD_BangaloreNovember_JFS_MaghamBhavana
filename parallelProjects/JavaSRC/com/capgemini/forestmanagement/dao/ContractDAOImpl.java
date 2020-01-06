package com.capgemini.forestmanagement.dao;

import java.util.HashMap;
import java.util.Map.Entry;
import com.capgemini.forestmanagement.dto.ContractBean;
import com.capgemini.forestmangement.exceptions.ContractIdNotFoundExcpection;

public class ContractDAOImpl implements ContractDAO {
	HashMap<Integer, ContractBean> contractBean = new HashMap<Integer, ContractBean>();
	ContractBean bean = new ContractBean();

	@Override
	public boolean addContract(int contractNo, ContractBean bean) {

		for (Entry<Integer, ContractBean> entry : contractBean.entrySet()) {
			if (entry.getKey() == bean.getContractNo()) {
				return false;
			}
		}

		contractBean.put(contractNo, bean);
		return true;

	}

	@Override
	public boolean deleteContract(int contractNo) {
		if (contractNo < 0) {
			throw new ContractIdNotFoundExcpection();
		} else {
			for (Entry<Integer, ContractBean> entry : contractBean.entrySet()) {
				if (entry.getKey() == contractNo) {
					contractBean.remove(contractNo);
					return true;
				}
			}
		}
		return false;

	}

	@Override
	public HashMap<Integer, ContractBean> getAllContracts() {
		return contractBean;
	}

	@Override
	public Entry<Integer, ContractBean> getContract(int contractNo) {
		if (contractNo < 0) {
			throw new ContractIdNotFoundExcpection();
		} else {
			for (Entry<Integer, ContractBean> entry : contractBean.entrySet()) {
				if (entry.getKey() == contractNo) {
					return entry;
				}
			}
			return null;
		}
	}

	@Override
	public boolean updateContract(int contractNo, ContractBean bean) {
		if (contractNo < 0) {
			throw new ContractIdNotFoundExcpection();
		} else {
			if (!contractBean.isEmpty()) {
				contractBean.replace(contractNo, bean);
				return true;

			} else {
				return false;
			}
		}
	}

}
