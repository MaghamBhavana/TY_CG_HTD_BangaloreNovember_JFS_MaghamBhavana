package com.capgemini.forestmanagement.dao;

import java.util.HashMap;
import java.util.Map.Entry;
import com.capgemini.forestmanagement.dto.ProductBean;
import com.capgemini.forestmangement.exceptions.ProductIdNotFoundException;

public class ProductDAOImpl implements ProductDAO {

	HashMap<Integer, ProductBean> productBean = new HashMap<Integer, ProductBean>();
	ProductBean bean = new ProductBean();

	@Override
	public boolean addProduct(int productId, ProductBean bean) {
		for (Entry<Integer, ProductBean> entry : productBean.entrySet()) {
			if (entry.getKey() == bean.getProductId()) {
				return false;
			}
		}
		productBean.put(productId, bean);
		return true;
	}

	@Override
	public HashMap<Integer, ProductBean> getAllProducts() {
		if (productBean != null) {
			return productBean;
		} else {
			return null;
		}
	}

	@Override
	public Entry<Integer, ProductBean> getProduct(int productId) {
		if (productId < 0) {
			throw new ProductIdNotFoundException();
		} else {
			for (Entry<Integer, ProductBean> entry : productBean.entrySet()) {
				if (entry.getKey() == productId) {
					return entry;
				}
			}
		}
		return null;
	}

	@Override
	public boolean updateProduct(int productId, ProductBean bean) {
		if (productId < 0) {
			throw new ProductIdNotFoundException();
		} else {
			if (!productBean.isEmpty()) {

				productBean.replace(productId, bean);
				return true;

			} else {
				return false;
			}
		}
	}

	@Override
	public boolean deleteProduct(int productId) {
		if (productId < 0) {
			throw new ProductIdNotFoundException();
		} else {
			for (Entry<Integer, ProductBean> entry : productBean.entrySet()) {
				if (entry.getKey() == productId)
					productBean.remove(productId);
				return true;
			}
		}
		return false;
	}

}
