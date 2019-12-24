package com.capgemini.jpawithhibernate.manytomany;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernate.onetoone.Student;

public class TestManyToMany {
	public static void main(String[] args) {
		Student s=new Student();
		s.setStud_id(1);
		s.setStud_name("Balaram");
		s.setStud_email("Balaram@gmail.com");
		s.setStud_password("145666");
		
		Student s1=new Student();
		s1.setStud_id(2);
		s1.setStud_name("pavan");
		s1.setStud_email("kumar@gmail.com");
		s1.setStud_password("14666");
		
		ArrayList<Student> student=new ArrayList<Student>();
		student.add(s);
		student.add(s1);
		
		TrainingInfo t=new TrainingInfo();
		t.setTId(23);
		t.setTName("java");
		t.setSlist(student);
		
		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
			entityManagerFactory=Persistence.createEntityManagerFactory("Test");
			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(t);
			transaction.commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}
		entityManager.close();
	}

}
