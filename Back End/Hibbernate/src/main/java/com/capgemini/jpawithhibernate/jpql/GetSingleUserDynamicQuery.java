package com.capgemini.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.hibernate.jpawithhibernate.dto.Movie;

public class GetSingleUserDynamicQuery {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String jpql="from Movie where id=:id";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("id", 106);
		Movie record=(Movie) query.getSingleResult();
		if(record!=null)
		{
			System.out.println(record.getId());
			System.out.println(record.getName());
			System.out.println(record.getRating());
		}
	}

}
