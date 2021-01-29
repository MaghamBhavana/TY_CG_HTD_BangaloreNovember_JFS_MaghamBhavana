package com.capgemini.empdetails.dao;

import java.util.List;

import com.capgemini.empdetails.dto.Employee;

public interface EmpDAO {

	boolean addEmp(Employee emp);

	boolean deleteEmp(int empId);

	boolean updateEmp(int empId, Employee emp);

	List<Employee> getAllEmp();

	Employee getEmp(int empId);
}
