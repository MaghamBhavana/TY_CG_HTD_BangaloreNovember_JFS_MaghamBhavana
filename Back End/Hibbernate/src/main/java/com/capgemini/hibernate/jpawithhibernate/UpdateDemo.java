package com.capgemini.hibernate.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.hibernate.jpawithhibernate.dto.Movie;

public class UpdateDemo {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager =null;
		EntityTransaction transaction=null;
		try {
		entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
			transaction.begin();
			Movie movie=entityManager.find(Movie.class, 103);
			movie.setName("Bahubali");
			movie.setRating("VeryGood");
			System.out.println("Record Updated----");
			transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		entityManager.close();
		
	}//end the main

}//end the class
