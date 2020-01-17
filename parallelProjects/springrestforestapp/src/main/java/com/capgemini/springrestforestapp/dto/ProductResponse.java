package com.capgemini.springrestforestapp.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProductResponse {

	private int status;
	private String message;
	private String description;
	private List<ProductBean> product;

}
