package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcaresystem.dto.Appointment;

@Repository
public class AppointmentDAOImpl implements AppointmentDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public boolean approveAppointment(long appointmentId, String approvalStatus) {
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			Appointment bean = manager.find(Appointment.class, appointmentId);
			if (bean != null) {
				transaction.begin();
				bean.setApprovalStatus(approvalStatus);
				transaction.commit();
				isUpdated = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isUpdated;
	}

	@Override
	public boolean makeAppointment(Appointment appointment) {
		boolean isAdded = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(appointment);
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
	public List<Appointment> getAllAppointments() {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql = "from Appointment";
			TypedQuery<Appointment> query = manager.createQuery(jpql, Appointment.class);
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
