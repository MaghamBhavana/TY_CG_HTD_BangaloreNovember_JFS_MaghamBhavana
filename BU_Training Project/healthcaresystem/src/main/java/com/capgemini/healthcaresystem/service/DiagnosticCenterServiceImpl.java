package com.capgemini.healthcaresystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.DiagnosticCenterDAO;
import com.capgemini.healthcaresystem.dto.DiagnosticCenter;

@Service
public class DiagnosticCenterServiceImpl implements DiagnosticCenterService {

	@Autowired
	private DiagnosticCenterDAO dao;
	
	@Override
	public boolean addCenter(DiagnosticCenter center) {
		// TODO Auto-generated method stub
		return dao.addCenter(center);
	}

	@Override
	public boolean removeCenter(String centerId) {
		// TODO Auto-generated method stub
		return dao.removeCenter(centerId);
	}

	@Override
	public List<DiagnosticCenter> getAllCenters() {
		// TODO Auto-generated method stub
		return dao.getAllCenters();
	}
}
