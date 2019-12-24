package com.capgemini.mywebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {

	private EmployeeService service = new EmployeeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		if (session != null) {
			// valid session
			int empId = Integer.parseInt(req.getParameter("empId"));

			if (service.deleteEmployee(empId)) {
				out.print("<h3 style='color: red'>Employee Record for " + empId + " Deleted!</h3>");
			} else {
				out.print("<h3 style='color: red'>Employee Record for " + empId + " not found!</h3>");
			}

			req.getRequestDispatcher("./DeleteEmployee.html").include(req, resp);
		} else {
			// Invalid session
			out.println("Please Login First");
			req.getRequestDispatcher("./LoginPage.html").include(req, resp);
		}
		out.print("</body>");
		out.print("</html>");
	}

}
