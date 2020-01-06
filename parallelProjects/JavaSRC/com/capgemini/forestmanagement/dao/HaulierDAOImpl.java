package com.capgemini.forestmanagement.dao;

import java.util.HashMap;
import java.util.Map.Entry;
import com.capgemini.forestmanagement.dto.HaulierBean;
import com.capgemini.forestmangement.exceptions.HaulierIdNotFoundException;

public class HaulierDAOImpl implements HaulierDAO {

	HashMap<Integer, HaulierBean> haulierBean = new HashMap<Integer, HaulierBean>();
	
	HaulierBean bean = new HaulierBean();

	@Override
	public boolean addHaulier(int haulierId, HaulierBean bean) {
		for (Entry<Integer, HaulierBean> entry : haulierBean.entrySet()) {
			if (entry.getKey() == bean.getHaulierId()) {
				return false;
			}
		}
		haulierBean.put(haulierId, bean);
		return true;
	}

	@Override
	public HashMap<Integer, HaulierBean> getAllHauliers() {

		return haulierBean;
	}

	@Override
	public Entry<Integer, HaulierBean> getHaulier(int haulierId) {
		if (haulierId < 0) {
			throw new HaulierIdNotFoundException();
		} else {
			for (Entry<Integer, HaulierBean> entry : haulierBean.entrySet()) {
				if (entry.getKey() == haulierId) {
					return entry;
				}
			}
		}
		return null;
	}

	@Override
	public boolean updateHaulier(int haulierId, HaulierBean bean) {

		if (!haulierBean.isEmpty()) {

			haulierBean.replace(haulierId, bean);

			return true;

		} else {
			return false;
		}
	}

	
	@Override
	public boolean deleteHaulier(int haulierId) {
		if (haulierId < 0) {
			throw new HaulierIdNotFoundException();
		} else {
			for (Entry<Integer, HaulierBean> entry : haulierBean.entrySet()) {
				if (entry.getKey() == haulierId)
					haulierBean.remove(haulierId);
				return true;
			}
		}
		return false;
	}

}
