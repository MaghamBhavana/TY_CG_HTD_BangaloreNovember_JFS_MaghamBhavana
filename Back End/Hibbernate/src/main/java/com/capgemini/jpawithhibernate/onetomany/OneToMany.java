package com.capgemini.jpawithhibernate.onetomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernate.onetoone.Student;


public class OneToMany {
	public static void main(String[] args) {
		/*Student info=new Student();
		info.setStud_id(3);
		info.setStud_name("Ramya");
		info.setStud_email("pavan@gmail.com");
		info.setStud_password("223455");

		Student_Experience s=new Student_Experience();
		s.setExpId(145);
		s.setCname("Infosys");
		s.setNoOfYear(2);
		s.setInfo(info);

		Student_Experience s1=new Student_Experience();
		s1.setExpId(156);
		s1.setCname("TCS");
		s1.setNoOfYear(4);
		s1.setInfo(info);*/

		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
			entityManagerFactory=Persistence.createEntityManagerFactory("Test");
			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			Student st=entityManager.find(Student.class, 3);
			Student_Experience s1=new Student_Experience();
			s1.setExpId(157);
			s1.setCname("TCS");
			s1.setNoOfYear(4);
			//		s1.setInfo(info);

			//		entityManager.persist(s);
			entityManager.persist(s1);
			transaction.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}
		entityManager.close();


	}

}
