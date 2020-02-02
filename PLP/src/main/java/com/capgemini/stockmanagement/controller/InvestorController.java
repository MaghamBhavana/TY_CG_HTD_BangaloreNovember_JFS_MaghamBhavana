package com.capgemini.stockmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.stockmanagement.dto.InvestorRequestObject;
import com.capgemini.stockmanagement.dto.InvestorResponse;
import com.capgemini.stockmanagement.service.InvestorService;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class InvestorController {

	@Autowired
	InvestorService service;

	@PostMapping(path = "/add-share", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public InvestorResponse addShare(@RequestBody InvestorRequestObject investor) {
		InvestorResponse investorResponse = new InvestorResponse();
		if (service.addShare(investor)) {
			investorResponse.setStatusCode(201);
			investorResponse.setMessage("Success");
			investorResponse.setDescription("Successfully... Shares are bought");
		} else {
			investorResponse.setStatusCode(401);
			investorResponse.setMessage("Failure");
			investorResponse.setDescription("Something went wrong in buying shares");
		}
		return investorResponse;
	}

	@PutMapping(path = "/buy-share", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public InvestorResponse updateCompanyBuy(InvestorRequestObject investor) {
		InvestorResponse investorResponse = new InvestorResponse();
		if (service.buyShare(investor)) {
			investorResponse.setStatusCode(201);
			investorResponse.setMessage("Success");
			investorResponse.setDescription("Successfully... Shares are bought");
		} else {
			investorResponse.setStatusCode(401);
			investorResponse.setMessage("Failure");
			investorResponse.setDescription("Something went wrong in buying shares");
		}
		return investorResponse;
	}

	@PutMapping(path = "/sell-share", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public InvestorResponse updateCompanySell(InvestorRequestObject investor) {
		InvestorResponse investorResponse = new InvestorResponse();
		if (service.sellShare(investor)) {
			investorResponse.setStatusCode(201);
			investorResponse.setMessage("Success");
			investorResponse.setDescription("Successfully... Shares are sold");
		} else {
			investorResponse.setStatusCode(401);
			investorResponse.setMessage("Failure");
			investorResponse.setDescription("Something went wrong in buying shares");
		}
		return investorResponse;
	}

	// @PutMapping(path = "/update-avalishare", produces =
	// MediaType.APPLICATION_JSON_VALUE, consumes =
	// MediaType.APPLICATION_JSON_VALUE)
	// public InvestorRequestObject updateCompany() {
	// InvestorRequestObject response = new InvestorRequestObject();
	// if (service.updateStockAvailability(value, flag)) {
	//
	// } else {
	//
	// }
	// return response;
	// }
}
