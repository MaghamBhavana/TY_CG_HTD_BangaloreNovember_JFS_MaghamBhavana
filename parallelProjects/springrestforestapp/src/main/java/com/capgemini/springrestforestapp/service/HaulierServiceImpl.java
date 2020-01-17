package com.capgemini.springrestforestapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springrestforestapp.dao.HaulierDAO;
import com.capgemini.springrestforestapp.dto.HaulierBean;

@Service
public class HaulierServiceImpl implements HaulierService {
	@Autowired
	HaulierDAO dao;
	@Override
	public boolean addHauiler(HaulierBean bean) {
		
		return dao.addHauiler(bean);
	}

	@Override
	public HaulierBean getHaulier(int haulierId) {
		
		return dao.getHaulier(haulierId);
	}

	@Override
	public List<HaulierBean> getAllHauliers() {
		
		return dao.getAllHauliers();
	}

	@Override
	public boolean updateHaulier(HaulierBean bean) {
		
		return dao.updateHaulier(bean);
	}

	@Override
	public boolean deleteHaulier(int haulierId) {
		
		return dao.deleteHaulier(haulierId);
	}

}
