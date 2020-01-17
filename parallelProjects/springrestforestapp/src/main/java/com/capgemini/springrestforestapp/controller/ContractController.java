package com.capgemini.springrestforestapp.controller;

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

import com.capgemini.springrestforestapp.dto.ContractBean;
import com.capgemini.springrestforestapp.dto.ContractResponse;
import com.capgemini.springrestforestapp.service.ContractService;

@CrossOrigin(origins = "*",allowedHeaders = "*",allowCredentials = "true")
@RestController
//@RequestMapping("/contract")
public class ContractController {
	
	@Autowired
	ContractService service;
	
	@PostMapping(path = "/add-contract", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponse addContract(@RequestBody ContractBean contractBean) {
		ContractResponse response = new ContractResponse();
		if (service.addContract(contractBean)) {
			response.setStatus(201);
			response.setMessage("Success");
			response.setDescription("Contract is added successfully");
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("This contract is already exists, please create new contract");
		}
		return response;
	}
	@GetMapping(path = "/get-allcontracts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponse getAllContracts() {
		ContractResponse response = new ContractResponse();
		List<ContractBean> list = service.getAllContracts();
		if (list.size() != 0) {
			response.setStatus(201);
			response.setMessage("Success");
			response.setDescription("You got all the contract details");
			response.setContract(list);
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("No data is present");
		}
		return response;
		
	}

	@GetMapping(path = "/get-contract/{contractNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponse getContract(@PathVariable("contractNo") int contractNo) {
		ContractResponse response = new ContractResponse();
		ContractBean contractBean = service.getContract(contractNo);
		if (contractBean != null) {
			response.setStatus(201);
			response.setMessage("Success");
			response.setDescription("You found the contract details");
			response.setContract(Arrays.asList(contractBean));
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("No contract present with this number");
		}
		return response;
	}
	
	
	@DeleteMapping(path = "/delete-contract/{contractNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponse deleteContract(@PathVariable("contractNo") int contractNo) {
		ContractResponse response = new ContractResponse();
		if (service.deleteContract(contractNo)) {
			response.setStatus(201);
			response.setMessage("Success");
			response.setDescription("Contract is deleted successfully");
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("Contract not found");
		}
		return response;
	}
	
	@PutMapping(path = "/update-contract", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponse updateContract(@RequestBody ContractBean contract) {
		ContractResponse response = new ContractResponse();
		if (service.updateContract(contract)) {
			response.setStatus(201);
			response.setMessage("Success");
			response.setDescription("Contract details updated");
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("Contract not found");
		}
		return response;
	}

}
