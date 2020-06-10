package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;

public interface DiagnosticCenterService {

boolean addCenter(DiagnosticCenter center);
	
	boolean removeCenter(String centerId);
	
	List<DiagnosticCenter> getAllCenters();
}
