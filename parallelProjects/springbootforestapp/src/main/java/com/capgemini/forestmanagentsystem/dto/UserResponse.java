package com.capgemini.forestmanagentsystem.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserResponse {
	private int status;
	private String message;
	private String description;
	private List<UserBean> manager;

}
