package com.capgemini.mywebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		if(session != null) {
			session.invalidate();
			out.print("<h3 style='color: red'>You are Successfully Logged out</h3>");
			} else {
				out.print("<h3 style='color: red'>You are already Logged out</h3>");	
			}
		out.print("</body>");
		out.print("</html>");
		
		req.getRequestDispatcher("./LoginPage.html").include(req, resp);
	}

}
