package com.capgemini.mywebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idVal = req.getParameter("id");

		// Get the context-param
		// ServletContext context = getServletContext();
		ServletContext context = req.getServletContext();// Both are same.......
		String contextParamVal = context.getInitParameter("myContextParam");

		// Get the Init-param
		ServletConfig config = getServletConfig();
		String configParamVal = config.getInitParameter("myConfigParam");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Employee Id = " + idVal);
		out.println("<br>Name = Bhavana");
		out.println("<br>Salary = 25000");
		out.println("<br><br>Context Param value= " + contextParamVal);
		out.println("<br><br>Context Param value= "+configParamVal);
		out.println("</body>");
		out.println("</html>");

	}// end of the doGet()

}// end of the class
