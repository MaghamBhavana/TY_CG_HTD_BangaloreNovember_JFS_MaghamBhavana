package com.capgemini.forestmanagentsystem.dto;

import java.util.List;

import lombok.Data;

@Data
public class HaulierResponse {
	private int status;
	private String message;
	private String description;
	private List<HaulierBean> haulier;

}
