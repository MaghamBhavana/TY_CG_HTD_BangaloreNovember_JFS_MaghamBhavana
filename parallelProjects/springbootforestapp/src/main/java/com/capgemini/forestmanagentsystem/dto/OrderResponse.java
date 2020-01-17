package com.capgemini.forestmanagentsystem.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderResponse {
	private int status;
	private String message;
	private String description;
	private List<OrderBean> order;

}
