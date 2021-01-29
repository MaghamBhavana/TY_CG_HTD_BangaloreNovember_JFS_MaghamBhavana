package com.capgemini.empdetails.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.empdetails.dao.EmpDAO;
import com.capgemini.empdetails.dto.Employee;


@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDAO dao;

	@Override
	public boolean addEmp(Employee emp) {
	
		return dao.addEmp(emp);
	}

	@Override
	public boolean deleteEmp(int empId) {

		return dao.deleteEmp(empId);
	}

	@Override
	public boolean updateEmp(int empId, Employee emp) {

		return dao.updateEmp(empId, emp);
	}

	@Override
	public List<Employee> getAllEmp() {

		return dao.getAllEmp();
	}

	@Override
	public Employee getEmp(int empId) {

		return dao.getEmp(empId);
	}

}