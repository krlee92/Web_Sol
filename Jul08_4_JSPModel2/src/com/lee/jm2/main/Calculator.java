package com.lee.jm2.main;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	
	public static void gogo(HttpServletRequest request) { // ��û ��ü
		
		int m = Integer.parseInt(request.getParameter("money"));
		int t = Integer.parseInt(request.getParameter("tomorrow"));
		int remain = m - t;
		
		String say = "��������";
		if (remain > 50000) {
			say = "�����ֵ� ��";
		}
		Result r = new Result(m, t, remain, say);
		request.setAttribute("rrr", r);
		
		
	}

}
