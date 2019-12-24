package com.capgemini.hibernate.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.hibernate.jpawithhibernate.dto.Movie;

public class Reattaching {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager =null;
		EntityTransaction transaction=null;
		try {
		entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
			transaction.begin();
			Movie movie=entityManager.find(Movie.class, 101);
			System.out.println(entityManager.contains(movie));
			entityManager.detach(movie);//it will detach the object from the database.
			System.out.println(entityManager.contains(movie));
			Movie reattachRecord = entityManager.merge(movie);
			reattachRecord.setName("cinema one");
			reattachRecord.setRating("Good");
			System.out.println("Record Updated----");
			transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		entityManager.close();
		
	}

}
