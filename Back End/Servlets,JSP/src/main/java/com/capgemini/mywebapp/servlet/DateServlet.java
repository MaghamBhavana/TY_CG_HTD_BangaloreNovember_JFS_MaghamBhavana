package com.capgemini.mywebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Current System Date & Time
		Date date = new Date();
		
		//Get the Context-param
		ServletContext context = getServletContext();
		String contextParamVal = context.getInitParameter("myContextParam");
		
		//Get the Init-param
		ServletConfig config = getServletConfig();
		String configParamVal = config.getInitParameter("myConfigParam");
		
		resp.setContentType("text/html");
		resp.setHeader("refresh", "1");
		
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<h2>Current System Date & Time---<br> "+date+"</h2>");
		out.println("<br><br>Context Param value= "+contextParamVal);
		out.println("<br><br>Context Param value= "+configParamVal);
		out.print("</html>");
		
	}// End of doGet()

}// End of class
