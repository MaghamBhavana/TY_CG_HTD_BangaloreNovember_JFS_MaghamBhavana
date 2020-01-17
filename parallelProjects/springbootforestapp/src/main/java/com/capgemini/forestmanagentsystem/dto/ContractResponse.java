package com.capgemini.forestmanagentsystem.dto;

import java.util.List;

import lombok.Data;

@Data
public class ContractResponse {
	private int status;
	private String message;
	private String description;
	private List<ContractBean> contract;

}
