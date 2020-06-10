 package com.capgemini.healthcaresystem.dao;

import java.util.List;

import com.capgemini.healthcaresystem.dto.Appointment;

public interface AppointmentDAO {

	boolean approveAppointment(long appointmentId, String approvalStatus);
	
	boolean makeAppointment(Appointment appointment);
	
	List<Appointment> getAllAppointments();
}
