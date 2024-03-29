package com.capgemini.mywebapp.service;

import java.util.List;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;

public interface EmployeeService {
	
	public EmployeeInfoBean searchEmployee(int empId);
	public EmployeeInfoBean authenticate(int empid, String password);
	public boolean deleteEmployee(int empId);
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean);
	public List<EmployeeInfoBean> getAllEmployees();
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean);

}
