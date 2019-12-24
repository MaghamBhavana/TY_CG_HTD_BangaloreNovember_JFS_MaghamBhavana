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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private EmployeeService service = new EmployeeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get the Form data
		String empIdVal = req.getParameter("empId");
		String password = req.getParameter("password");
		
		int empId = Integer.parseInt(empIdVal);
		
		EmployeeInfoBean employeeInfoBean = service.authenticate(empId, password);
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(employeeInfoBean != null) {
			//valid Credentials
			HttpSession session = req.getSession(true);//Create the new session.
			session.setAttribute("employeeInfoBean", employeeInfoBean);
			
			out.println("<h2 style='color: blue'>Welcome "+employeeInfoBean.getName()+"!</h3>");
			out.println("<br><a href='./addEmployee.html'>Add Employee</a>");
			out.println("<br><a href='#'>Update Employee</a>");
			out.println("<br><a href='./searchEmp.html'>Serach Employee</a>");
			out.println("<br><a href='./DeleteEmployee.html'>Delete Employee</a>");
			out.println("<br><a href='#'>See All Employee</a>");
			out.println("<br><br><a href='./Logout'>Logout</a>");
		} else {
			//Invalid Credentials
			out.println("<h3 style='color: red'>Invalid Credentials</h3>");
			req.getRequestDispatcher("./LoginPage.html").include(req, resp);
		}
		out.print("<body>");
		out.print("<html>");
		
		
	}//End of doPost
}//End of class
