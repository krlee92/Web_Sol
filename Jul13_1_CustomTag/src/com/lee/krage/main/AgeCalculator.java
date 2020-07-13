package com.lee.krage.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class AgeCalculator {
	public static void calc(HttpServletRequest request) {
		int birthYear = Integer.parseInt(request.getParameter("birthYear"));
		
		
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String curYear = sdf.format(now);
		int curYear2 = Integer.parseInt(curYear);
		
		int age = curYear2 - birthYear + 1;
		request.setAttribute("age", age);
		
		int[] ar = {1, 231, 45, 234, 12};
		request.setAttribute("ar", ar);
		
		ArrayList<Menu> menus = new ArrayList<Menu>();
		menus.add(new Menu("����", 5000));
		menus.add(new Menu("�Ұ�ⵤ��", 6000));
		menus.add(new Menu("����", 7000));
		menus.add(new Menu("��ġ����", 5000));
		request.setAttribute("ms", menus);
		

	}
}
