package com.capgemini.healthcaresystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcaresystem.dto.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public boolean register(User user) {
		boolean isAdded = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	public User login(String emailId, String userPassword) {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql = "from User where emailId=:emailId and userPassword=:userPassword";
			TypedQuery<User> query = manager.createQuery(jpql, User.class);
			query.setParameter("emailId", emailId);
			query.setParameter("userPassword", userPassword);
			User record = query.getSingleResult();
			return record;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

}
