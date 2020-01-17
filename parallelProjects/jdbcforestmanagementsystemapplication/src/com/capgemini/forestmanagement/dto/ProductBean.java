package com.capgemini.forestmanagement.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductBean implements Serializable {
	
	private int productId;
	private String productName;
	private double cost;
	
}
