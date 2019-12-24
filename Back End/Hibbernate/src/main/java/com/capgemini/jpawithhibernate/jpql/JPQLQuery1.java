package com.capgemini.jpawithhibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.hibernate.jpawithhibernate.dto.Movie;



public class JPQLQuery1 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		//String jpql=" from Movie";
		String jpql="select rating from Movie";
		Query query=entityManager.createQuery(jpql);
		//List<Movie> record=query.getResultList();
		List<String> record=query.getResultList();
		System.out.println(record);
		/*for(Movie movie:record)
		{
			System.out.println("Id= "+movie.getId());
			System.out.println("Name= "+movie.getName());
			System.out.println("Rating= "+movie.getRating());
		}*/
		for(String movie:record)
		{
			System.out.println(movie);
		}
		entityManager.close();
	}

}
