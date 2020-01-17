package com.capgemini.forestmanagentsystem.dao;

import java.util.List;

import com.capgemini.forestmanagentsystem.dto.HaulierBean;

public interface HaulierDAO {
	
	public boolean addHauiler(HaulierBean bean);
	public  HaulierBean getHaulier(int haulierId);
	public List<HaulierBean> getAllHauliers();
	public boolean updateHaulier(HaulierBean bean);
	public boolean deleteHaulier(int haulierId);

}
