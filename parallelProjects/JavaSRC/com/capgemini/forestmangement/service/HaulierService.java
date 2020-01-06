package com.capgemini.forestmangement.service;

import java.util.HashMap;
import java.util.Map.Entry;
import com.capgemini.forestmanagement.dto.HaulierBean;

public interface HaulierService {

	boolean addHaulier(int haulierNo, HaulierBean bean);

	HashMap<Integer, HaulierBean> getAllHauliers();

	Entry<Integer, HaulierBean> getHaulier(int orderNo);

	boolean updateHaulier(int haulierNo, HaulierBean bean);

	boolean deleteHaulier(int haulierNo);

}
