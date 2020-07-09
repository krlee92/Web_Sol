package com.lee.jm2.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	public static void calc(HttpServletRequest request) {
		int m = Integer.parseInt(request.getParameter("money"));
		int t = Integer.parseInt(request.getParameter("tomorrow"));
		int ∞≈Ω∫∏ßµ∑ = m - t;
		int remain = ∞≈Ω∫∏ßµ∑; 
		int »≠∆Û = 50000;
		int ∞πºˆ = 0;
		boolean Ω√¿€¿ª5∑Œ = true;
		ArrayList<String> al = new ArrayList<String>();
		while (true) {
			if (∞≈Ω∫∏ßµ∑ >= »≠∆Û) {
				∞πºˆ = ∞≈Ω∫∏ßµ∑ / »≠∆Û;
				al.add(String.format("%dø¯ ¬•∏Æ - %d", »≠∆Û, ∞πºˆ));
				∞≈Ω∫∏ßµ∑ %= »≠∆Û;
			}
			if (Ω√¿€¿ª5∑Œ) {
				»≠∆Û /= 5;
			} else {
				»≠∆Û /= 2;
			}
			Ω√¿€¿ª5∑Œ = !Ω√¿€¿ª5∑Œ;
			if (»≠∆Û == 5) {
				break;
			}
		}
		Result r = new Result(m, t, remain, al);
		request.setAttribute("r", r);
	}
}
