package com.capgemini.forestmanagentsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagentsystem.dto.CustomerBean;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addCustomer(CustomerBean bean) {
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
	public CustomerBean getCustomer(int customerId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CustomerBean bean = entityManager.find(CustomerBean.class, customerId);
		return bean;
	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from CustomerBean";
		TypedQuery<CustomerBean> query = entityManager.createQuery(jpql, CustomerBean.class);
		return query.getResultList();
	}

	@Override
	public boolean updateCustomer(CustomerBean bean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		CustomerBean customerBean = entityManager.find(CustomerBean.class, bean.getCustomerId());
		if (customerBean != null) {
			transaction.begin();
			customerBean.setCustomerName(bean.getCustomerName());
			customerBean.setAddress1(bean.getAddress1());
			customerBean.setAddress2(bean.getAddress2());
			customerBean.setTown(bean.getTown());
			customerBean.setPostalCode(bean.getPostalCode());
			customerBean.setEmail(bean.getEmail());
			customerBean.setPhoneNumber(bean.getPhoneNumber());
			transaction.commit();
			
			return true;
		}
		entityManager.close();
		return false;
	}

	

	@Override
	public boolean deleteCustomer(int customerId) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			CustomerBean customerBean = entityManager.find(CustomerBean.class, customerId);
			entityManager.remove(customerBean);
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
