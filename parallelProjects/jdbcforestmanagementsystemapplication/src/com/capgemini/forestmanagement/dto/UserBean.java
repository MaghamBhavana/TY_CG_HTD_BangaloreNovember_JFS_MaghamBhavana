package com.capgemini.forestmanagement.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserBean implements Serializable {
	private int id;
	private String email;
	private String password;
	private String role;
	private String name;
	private Long phoneNumber;

}
