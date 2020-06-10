package com.capgemini.healthcaresystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "User_Info")
public class User {
	
	@Id
	@Column
	private int userId;
	@Column
	private String userPassword;
	@Column(nullable=false)
	private String userName;
	@Column(nullable=false,unique=true)
	private long contactNo;
	@Column
	private String userRole;
	@Column(nullable=false,unique=true)
	private String emailId;
	
}
