package com.lee.bmi.main;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// M 계산작업 

public class Doctor {

	public static void calc(HttpServletRequest request) {

		try {
			// 사진이 업로드 될 폴더(서버상의 절대경로)
			String path = request.getSession().getServletContext().getRealPath("p");

			// request : 비닐 포장(기본값)
			// mr : 박스 포장
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

			String result = "저체중";
			if (bmi >= 40) {
				result = "고도 비만";
			} else if (bmi >= 35) {
				result = "중등도 비만";
			} else if (bmi >= 30) {
				result = "경도 비만";
			} else if (bmi >= 25) {
				result = "과체중";
			} else if (bmi >= 18.5) {
				result = "정상";
			}
			
		Guest g = new Guest(name, height, weight, bmi, result, photo);
		request.setAttribute("gHaha", g);
		
		}
		catch (Exception e) {

		}

	}
}
