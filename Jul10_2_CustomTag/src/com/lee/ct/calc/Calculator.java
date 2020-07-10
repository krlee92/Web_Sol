package com.lee.ct.calc;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	public static void calculate(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = x + y;
		
		request.setAttribute("z", z);
	}
}
