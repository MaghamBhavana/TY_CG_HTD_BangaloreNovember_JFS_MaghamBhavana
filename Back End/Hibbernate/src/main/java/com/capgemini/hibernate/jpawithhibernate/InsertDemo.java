package com.capgemini.hibernate.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.hibernate.jpawithhibernate.dto.Movie;

public class InsertDemo {
	public static void main(String[] args) {

		Movie movie = new Movie();
		movie.setId(105);
		movie.setName("Snahem");
		movie.setRating("Good");
		EntityManagerFactory entityManagerFactory=null;
		EntityTransaction transaction=null;
		EntityManager entityManager=null;
		try {
		entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		entityManager=entityManagerFactory.createEntityManager();
		transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(movie);
		System.out.println("Record saved");
		transaction.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}
		//transaction.commit();
		entityManager.close();
	}//end of main

}//end of class
