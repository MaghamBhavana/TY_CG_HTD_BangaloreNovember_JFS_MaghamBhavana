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

@WebServlet("/searchEmployee2")
public class SearchEmployeeServlet2 extends HttpServlet {

	private EmployeeService service = new EmployeeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);//to validate the session
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (session != null) {
			// validate the session
			String empIdVal = req.getParameter("empId");
			int empId = Integer.parseInt(empIdVal);

			EmployeeInfoBean employeeInfoBean = service.searchEmployee(empId);
			if (employeeInfoBean != null) {
				out.println("<h3>Employee Id " + empId + " found--</h3>");
				out.println("Name = " + employeeInfoBean.getName());
				out.println("<br>Age = " + employeeInfoBean.getAge());
				out.println("<br>Salary = " + employeeInfoBean.getSalary());
				out.println("<br>Designation = " + employeeInfoBean.getDesignation());
			} else {
				out.print("<h3 style='colour: red'>EmployeeId" + empId + " Not found--</h3>");
			}
		} else {
			// Invalid the session
			out.println("Please Login First");
			req.getRequestDispatcher("./LoginPage.html").include(req, resp);
		}
		out.print("</body>");
		out.print("</html>");
	}

}
