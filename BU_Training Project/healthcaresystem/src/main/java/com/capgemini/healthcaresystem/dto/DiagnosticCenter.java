package com.capgemini.healthcaresystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Centers_Info")
public class DiagnosticCenter {

	@Id
	@Column
	private String centerId;
	@Column(nullable=false,unique=true)
	private String centerName;
	@Column
	private String emailId;
	
}
