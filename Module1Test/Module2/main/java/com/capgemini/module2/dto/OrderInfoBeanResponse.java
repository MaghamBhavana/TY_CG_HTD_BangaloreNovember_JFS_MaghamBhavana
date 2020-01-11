package com.capgemini.module2.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderInfoBeanResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<OrderInfoBean> order;
}
