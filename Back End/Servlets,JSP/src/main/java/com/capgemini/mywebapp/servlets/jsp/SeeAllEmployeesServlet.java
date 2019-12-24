package com.capgemini.mywebapp.servlets.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeService;
import com.capgemini.mywebapp.service.EmployeeServiceImpl;

@WebServlet("/seeAllEmployees")
public class SeeAllEmployeesServlet extends HttpServlet {
	private EmployeeService service = new EmployeeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null) {
			//valid session
			List<EmployeeInfoBean> list = service.getAllEmployees();
			if(list != null && !list.isEmpty()) {
				req.setAttribute("employeelist", list);
			} else {
				req.setAttribute("msg", "Not records found in list");
				
			}
			req.getRequestDispatcher("./seeAllEmployeeJsp.jsp").forward(req, resp);
			
		} else {
			//Invalid session
			req.setAttribute("msg", "Please, logIn first");
			req.getRequestDispatcher("./loginform").forward(req, resp);
		}
	}
}
