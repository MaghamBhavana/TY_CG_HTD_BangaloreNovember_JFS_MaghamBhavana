package com.capgemini.empdetails.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "emp_info")
public class Employee {
	@Id
	@Column
	private int empId;
	@Column(nullable = false)
	private String empName;
	@Column(nullable = false)
	private int salary;
	
}
