package com.capgemini.mywebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;

public class EmployeeDAOImpl implements EmployeeDao {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

	@Override
	public EmployeeInfoBean searchEmployee(int empId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EmployeeInfoBean employeeInfoBean = entityManager.find(EmployeeInfoBean.class, empId);
		entityManager.close();
		return employeeInfoBean;
	}

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from EmployeeInfoBean where empId=:empId and password=:password";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("empId", empId);
		query.setParameter("password", password);

		EmployeeInfoBean employeeInfoBean = null;
		try {
			employeeInfoBean = (EmployeeInfoBean) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return employeeInfoBean;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		boolean isDeleted = false;
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 EmployeeInfoBean employeeInfoBean = entityManager.find(EmployeeInfoBean.class, empId);
		 EntityTransaction transaction = null;
		 if(employeeInfoBean != null)
		 {
			 transaction = entityManager.getTransaction();
			 transaction.begin();
			 entityManager.remove(employeeInfoBean);
			 transaction.commit();
			 isDeleted = true;
		 }
		return isDeleted;
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		boolean isAdded = false;
		 EntityManager entityManager = entityManagerFactory.createEntityManager();
		 EntityTransaction transaction = null;
		 try {
		 if(employeeInfoBean != null)
		 {
			 transaction = entityManager.getTransaction();
			 transaction.begin();
			 entityManager.persist(employeeInfoBean);;
			 transaction.commit();
			 isAdded = true;
		 }
		 }catch (Exception e) {
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from EmployeeInfoBean";
		Query query =entityManager.createQuery(jpql);
		List<EmployeeInfoBean> list = query.getResultList();
		entityManager.close();
		return list;
		
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		boolean isUpdated = false;
		
		EntityManager manager =entityManagerFactory.createEntityManager();
		EmployeeInfoBean existingEmployeeInfo = manager.find(EmployeeInfoBean.class, employeeInfoBean.getEmpId());
		
		EntityTransaction transaction = manager.getTransaction();
		
		if(existingEmployeeInfo != null) {
			try {
				transaction.begin();
				String newName = employeeInfoBean.getName().trim();
				if(newName != null && !newName.isEmpty()) {
					existingEmployeeInfo.setName(newName);
				}
				
				int newAge = employeeInfoBean.getAge();
				if(newAge > 18) {
					existingEmployeeInfo.setAge(newAge);
				}
				
				double newSalary = employeeInfoBean.getSalary();
				if(newSalary > 0) {
					existingEmployeeInfo.setSalary(newSalary);
				}
				
				String newDesignation = employeeInfoBean.getDesignation().trim();
				if(newDesignation != null && !newDesignation.isEmpty()) {
					existingEmployeeInfo.setDesignation(newDesignation);
				}
				
				String newPassword = employeeInfoBean.getPassword().trim();
				if(newPassword != null && !newPassword.isEmpty()) {
					existingEmployeeInfo.setPassword(newPassword);
				}
				transaction.commit();
				isUpdated = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		manager.close();
		return isUpdated;
	}

}
