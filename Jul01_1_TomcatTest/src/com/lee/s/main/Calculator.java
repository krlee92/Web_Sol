package com.lee.s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ...../Calculator?a=10&b=20

@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Calculator() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();
		
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		out.print("<table border='1'>");
		out.print("<tr><th>사칙연산 계산기</th></tr>");
		
		out.printf("<tr><td>%d + %d = %d </td></tr>", a, b, a+b);
		out.printf("<tr><td>%d - %d = %d </td></tr>", a, b, a-b);
		out.printf("<tr><td>%d x %d = %d </td></tr>", a, b, a*b);
		out.printf("<tr><td>%d / %d = %d </td></tr>", a, b, a/b);
		
		
		out.print("</table>");
		out.print("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
