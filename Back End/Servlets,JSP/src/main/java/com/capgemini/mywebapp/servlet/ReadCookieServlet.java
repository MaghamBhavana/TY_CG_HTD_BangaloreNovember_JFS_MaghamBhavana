package com.capgemini.mywebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readCookie")
public class ReadCookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get the Cookies
		Cookie[] cookies = req.getCookies();

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		req.getRequestDispatcher("./cookiePage.html").include(req, resp);

		out.print("<html>");
		out.print("<body>");
		if (cookies != null) {

			for (Cookie cookie : cookies) {
				out.print("<br><br>Cookie Name= " + cookie.getName());
				out.print("<br>Cookie Value= " + cookie.getValue());
			}
		} else {
			out.print("<br><h2>Cookies not Found..</h2>");
		}
		out.print("</body>");
		out.print("</html>");

	}

}
