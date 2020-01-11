package com.capgemini.module2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.module2.dto.ProductInfoBean;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addProduct(ProductInfoBean productBean) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(productBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<ProductInfoBean> getAllProducts() {
		EntityManager manager = entityManagerFactory.createEntityManager();
		String getall = "from ProductInfoBean";
		TypedQuery<ProductInfoBean> query = manager.createQuery(getall, ProductInfoBean.class);
		return query.getResultList();
	}

	@Override
	public ProductInfoBean searchProduct(int id) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		ProductInfoBean product = manager.find(ProductInfoBean.class, id);
		return product;
	}

}
