package com.capgemini.empdetails.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.empdetails.dto.Employee;

@Repository
public class EmpDAOImpl implements EmpDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addEmp(Employee emp) {
		boolean isAdded = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(emp);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	public boolean updateEmp(int empId, Employee emp) {
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			Employee bean = manager.find(Employee.class, empId);
			if (bean != null) {
				transaction.begin();
				bean.setEmpName(emp.getEmpName());
				bean.setSalary(emp.getSalary());
				transaction.commit();
				isUpdated = true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isUpdated;
	}

	@Override
	public List<Employee> getAllEmp() {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql = "from Employee";
			TypedQuery<Employee> query = manager.createQuery(jpql, Employee.class);
			return query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public Employee getEmp(int empId) {
		EntityManager manager = factory.createEntityManager();
		try {
			Employee bean = manager.find(Employee.class, empId);
			return bean;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public boolean deleteEmp(int empId) {
		boolean isDeleted = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Employee emp = manager.find(Employee.class, empId);
		if (emp != null) {
			try {
				transaction.begin();
				manager.remove(emp);
				transaction.commit();
				isDeleted = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				transaction.rollback();
			} finally {
				manager.close();
			}
		}
		return isDeleted;
	}
}
