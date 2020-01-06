package com.capgemini.forestmanagement.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class ManagerBean implements Serializable {
	private String username;
	private String password;

}
