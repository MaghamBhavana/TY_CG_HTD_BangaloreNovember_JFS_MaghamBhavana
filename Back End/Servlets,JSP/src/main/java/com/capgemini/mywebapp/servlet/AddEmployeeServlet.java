package com.capgemini.mywebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
	
	EmployeeService service = new EmployeeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		if(session != null)
		{
			//valid session
			int empId = Integer.parseInt(req.getParameter("empId"));
			String name = req.getParameter("name");
			int age = Integer.parseInt(req.getParameter("age"));
			double salary = Double.parseDouble(req.getParameter("salary"));
			String designation = req.getParameter("designation");
			String password = req.getParameter("password");
			
			EmployeeInfoBean employeeInfoBean = new EmployeeInfoBean();
			employeeInfoBean.setEmpId(empId);
			employeeInfoBean.setName(name);
			employeeInfoBean.setAge(age);
			employeeInfoBean.setSalary(salary);
			employeeInfoBean.setDesignation(designation);
			employeeInfoBean.setPassword(password);
			
			boolean isAdded=service.addEmployee(employeeInfoBean);
			if(isAdded) {
				out.print("<h2 style='color: green'> Employee Added successfully--</h2>");
			} else {
				out.print("<h2 style='color: green'> Unable to Add Employee--</h2>");
			}
		} else {
			//Invalid session
			out.println("Please Login First");
			req.getRequestDispatcher("./LoginPage.html").include(req, resp);
		}
		out.print("</body>");
		out.print("</html>");
		
	}

}
