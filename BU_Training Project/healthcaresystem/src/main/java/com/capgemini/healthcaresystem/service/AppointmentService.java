package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.dto.Appointment;

public interface AppointmentService {

	boolean approveAppointment(long appointmentId, String approvalStatus);
	
	boolean makeAppointment(Appointment appointment);
	
	List<Appointment> getAllAppointments();
}
