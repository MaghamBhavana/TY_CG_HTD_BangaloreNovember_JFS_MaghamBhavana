package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.dao.HaulierDAO;
import com.capgemini.forestmanagement.dto.HaulierBean;
import com.capgemini.forestmanagement.factory.HaulierFactory;

public class HaulierServiceImpl implements HaulierService {

	HaulierDAO dao = HaulierFactory.instanceOfHaulierDAOImpl();
	
	public boolean addHauiler(HaulierBean bean) {
		
		return dao.addHauiler(bean);
	}

	
	public HaulierBean getHaulier(int haulierId) {
		
		return dao.getHaulier(haulierId);
	}

	
	public List<HaulierBean> getAllHauliers() {
		
		return dao.getAllHauliers();
	}

	
	public boolean updateHaulier(int haulierId, HaulierBean bean) {
		
		return dao.updateHaulier(haulierId, bean);
	}

	
	public boolean deleteHaulier(int haulierId) {
		
		return dao.deleteHaulier(haulierId);
	}

}
