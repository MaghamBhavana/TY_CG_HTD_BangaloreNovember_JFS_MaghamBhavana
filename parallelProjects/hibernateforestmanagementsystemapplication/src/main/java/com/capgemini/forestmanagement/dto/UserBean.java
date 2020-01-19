package com.capgemini.forestmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name="user")
public class UserBean {
	@Id
	@Column
	private String email;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String role;
	@Column
	private String name;
	@Column(nullable=false,unique=true)
	private int id;
	@Column
	private long phoneNumber;
	

}
