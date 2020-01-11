package com.capgemini.module2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.module2.dto.UserInfoBean;
import com.capgemini.module2.exception.UserException;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean register(UserInfoBean userBean) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(userBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new UserException("Email already exists. Please, Login");
		}
	}

	@Override
	public UserInfoBean login(UserInfoBean credentials) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		String jpql = "from UserInfoBean where email=:email";
		TypedQuery<UserInfoBean> query = manager.createQuery(jpql, UserInfoBean.class);
		query.setParameter("email", credentials.getEmail());
		try {
			UserInfoBean account = query.getSingleResult();
			if (account.getPassword().equals(credentials.getPassword())) {
				return account;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new UserException("Email doesn't exsist. Please, Register");
		}
	}
	

	@Override
	public boolean updatePassword(String email, String password) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		UserInfoBean user = manager.find(UserInfoBean.class, email);
		EntityTransaction transaction = manager.getTransaction();
		if (user != null) {
			transaction.begin();
			user.setPassword(password);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

}
