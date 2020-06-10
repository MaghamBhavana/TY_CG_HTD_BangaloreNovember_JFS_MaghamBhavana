package com.capgemini.healthcaresystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaresystem.dto.Appointment;
import com.capgemini.healthcaresystem.dto.AppointmentResponse;
import com.capgemini.healthcaresystem.service.AppointmentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")

public class AppointmentController {

	@Autowired
		AppointmentService service;
	
	@PutMapping(path = "/update-appointment/{appointmentId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse updateTest(@PathVariable("appointmentId") long appointmentId, @RequestBody Appointment appointment) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		if (service.approveAppointment(appointmentId, appointment.getApprovalStatus())) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointment details are updated successfully");
		} else {
			appointmentResponse.setStatusCode(401);
			appointmentResponse.setMessage("Failure");
			appointmentResponse.setDescription("Appointment details are not updated");
		}
		return appointmentResponse;
	}
	
	@PostMapping(path = "/make-appointment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse addTest(@RequestBody Appointment appointment) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		if (service.makeAppointment(appointment)) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Successfully..Appointment details is added");
		} else {
			appointmentResponse.setStatusCode(401);
			appointmentResponse.setMessage("Failure");
			appointmentResponse.setDescription("Test is already exists");
		}
		return appointmentResponse;
	}
	
	@GetMapping(path = "/get-all-appointments", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse viewAllAppointments() {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		List<Appointment> list = service.getAllAppointments();
		if (list.size() != 0) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Successfully found your Appointments");
			appointmentResponse.setAppointment(list);;
		} else {
			appointmentResponse.setStatusCode(401);
			appointmentResponse.setMessage("Failure");
			appointmentResponse.setDescription("No appointments are found");
		}
		return appointmentResponse;
	}
	
	
}
