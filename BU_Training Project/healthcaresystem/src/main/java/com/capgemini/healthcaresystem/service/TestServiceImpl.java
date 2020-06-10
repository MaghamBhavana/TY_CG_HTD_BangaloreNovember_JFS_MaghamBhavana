package com.capgemini.healthcaresystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.TestDAO;
import com.capgemini.healthcaresystem.dto.Test;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDAO dao;
	
	@Override
	public boolean addTest(Test test) {
		// TODO Auto-generated method stub
		return dao.addTest(test);
	}

	@Override
	public boolean removeTest(int testId) {
		// TODO Auto-generated method stub
		return dao.removeTest(testId);
	}

	@Override
	public List<Test> getAllTests() {
		// TODO Auto-generated method stub
		return dao.getAllTests();
	}

}
