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

import com.capgemini.springrestforestapp.dto.HaulierBean;
import com.capgemini.springrestforestapp.dto.HaulierResponse;
import com.capgemini.springrestforestapp.service.HaulierService;

@CrossOrigin(origins = "*",allowedHeaders = "*",allowCredentials = "true")
@RestController
public class HaulierController {
	
	@Autowired
	HaulierService service;
	
	@PostMapping(path = "/add-haulier", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HaulierResponse addHaulier(@RequestBody HaulierBean haulierBean) {
		HaulierResponse response = new HaulierResponse();
		if (service.addHauiler(haulierBean)) {
			response.setStatus(201);
			response.setMessage("Success");
			response.setDescription("Haulier is added successfully");
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("This haulier is already exists");
		}
		return response;
	}
	
	@GetMapping(path = "/get-allhauliers", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaulierResponse getAllHauliers() {
		HaulierResponse response = new HaulierResponse();
		List<HaulierBean> list = service.getAllHauliers();
		if (list.size() != 0) {
			response.setStatus(201);
			response.setMessage("Success");
			response.setDescription("You got all the haulier details");
			response.setHaulier(list);
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("No data is present");
		}
		return response;
		
	}
	

	@GetMapping(path = "/get-haulier/{haulierId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaulierResponse getHaulier(@PathVariable("haulierId") int haulierId) {
		HaulierResponse response = new HaulierResponse();
		HaulierBean haulierBean = service.getHaulier(haulierId);
		if ( haulierBean != null) {
			response.setStatus(201);
			response.setMessage("Success");
			response.setDescription("You found the haulier details");
			response.setHaulier(Arrays.asList( haulierBean));
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("No haulier present with this Id");
		}
		return response;
	}
	
	@DeleteMapping(path = "/delete-haulier/{haulierId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaulierResponse deleteHaulier(@PathVariable("haulierId") int haulierId) {
		HaulierResponse response = new HaulierResponse();
		if (service.deleteHaulier(haulierId)) {
			response.setStatus(201);
			response.setMessage("Success");
			response.setDescription("Haulier is deleted successfully");
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("Haulier not found");
		}
		return response;
	}
	
	@PutMapping(path = "/update-haulier", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HaulierResponse updateHaulier(@RequestBody HaulierBean haulier) {
		HaulierResponse response = new HaulierResponse();
		if (service.updateHaulier(haulier)) {
			response.setStatus(201);
			response.setMessage("Success");
			response.setDescription("Haulier details updated");
		} else {
			response.setStatus(401);
			response.setMessage("Failure");
			response.setDescription("Haulier not found");
		}
		return response;
	}
	

}
