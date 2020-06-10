package com.capgemini.healthcaresystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "Test")
public class Test {
	
	@Id
	@Column
	private int testId;
	@Column(nullable=false,unique=true)
	private String testName;
	@Column
	private String centerId;
}
