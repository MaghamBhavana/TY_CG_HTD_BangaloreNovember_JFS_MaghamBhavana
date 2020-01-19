package com.capgemini.forestmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.forestmanagement.dto.CustomerBean;
import com.capgemini.forestmanagement.dto.HaulierBean;
import com.capgemini.forestmanagement.dto.OrderBean;
import com.capgemini.forestmanagement.dto.ProductBean;

public class OrderDAOImpl implements OrderDAO {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("project");

	public boolean addOrder(OrderBean bean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.merge(bean);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}
		return false;
	}

	public OrderBean getOrder(int orderNo) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			OrderBean bean = entityManager.find(OrderBean.class, orderNo);
			return bean;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public CustomerBean getCustomer(int customerId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			CustomerBean cutomerBean = manager.find(CustomerBean.class, customerId);
			return cutomerBean;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;

	}

	public List<OrderBean> getAllOrders() {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			String jpql = "from OrderBean";
			TypedQuery<OrderBean> query = entityManager.createQuery(jpql, OrderBean.class);
			return query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public boolean updateOrder(int orderNo, OrderBean bean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			OrderBean orderBean = entityManager.find(OrderBean.class, bean.getOrderNo());
			if (orderBean != null) {
				transaction.begin();
				if (bean.getCustomer() != null) {
					orderBean.setCustomer(bean.getCustomer());
				}
				orderBean.setDeliveryDate(bean.getDeliveryDate());
				orderBean.setDeliveryDay(bean.getDeliveryDay());
				if (bean.getHaulier() != null) {
					orderBean.setHaulier(bean.getHaulier());
				}
				if (bean.getProduct() != null) {
					orderBean.setProduct(bean.getProduct());
				}
				orderBean.setQuantity(bean.getQuantity());
				
				entityManager.merge(orderBean);
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			entityManager.close();
		}
		return false;
	}

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
		} finally {
			entityManager.close();
		}
		return false;
	}

	@Override
	public ProductBean getProduct(int productId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			ProductBean productBean = manager.find(ProductBean.class, productId);
			return productBean;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public HaulierBean getHaulier(int haulierId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			HaulierBean haulierBean = manager.find(HaulierBean.class, haulierId);
			return haulierBean;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}
}