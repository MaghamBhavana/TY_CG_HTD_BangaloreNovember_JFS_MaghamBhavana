package com.capgemini.forestmangement.service;

import java.util.HashMap;
import java.util.Map.Entry;

import com.capgemini.forestmanagement.dao.HaulierDAO;
import com.capgemini.forestmanagement.dto.HaulierBean;
import com.capgemini.forestmanagement.factory.HaulierFactory;

public class HaulierServiceImpl implements HaulierService {

	HaulierDAO dao = HaulierFactory.instanceOfHaulierDAOImpl();

	@Override
	public boolean addHaulier(int haulierNo, HaulierBean bean) {

		return dao.addHaulier(haulierNo, bean);
	}

	@Override
	public HashMap<Integer, HaulierBean> getAllHauliers() {

		return dao.getAllHauliers();
	}

	@Override
	public Entry<Integer, HaulierBean> getHaulier(int orderNo) {

		return dao.getHaulier(orderNo);
	}

	@Override
	public boolean updateHaulier(int haulierNo, HaulierBean bean) {

		return dao.updateHaulier(haulierNo, bean);
	}

	@Override
	public boolean deleteHaulier(int haulierNo) {

		return dao.deleteHaulier(haulierNo);
	}

}
