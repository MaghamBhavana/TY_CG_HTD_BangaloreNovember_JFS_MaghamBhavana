package com.capgemini.springrestforestapp.dto;

import java.util.List;

import lombok.Data;

@Data
public class CustomerResponse {
	
	private int status;
	private String message;
	private String description;
	private List<CustomerBean> customer;

}
