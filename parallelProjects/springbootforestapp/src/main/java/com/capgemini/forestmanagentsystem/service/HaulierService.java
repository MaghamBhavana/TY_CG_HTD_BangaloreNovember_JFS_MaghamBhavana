package com.capgemini.forestmanagentsystem.service;

import java.util.List;

import com.capgemini.forestmanagentsystem.dto.HaulierBean;

public interface HaulierService {
	public boolean addHauiler(HaulierBean bean);
	public  HaulierBean getHaulier(int haulierId);
	public List<HaulierBean> getAllHauliers();
	public boolean updateHaulier(HaulierBean bean);
	public boolean deleteHaulier(int haulierId);
}
