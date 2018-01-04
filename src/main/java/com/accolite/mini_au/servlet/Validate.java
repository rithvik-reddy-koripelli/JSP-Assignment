package com.accolite.mini_au.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validate extends HttpServlet{
	
	public static Pattern  valid_email = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
			/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		boolean valid = valid_email.matcher(email).find();
		String ans;
		if (valid)
			ans = "Valid";
		else
			ans = "Invalid";
		req.setAttribute("result", ans);
		req.getRequestDispatcher("/WEB-INF/result.jsp").forward(req, resp);
		
	}
}
