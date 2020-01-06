package com.capgemini.forestmanagement.service;

import java.util.List;

import com.capgemini.forestmanagement.dto.HaulierBean;

public interface HaulierService {
	public boolean addHauiler(HaulierBean bean);
	public  HaulierBean getHaulier(int haulierId);
	public List<HaulierBean> getAllHauliers();
	public boolean updateHaulier(int haulierId, HaulierBean bean);
	public boolean deleteHaulier(int haulierId);
}
