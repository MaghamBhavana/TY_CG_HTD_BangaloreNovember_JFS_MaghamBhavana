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

import com.capgemini.healthcaresystem.dto.Test;
import com.capgemini.healthcaresystem.dto.TestResponse;
import com.capgemini.healthcaresystem.service.TestService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class TestController {

	@Autowired
	TestService service;
	
	@PostMapping(path = "/add-test", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse addTest(@RequestBody Test test) {
		TestResponse testResponse = new TestResponse();
		if (service.addTest(test)) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription("Successfully..Test details is added");
		} else {
			testResponse.setStatusCode(401);
			testResponse.setMessage("Failure");
			testResponse.setDescription("Test is already exists");
		}
		return testResponse;
	}
	
	@GetMapping(path = "/get-all-tests", produces = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse viewAllTests() {
		TestResponse testResponse = new TestResponse();
		List<Test> list = service.getAllTests();
		if (list.size() != 0) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription("Successfully found your tests");
			testResponse.setTest(list);
		} else {
			testResponse.setStatusCode(401);
			testResponse.setMessage("Failure");
			testResponse.setDescription("No tests are found");
		}
		return testResponse;
	}
	
	
	@DeleteMapping(path = "/delete-test/{testId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse deleteTest(@PathVariable("testId") int testId) {
		TestResponse testResponse = new TestResponse();
		if (service.removeTest(testId)) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription("Test details deleted");
		} else {
			testResponse.setStatusCode(401);
			testResponse.setMessage("Failure");
			testResponse.setDescription("Test Details are not deleted");
		}
		return testResponse;
	}
	
	

}
