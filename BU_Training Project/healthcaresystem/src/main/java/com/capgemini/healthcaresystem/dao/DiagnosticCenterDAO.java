package com.capgemini.healthcaresystem.dao;

import java.util.List;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;

public interface DiagnosticCenterDAO {
	
	boolean addCenter(DiagnosticCenter center);
	
	boolean removeCenter(String centerId);
	
	List<DiagnosticCenter> getAllCenters();

}
