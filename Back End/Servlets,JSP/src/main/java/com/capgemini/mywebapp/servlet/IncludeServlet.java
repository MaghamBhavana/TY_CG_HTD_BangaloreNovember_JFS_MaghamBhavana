package com.capgemini.mywebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include")
public class IncludeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String url="./currentDate";
		 
		 resp.setContentType("text/html");
		 PrintWriter out = resp.getWriter();
		 out.print("<html>");
		 out.print("<body>");
		 out.print("<h2>Hello User</h2>");
		 out.print("</body>");
		 out.print("</html>");
		 
		 RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
		 requestDispatcher.include(req, resp);
		 
		 out.print("<br><h2>Thank You</h2>");
		 out.print("</body>");
		 out.print("</html>");
		 
		 
		 
	}

}
