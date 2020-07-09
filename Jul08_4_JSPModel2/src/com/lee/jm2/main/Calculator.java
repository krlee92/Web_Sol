package com.lee.jm2.main;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	
	public static void gogo(HttpServletRequest request) { // 요청 객체
		
		int m = Integer.parseInt(request.getParameter("money"));
		int t = Integer.parseInt(request.getParameter("tomorrow"));
		int remain = m - t;
		
		String say = "연락차단";
		if (remain > 50000) {
			say = "다음주도 콜";
		}
		Result r = new Result(m, t, remain, say);
		request.setAttribute("rrr", r);
		
		
	}

}
