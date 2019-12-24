package com.capgemini.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicJPQLForUpdate {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		String jpql="update Movie set MovieName=:Nm where id=:id";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("Nm","Billa");
		query.setParameter("id",103);
		int result=query.executeUpdate();
		System.out.println(result);
		transaction.commit();
		entityManager.close();
		
	}

}
