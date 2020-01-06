package com.capgemini.forestmanagement.dao;

import java.util.HashMap;
import java.util.Map.Entry;
import com.capgemini.forestmanagement.dto.HaulierBean;

public interface HaulierDAO {

	boolean addHaulier(int haulierId, HaulierBean bean);

	HashMap<Integer, HaulierBean> getAllHauliers();

	Entry<Integer, HaulierBean> getHaulier(int haulierId);

	boolean updateHaulier(int haulierId, HaulierBean bean);

	boolean deleteHaulier(int haulierId);
}
