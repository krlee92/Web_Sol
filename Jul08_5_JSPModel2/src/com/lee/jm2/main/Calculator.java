package com.lee.jm2.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	public static void calc(HttpServletRequest request) {
		int m = Integer.parseInt(request.getParameter("money"));
		int t = Integer.parseInt(request.getParameter("tomorrow"));
		int �Ž����� = m - t;
		int remain = �Ž�����; 
		int ȭ�� = 50000;
		int ���� = 0;
		boolean ������5�� = true;
		ArrayList<String> al = new ArrayList<String>();
		while (true) {
			if (�Ž����� >= ȭ��) {
				���� = �Ž����� / ȭ��;
				al.add(String.format("%d�� ¥�� - %d", ȭ��, ����));
				�Ž����� %= ȭ��;
			}
			if (������5��) {
				ȭ�� /= 5;
			} else {
				ȭ�� /= 2;
			}
			������5�� = !������5��;
			if (ȭ�� == 5) {
				break;
			}
		}
		Result r = new Result(m, t, remain, al);
		request.setAttribute("r", r);
	}
}
