package com.lee.bmi.main;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// M ����۾� 

public class Doctor {

	public static void calc(HttpServletRequest request) {

		try {
			// ������ ���ε� �� ����(�������� ������)
			String path = request.getSession().getServletContext().getRealPath("p");

			// request : ��� ����(�⺻��)
			// mr : �ڽ� ����
			MultipartRequest mr = new MultipartRequest(request, path, 10485760, "euc-kr",
					new DefaultFileRenamePolicy());

			String name = mr.getParameter("n");
			int height = Integer.parseInt(mr.getParameter("h"));
			int weight = Integer.parseInt(mr.getParameter("w"));
			String photo = mr.getFilesystemName("p");
			photo = URLEncoder.encode(photo, "euc-kr");
			photo = photo.replace("+", " ");

			double h2 = height / 100.0;
			double bmi = (double) weight / (h2 * h2);

			String result = "��ü��";
			if (bmi >= 40) {
				result = "�� ��";
			} else if (bmi >= 35) {
				result = "�ߵ ��";
			} else if (bmi >= 30) {
				result = "�浵 ��";
			} else if (bmi >= 25) {
				result = "��ü��";
			} else if (bmi >= 18.5) {
				result = "����";
			}
			
		Guest g = new Guest(name, height, weight, bmi, result, photo);
		request.setAttribute("gHaha", g);
		
		}
		catch (Exception e) {

		}

	}
}
