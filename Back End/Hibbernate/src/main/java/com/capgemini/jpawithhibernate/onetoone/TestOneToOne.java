package com.capgemini.jpawithhibernate.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestOneToOne {
	public static void main(String[] args) {
		Student s=new Student();
		s.setStud_id(101);
		s.setStud_name("Bhavana");
		s.setStud_email("bhavana@gmail.com");
		s.setStud_password("1234");
		Student_OtherInfo otherInfo=new Student_OtherInfo();
		otherInfo.setSid(102);
		otherInfo.setPancard(12346);
		otherInfo.setFathername("Koteswara Rao");
		otherInfo.setMothername("Chandrika");
		otherInfo.setStudent(s);
		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
		entityManagerFactory=Persistence.createEntityManagerFactory("Test");
		entityManager=entityManagerFactory.createEntityManager();
		transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(otherInfo);
		Student s1=new Student();
		entityManager.find(Student.class, 101);
		System.out.println(s1.getInfo().getPancard());
		System.out.println("record saved");
		transaction.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}
		entityManager.close();
	}

}
