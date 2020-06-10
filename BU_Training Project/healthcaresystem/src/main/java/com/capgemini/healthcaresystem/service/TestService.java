package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.dto.Test;

public interface TestService {
	
	boolean addTest(Test test);

	boolean removeTest(int testId);

	List<Test> getAllTests();


}
