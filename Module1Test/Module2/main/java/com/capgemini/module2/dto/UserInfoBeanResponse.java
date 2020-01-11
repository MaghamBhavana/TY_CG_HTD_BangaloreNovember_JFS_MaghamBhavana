package com.capgemini.module2.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserInfoBeanResponse {
	
	private int statusCode;
	private String message;
	private String description;
	private List<UserInfoBean> user;

}
