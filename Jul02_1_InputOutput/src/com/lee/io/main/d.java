package com.lee.io.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/d")
public class d extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public d() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("euc-kr");
		String name = request.getParameter("name");
		int pw = Integer.parseInt(request.getParameter("pw"));
		PrintWriter out = response.getWriter();	
		String gender = request.getParameter("gender");
		String addr = request.getParameter("addr");
		String food = request.getParameter("food");
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		out.printf("이름 : %s<hr>", name);
		out.printf("비번 : %d<hr>", pw);
		out.printf("성별 : %s<hr>", gender);
		out.printf("주소 : %s<hr>", addr);
		out.printf("좋아하는음식 : %s<hr>", food);
		
		out.print("</body></html>");
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("euc-kr");
		request.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();	
		
		String name = request.getParameter("name");
		int pw = Integer.parseInt(request.getParameter("pw"));
		String gender = request.getParameter("gender");
		String addr = request.getParameter("addr");

		// checkbox
		String[] food = request.getParameterValues("food");
		
		String introduce = request.getParameter("introduce");
		
		// textarea에서 엔터친거 : \r\n
		// 용도 구분해야
		//		값을 자바에서 쓸거
		//		값을 웹페이지서 쓸거 : \r\n -> <br>로 바꿔야
		System.out.println(introduce);
		introduce = introduce.replace("\r\n", "<br>");
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		out.printf("이름 : %s<hr>", name);
		out.printf("비번 : %d<hr>", pw);
		out.printf("성별 : %s<hr>", gender);
		out.printf("주소 : %s<hr>", addr);
		if (food != null) {
			out.print("음식 : ");
			for (String f : food) {
				out.print(f + " ");
			}
		}
		out.print("<br>");
		out.printf("자기소개) %s: ", introduce);
		
		out.print("<hr>");
		out.print("</body></html>");
	}

}
