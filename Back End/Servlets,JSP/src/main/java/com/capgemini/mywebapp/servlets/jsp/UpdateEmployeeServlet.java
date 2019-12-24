package com.capgemini.mywebapp.servlets.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;

@WebServlet("/updateEmpJsp2")
public class UpdateEmployeeServlet extends HttpServlet {
	private EmployeeService service = new EmployeeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null) {
			//valid session
			//Get the Form Data
			int empId = Integer.parseInt(req.getParameter("empId"));
			String name = req.getParameter("name");
			String age=req.getParameter("age");
			String salary=req.getParameter("salary");
			String designation = req.getParameter("designation");
			String password = req.getParameter("password");
			
			EmployeeInfoBean employeeInfoBean = new EmployeeInfoBean();
			employeeInfoBean.setEmpId(empId);
			employeeInfoBean.setName(name);
			if(age != null && !age.isEmpty()) {
				int age1 = Integer.parseInt(age);
				employeeInfoBean.setAge(age1);
			}
			if(salary != null && !salary.isEmpty()) {
				double salary1 = Double.parseDouble(salary);
				employeeInfoBean.setSalary(salary1);
			}
			employeeInfoBean.setDesignation(designation);
			employeeInfoBean.setPassword(password);
			
			boolean isUpdated = service.updateEmployee(employeeInfoBean);
			if(isUpdated) {
				req.setAttribute("msg", "Employee details updated");
			} else {
				req.setAttribute("msg", "Employee dtails is not updated");
			}
			req.getRequestDispatcher("./updateEmpJspForm.jsp").forward(req, resp);
			
		} else {
			//Invalid session
			req.setAttribute("msg", "Please, Login First");
			req.getRequestDispatcher("./loginform").forward(req, resp);
		}
	}

}
