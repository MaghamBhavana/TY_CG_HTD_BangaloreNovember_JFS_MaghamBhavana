package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcaresystem.dto.Test;

@Repository
public class TestDAOImpl implements TestDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public boolean addTest(Test test) {
		boolean isAdded = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(test);
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
	public boolean removeTest(int testId) {
		boolean isDeleted = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Test test = manager.find(Test.class, testId);
		if (test != null) {
			try {
				transaction.begin();
				manager.remove(test);
				transaction.commit();
				isDeleted = true;
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
				transaction.rollback();
			} finally {
				manager.close();
			}
		}
		return isDeleted;
	}

	@Override
	public List<Test> getAllTests() {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql = "from Test";
			TypedQuery<Test> query = manager.createQuery(jpql, Test.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

}
