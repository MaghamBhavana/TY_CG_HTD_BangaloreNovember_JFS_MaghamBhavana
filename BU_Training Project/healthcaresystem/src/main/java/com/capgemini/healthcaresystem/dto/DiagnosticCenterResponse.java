package com.capgemini.healthcaresystem.dto;

import java.util.List;

import lombok.Data;

@Data
public class DiagnosticCenterResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<DiagnosticCenter> center;
}
