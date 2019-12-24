package com.capgemini.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.hibernate.jpawithhibernate.dto.Movie;

public class GetSingleRecordJPQL {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String jpql=" from Movie where MovieName='Darling'";
		Query query=entityManager.createQuery(jpql);
		Movie record=(Movie) query.getSingleResult();
		//System.out.println(record);
		if(record!=null)
		{
			System.out.println(record.getId());
			System.out.println(record.getName());
		}
}
}
