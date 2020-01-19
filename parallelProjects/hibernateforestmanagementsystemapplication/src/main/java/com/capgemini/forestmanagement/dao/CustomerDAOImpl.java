package com.capgemini.forestmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.forestmanagement.dto.CustomerBean;


public class CustomerDAOImpl implements CustomerDAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("project");

	
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

	
	public CustomerBean getCustomer(int customerId) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from CustomerBean where customerId=:customerId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("customerId", customerId);
			CustomerBean record = (CustomerBean) query.getSingleResult();
			if (record != null) {
				return record;
			} 
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	
	public List<CustomerBean> getAllCustomers() {
		EntityManager entityManager = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from CustomerBean";
			TypedQuery<CustomerBean> query = entityManager.createQuery(jpql, CustomerBean.class);
			return query.getResultList(); 
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	
	public boolean updateCustomer(int customerId, CustomerBean bean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CustomerBean customerBean = entityManager.find(CustomerBean.class, bean.getCustomerId());
		if (customerBean != null) {
			updateCustomerName(customerId, bean.getCustomerName());
			updateAddress1(customerId, bean.getAddress1());
			updateAddress2(customerId, bean.getAddress2());
			updateTown(customerId, bean.getTown());
			updatePostalCode(customerId, bean.getPostalCode());
			updateEmail(customerId, bean.getEmail());
			updatePhoneNumber(customerId, bean.getPhoneNumber());
			return true;
		}
		return false;
	}

	private boolean updatePhoneNumber(int customerId, long phoneNumber) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "update CustomerBean set phoneNumber=:phoneNumber where customerId=:customerId";
			Query query = entityManager.createQuery(jpql);
			String s = "phoneNumber";
			query.setParameter(s, phoneNumber);
			query.setParameter("customerId", customerId);
			int result = query.executeUpdate();
			transaction.commit();
			if (result > 0) {
				return true;
			} 
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;

	}

	private boolean updateEmail(int customerId, String email) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "update CustomerBean set email=:email where customerId=:customerId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("email", email);
			query.setParameter("customerId", customerId);
			int result = query.executeUpdate();
			transaction.commit();
			if (result > 0) {
				return true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;

	}

	private boolean updatePostalCode(int customerId, int postalCode) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "update CustomerBean set postalCode=:postalCode where customerId=:customerId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("postalCode", postalCode);
			query.setParameter("customerId", customerId);
			int result = query.executeUpdate();
			transaction.commit();
			if (result > 0) {
				return true;
			} 
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;

	}

	private boolean updateTown(int customerId, String town) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "update CustomerBean set town=:town where customerId=:customerId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("town", town);
			query.setParameter("customerId", customerId);
			int result = query.executeUpdate();
			transaction.commit();
			if (result > 0) {
				return true;
			} 
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;
	}

	private boolean updateAddress2(int customerId, String address2) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "update CustomerBean set address2=:address2 where customerId=:customerId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("address2", address2);
			query.setParameter("customerId", customerId);
			int result = query.executeUpdate();
			transaction.commit();
			if (result > 0) {
				return true;
			} 
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;
	}

	private boolean updateAddress1(int customerId, String address1) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "update CustomerBean set address1=:address1 where customerId=:customerId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("address1", address1);
			query.setParameter("customerId", customerId);
			int result = query.executeUpdate();
			transaction.commit();
			if (result > 0) {
				return true;
			} 
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;
	}

	private boolean updateCustomerName(int customerId, String customerName) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "update CustomerBean set customerName=:customerName where customerId=:customerId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("customerName", customerName);
			query.setParameter("customerId", customerId);
			int result = query.executeUpdate();
			transaction.commit();
			if (result > 0) {
				return true;
			} 
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;
	}

	
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
