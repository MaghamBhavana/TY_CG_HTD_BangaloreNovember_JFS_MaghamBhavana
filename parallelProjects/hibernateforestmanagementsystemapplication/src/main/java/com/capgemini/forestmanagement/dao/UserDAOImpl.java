package com.capgemini.forestmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.forestmanagement.dto.UserBean;

public class UserDAOImpl implements UserDAO {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("project");

	
	public UserBean login(String email, String password, String role) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from UserBean where email=:email and password=:password and role=:role";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			query.setParameter("role", role);
			UserBean record = (UserBean) query.getSingleResult();
			if (record != null) {
				return record;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;

	}

	
	public boolean addUser(UserBean bean) {
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
	public boolean deleteUser(String email) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
		 entityManager = entityManagerFactory.createEntityManager();
		 transaction = entityManager.getTransaction();
		transaction.begin();
		UserBean userBean = entityManager.find(UserBean.class, email);
		entityManager.remove(userBean);
		transaction.commit();
		return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;
	}
	
	@Override
	public List<UserBean> getAllUsers() {
		EntityManager entityManager = null;
		
		try {
		entityManager=entityManagerFactory.createEntityManager();
		String jpql="from UserBean";
		TypedQuery<UserBean> query = entityManager.createQuery(jpql, UserBean.class);
		return query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

}
