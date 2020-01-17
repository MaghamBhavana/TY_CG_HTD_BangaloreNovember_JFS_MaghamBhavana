package com.capgemini.forestmanagentsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagentsystem.dto.OrderBean;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	@Override
	public boolean addOrder(OrderBean bean) {
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

	@Override
	public OrderBean getOrder(int orderNo) {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			String jpql="from OrderBean where orderNo=:orderNo";
			Query query=entityManager.createQuery(jpql);
			query.setParameter("orderNo", orderNo);
			OrderBean record= (OrderBean) query.getSingleResult();
			if(record != null) {
				return record;
			} 
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			return null;
	}

	@Override
	public List<OrderBean> getAllOrders() {
		
		EntityManager entityManager = null;
		
		try {
		entityManager=entityManagerFactory.createEntityManager();
		String jpql="from OrderBean";
		TypedQuery<OrderBean> query = entityManager.createQuery(jpql, OrderBean.class);
		return query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean updateOrder(OrderBean bean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		OrderBean orderBean = entityManager.find(OrderBean.class, bean.getOrderNo());
		if (orderBean != null) {
			transaction.begin();
			orderBean.setCustomerId(bean.getCustomerId());
			orderBean.setProductId(bean.getProductId());
			orderBean.setHaulierId(bean.getHaulierId());
			orderBean.setDeliveryDate(bean.getDeliveryDate());
			orderBean.setDeliveryDay(bean.getDeliveryDay());
			orderBean.setQuantity(bean.getQuantity());
			transaction.commit();
			return true;
		}
		return false;
	}

	

	@Override
	public boolean deleteOrder(int orderNo) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
		 entityManager = entityManagerFactory.createEntityManager();
		 transaction = entityManager.getTransaction();
		transaction.begin();
		OrderBean orderBean = entityManager.find(OrderBean.class, orderNo);
		entityManager.remove(orderBean);
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
