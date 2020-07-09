package com.lee.jm2.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class Coach {
	public static void calculate(HttpServletRequest request) {
		int tasu = Integer.parseInt(request.getParameter("tasu"));
		int anta = Integer.parseInt(request.getParameter("anta"));
		double tayul = anta / (double) tasu;
		String tayul2 = String.format("%.3f", tayul);
		String tayul3 = String.format("%s�� %sǬ %s��", tayul2.charAt(2), tayul2.charAt(3), tayul2.charAt(4));
		if(tasu == anta) {
			tayul3 = "10��";
		}
		String img = "c.jpg";
		if (tayul >= 0.3) {
			img = "c2.jpg";
		}
		Result r = new Result(tasu, anta, tayul3, img);
		request.setAttribute("r", r);
		
		int a = 123;
		request.setAttribute("aa", a);
		
		Dog d = new Dog("�ǻ�", 2);
		request.setAttribute("dd", d);
		
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog("�ѻ�", 1));
		dogs.add(new Dog("�߻�", 2));
		dogs.add(new Dog("����", 3));
		request.setAttribute("ds", dogs);
	}
}
