package com.capgemini.forestmanagentsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagentsystem.dto.UserBean;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	@Override
	public UserBean login(String email, String password,String role) {
		
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			String jpql="from UserBean where email=:email and password=:password and role=:role";
			TypedQuery<UserBean> query = entityManager.createQuery(jpql,UserBean.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			query.setParameter("role", role);
			UserBean record= (UserBean) query.getSingleResult();
			return record;
		
	}

	@Override
	public boolean add(UserBean bean) {
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
	public boolean updatePassword(String email, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		UserBean managerBean = entityManager.find(UserBean.class, email);
		if (managerBean != null) {
			transaction.begin();
			managerBean.setPassword(password);
			transaction.commit();
			
			return true;
		}
		entityManager.close();
		return false;
		
	}

}
