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
		out.printf("�̸� : %s<hr>", name);
		out.printf("��� : %d<hr>", pw);
		out.printf("���� : %s<hr>", gender);
		out.printf("�ּ� : %s<hr>", addr);
		out.printf("�����ϴ����� : %s<hr>", food);
		
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
		
		// textarea���� ����ģ�� : \r\n
		// �뵵 �����ؾ�
		//		���� �ڹٿ��� ����
		//		���� ���������� ���� : \r\n -> <br>�� �ٲ��
		System.out.println(introduce);
		introduce = introduce.replace("\r\n", "<br>");
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		out.printf("�̸� : %s<hr>", name);
		out.printf("��� : %d<hr>", pw);
		out.printf("���� : %s<hr>", gender);
		out.printf("�ּ� : %s<hr>", addr);
		if (food != null) {
			out.print("���� : ");
			for (String f : food) {
				out.print(f + " ");
			}
		}
		out.print("<br>");
		out.printf("�ڱ�Ұ�) %s: ", introduce);
		
		out.print("<hr>");
		out.print("</body></html>");
	}

}
