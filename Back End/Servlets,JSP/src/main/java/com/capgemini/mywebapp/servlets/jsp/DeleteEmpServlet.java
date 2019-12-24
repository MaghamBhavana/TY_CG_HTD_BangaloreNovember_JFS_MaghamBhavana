package com.capgemini.mywebapp.servlets.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;

@WebServlet("/deleteEmployee2")
public class DeleteEmpServlet extends HttpServlet {
	private EmployeeService service = new EmployeeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		if (session != null) {
			//valid session
			int empId = Integer.parseInt(req.getParameter("empId"));
			
			boolean isDeleted = service.deleteEmployee(empId);
			if (isDeleted) {
				req.setAttribute("msg", "Succesfully deleted");
			} else {
				req.setAttribute("msg", "Unable to delete the Employee");
			}
			req.getRequestDispatcher("./DeleteEmpjsp.jsp").forward(req, resp);
		} else {
			// Invalid session
			req.setAttribute("msg", "Please, logIn first");
			req.getRequestDispatcher("./loginform").forward(req, resp);
		}
	}

}
