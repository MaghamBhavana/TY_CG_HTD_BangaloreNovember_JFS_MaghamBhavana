package com.capgemini.mywebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createCookie")
public class CreateCookieServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Create a Cookie
		Cookie myCookie = new Cookie("empName", "Bhavana");
		resp.addCookie(myCookie);
		myCookie.setMaxAge(7 * 24 * 60 * 60);
		PrintWriter out = resp.getWriter();
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cookiePage.html");
		requestDispatcher.include(req, resp);
		
		resp.setContentType("text/html");
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Cookie created Successfully....</h2>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	

}
