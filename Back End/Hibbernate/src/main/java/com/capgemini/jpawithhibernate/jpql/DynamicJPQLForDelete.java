package com.capgemini.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicJPQLForDelete {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql="delete from Movie where id=:id";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("id", 103);
		int record=query.executeUpdate();
		transaction.commit();
		System.out.println(record);
		
	}

}
