package com.capgemini.mywebapp.service;

import java.util.List;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.dao.EmployeeDAOImpl;
import com.capgemini.mywebapp.dao.EmployeeDao;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao dao = new EmployeeDAOImpl();

	@Override
	public EmployeeInfoBean searchEmployee(int empId) {

		return dao.searchEmployee(empId);
		
	}// End of searchEmployee

	@Override
	public EmployeeInfoBean authenticate(int empid, String password) {

		return dao.authenticate(empid, password);
	}

	@Override
	public boolean deleteEmployee(int empId) {
		
		return dao.deleteEmployee(empId);
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		
		return dao.addEmployee(employeeInfoBean);
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {

		return dao.getAllEmployees();
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		
		return dao.updateEmployee(employeeInfoBean);
	}

}// End of class
