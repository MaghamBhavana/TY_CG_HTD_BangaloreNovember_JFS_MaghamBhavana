package com.capgemini.empdetails.service;

import java.util.List;

import com.capgemini.empdetails.dto.Employee;

public interface EmpService {
	boolean addEmp(Employee emp);

	boolean deleteEmp(int empId);

	boolean updateEmp(int empId, Employee emp);

	List<Employee> getAllEmp();

	Employee getEmp(int empId);
}
