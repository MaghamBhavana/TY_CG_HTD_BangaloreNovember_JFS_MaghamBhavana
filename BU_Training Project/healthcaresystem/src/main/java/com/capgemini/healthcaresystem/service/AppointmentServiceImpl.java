package com.capgemini.healthcaresystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.AppointmentDAO;
import com.capgemini.healthcaresystem.dto.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentDAO dao;
	@Override
	public boolean approveAppointment(long appointmentId, String approvalStatus) {
		// TODO Auto-generated method stub
		return dao.approveAppointment(appointmentId, approvalStatus);
	}

	@Override
	public boolean makeAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return dao.makeAppointment(appointment);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return dao.getAllAppointments();
	}

}
