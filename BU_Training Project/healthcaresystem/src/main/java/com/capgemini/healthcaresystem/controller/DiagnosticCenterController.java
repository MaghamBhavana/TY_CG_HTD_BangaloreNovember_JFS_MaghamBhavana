package com.capgemini.healthcaresystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.dto.DiagnosticCenterResponse;
import com.capgemini.healthcaresystem.service.DiagnosticCenterService;
import com.capgemini.healthcaresystem.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class DiagnosticCenterController {

	@Autowired
	DiagnosticCenterService service;
	
	@Autowired
	UserService service1;
	
	
	@PostMapping(path = "/add-center", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse addCenter(@RequestBody DiagnosticCenter center) {

		DiagnosticCenterResponse centerResponse = new DiagnosticCenterResponse();
		if (service.addCenter(center)) {
			centerResponse.setStatusCode(201);
			centerResponse.setMessage("Success");
			centerResponse.setDescription("Successfully..Center details is added");
		} else {
			centerResponse.setStatusCode(401);
			centerResponse.setMessage("Failure");
			centerResponse.setDescription("Center is already exists");
		}
		return centerResponse;
	}
	
	@GetMapping(path = "/get-all-centers", produces = MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse viewAllCenters() {
		DiagnosticCenterResponse centerResponse = new DiagnosticCenterResponse();
		List<DiagnosticCenter> listCenter = service.getAllCenters();
		if (listCenter.size() != 0) {
			centerResponse.setStatusCode(201);
			centerResponse.setMessage("Success");
			centerResponse.setDescription("Successfully found your centers");
			centerResponse.setCenter(listCenter);
		} else {
			centerResponse.setStatusCode(401);
			centerResponse.setMessage("Failure");
			centerResponse.setDescription("No tests are found");
		}
		return centerResponse;
	}
	
	@DeleteMapping(path = "/delete-center/{centerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse deleteCenter(@PathVariable("centerId") String centerId) {
		DiagnosticCenterResponse centerResponse = new DiagnosticCenterResponse();
		if (service.removeCenter(centerId)) {
			centerResponse.setStatusCode(201);
			centerResponse.setMessage("Success");
			centerResponse.setDescription("Center details deleted");
		} else {
			centerResponse.setStatusCode(401);
			centerResponse.setMessage("Failure");
			centerResponse.setDescription("Center Details are not deleted");
		}
		return centerResponse;
	}
	
}
