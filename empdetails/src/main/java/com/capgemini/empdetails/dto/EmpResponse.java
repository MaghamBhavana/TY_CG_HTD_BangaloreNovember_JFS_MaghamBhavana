package com.capgemini.empdetails.dto;

import java.util.List;

import lombok.Data;

@Data
public class EmpResponse {
	private int status;
	private String message;
	private String description;
	private List<Employee> emp;
}
