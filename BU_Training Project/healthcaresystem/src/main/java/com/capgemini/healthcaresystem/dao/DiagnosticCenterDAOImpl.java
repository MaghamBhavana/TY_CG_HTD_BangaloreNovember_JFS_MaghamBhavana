package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;

@Repository
public class DiagnosticCenterDAOImpl implements DiagnosticCenterDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public boolean addCenter(DiagnosticCenter center) {
		boolean isAdded = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(center);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	public boolean removeCenter(String centerId) {
		boolean isDeleted = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		DiagnosticCenter center = manager.find(DiagnosticCenter.class, centerId);
		if (center != null) {
			try {
				transaction.begin();
				manager.remove(center);
				transaction.commit();
				isDeleted = true;
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
				transaction.rollback();
			} finally {
				manager.close();
			}
		}
		return isDeleted;
	}

	@Override
	public List<DiagnosticCenter> getAllCenters() {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql = "from DiagnosticCenter";
			TypedQuery<DiagnosticCenter> query = manager.createQuery(jpql, DiagnosticCenter.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}
}
