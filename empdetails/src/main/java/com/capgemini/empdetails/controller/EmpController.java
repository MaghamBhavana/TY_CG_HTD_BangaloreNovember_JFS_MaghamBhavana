package com.capgemini.empdetails.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.empdetails.dto.EmpResponse;
import com.capgemini.empdetails.dto.Employee;
import com.capgemini.empdetails.service.EmpService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class EmpController {

	@Autowired
	EmpService service;

	@PostMapping(path = "/add-emp", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmpResponse addEmp(@RequestBody Employee emp) {
		EmpResponse empResponse = new EmpResponse();
		if (service.addEmp(emp)) {
			empResponse.setStatus(201);
			empResponse.setMessage("Success");
			empResponse.setDescription("Successfully..Emp details added");
		} else {
			empResponse.setStatus(401);
			empResponse.setMessage("Failure");
			empResponse.setDescription("Emp details already exists");
		}
		return empResponse;
	}

	@GetMapping(path = "/get-all-emp", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmpResponse getAllEmp() {
		EmpResponse empResponse = new EmpResponse();
		List<Employee> list = service.getAllEmp();
		if (list.size() != 0) {
			empResponse.setStatus(201);
			empResponse.setMessage("Success");
			empResponse.setDescription("Successfully found your Emp");
			empResponse.setEmp(list);
		} else {
			empResponse.setStatus(401);
			empResponse.setMessage("Failure");
			empResponse.setDescription("No Emp are found");
		}
		return empResponse;
	}

	@GetMapping(path = "/get-emp/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmpResponse getEmp(@PathVariable("empId") int empId) {
		EmpResponse empResponse = new EmpResponse();
		Employee emp = service.getEmp(empId);
		if (emp != null) {
			empResponse.setStatus(201);
			empResponse.setMessage("Success");
			empResponse.setDescription("Emp is found");
			empResponse.setEmp(Arrays.asList(emp));
		} else {
			empResponse.setStatus(401);
			empResponse.setMessage("Failure");
			empResponse.setDescription("This Emp doesn't exist");
		}
		return empResponse;
	}

	@DeleteMapping(path = "/delete-emp/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmpResponse deleteEmp(@PathVariable("empId") int empId) {
		EmpResponse empResponse = new EmpResponse();
		if (service.deleteEmp(empId)) {
			empResponse.setStatus(201);
			empResponse.setMessage("Success");
			empResponse.setDescription("Emp details deleted");
		} else {
			empResponse.setStatus(401);
			empResponse.setMessage("Failure");
			empResponse.setDescription("Emp Details are not deleted");
		}
		return empResponse;
	}

	@PutMapping(path = "/update-emp/{empId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmpResponse updateEmp(@PathVariable("empId") int empId, @RequestBody Employee emp) {
		EmpResponse response = new EmpResponse();
		if (service.updateEmp(empId, emp)) {
			response.setStatus(201);
			response.setMessage("Success");
			response.setDescription("Emp details are updated successfully");
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("Emp details are not updated");
		}
		return response;

	}
}
