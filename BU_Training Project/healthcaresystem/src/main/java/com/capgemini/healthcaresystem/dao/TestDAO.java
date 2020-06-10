package com.capgemini.healthcaresystem.dao;

import java.util.List;

import com.capgemini.healthcaresystem.dto.Test;

public interface TestDAO {

	boolean addTest(Test test);

	boolean removeTest(int testId);

	List<Test> getAllTests();
	

}
