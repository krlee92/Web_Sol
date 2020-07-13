package com.lee.jstl.formatting;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DataMaker {
	public static void make(HttpServletRequest request) {
		
		int a = 123456789;
		request.setAttribute("a", a);
		
		double b = 0.4556;
		request.setAttribute("b", b);
		
		double c = 12354354.12312341;
		request.setAttribute("c", c);
		
		
		Date d = new Date();
		request.setAttribute("d", d);
		
		ArrayList<Snack> snacks = new ArrayList<Snack>();
		snacks.add(new Snack("새우깡", 10000, new Date()));
		snacks.add(new Snack("양파링", 13000, new Date()));
		snacks.add(new Snack("포카칩", 25000, new Date()));
		request.setAttribute("snacks", snacks);
		
	}
}
