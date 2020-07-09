package com.lee.jm2.main;

import javax.servlet.http.HttpServletRequest;

// M(Model)
//		계산 여기서

public class M {
	public static void calculate(HttpServletRequest request) {
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		int c = a + b;
		
		request.setAttribute("ccc", c);
		
	}
}
