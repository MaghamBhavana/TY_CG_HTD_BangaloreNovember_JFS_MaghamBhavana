package com.capgemini.forestmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.forestmanagement.dto.ProductBean;

public class ProductDAOImpl implements ProductDAO {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("project");
	
	public boolean addProduct(ProductBean bean) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(bean);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			entityTransaction.rollback();
		}
		entityManager.close();
		return false;
	
	}

		public ProductBean getProduct(int productId) {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			String jpql="from ProductBean where productId=:productId";
			Query query=entityManager.createQuery(jpql);
			query.setParameter("productId", productId);
			ProductBean record= (ProductBean) query.getSingleResult();
			if(record != null) {
				return record;
			} 
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			return null;
	}

	
	public List<ProductBean> getAllProducts() {
		EntityManager entityManager = null;
		
		try {
		entityManager=entityManagerFactory.createEntityManager();
		String jpql="from ProductBean";
		TypedQuery<ProductBean> query = entityManager.createQuery(jpql, ProductBean.class);
		return query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public boolean updateProduct(int productId, ProductBean bean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ProductBean productBean = entityManager.find(ProductBean.class, bean.getProductId());
		if (productBean != null) {
			updateProductName(productId, bean.getProductName());

			updateProductCost(productId, bean.getCost());

			return true;
		}
		return false;
	}

	
	private boolean updateProductCost(int productId, double cost) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
	
		try {
		entityManager=entityManagerFactory.createEntityManager();
		transaction=entityManager.getTransaction();
		transaction.begin();
		String jpql="update ProductBean set cost=:cost where productId=:productId";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("cost",cost);
		query.setParameter("productId",productId);
		int result=query.executeUpdate();
		transaction.commit();
		if(result > 0) {
			return true;
		} 
		} catch(Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;
		
	}

	public boolean updateProductName(int productId, String newName) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
	
		try {
		entityManager=entityManagerFactory.createEntityManager();
		transaction=entityManager.getTransaction();
		transaction.begin();
		String jpql="update ProductBean set productName=:productName where productId=:productId";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("productName",newName);
		query.setParameter("productId",productId);
		int result=query.executeUpdate();
		transaction.commit();
		if(result > 0) {
			return true;
		} 
		} catch(Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;
	}

	
	public boolean deleteProduct(int productId) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
		 entityManager = entityManagerFactory.createEntityManager();
		 transaction = entityManager.getTransaction();
		transaction.begin();
		ProductBean productBean = entityManager.find(ProductBean.class, productId);
		entityManager.remove(productBean);
		transaction.commit();
		return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;
	}

}
