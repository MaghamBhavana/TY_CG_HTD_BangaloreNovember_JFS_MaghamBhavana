package com.capgemini.springrestforestapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.springrestforestapp.dto.ProductBean;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	@Override
	public boolean addProduct(ProductBean bean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	
	}

	@Override
	public ProductBean getProduct(int productId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ProductBean product=entityManager.find(ProductBean.class, productId);
		return product;
	}

	@Override
	public List<ProductBean> getAllProducts() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String getAllProducts="from ProductBean";
		TypedQuery<ProductBean> query=entityManager.createQuery(getAllProducts,ProductBean.class);
		return query.getResultList();
	}

	
	

	@Override
	public boolean deleteProduct(int productId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		ProductBean product = entityManager.find(ProductBean.class, productId);
		if(product!=null) {
			transaction.begin();
			entityManager.remove(product);
			transaction.commit();
			entityManager.close();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateProduct(ProductBean bean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		ProductBean productBean = entityManager.find(ProductBean.class, bean.getProductId());
		if (productBean != null) {
			transaction.begin();
			productBean.setProductName(bean.getProductName());
			productBean.setCost(bean.getCost());
			transaction.commit();
			return true;
		}
		return false;
	}

}
