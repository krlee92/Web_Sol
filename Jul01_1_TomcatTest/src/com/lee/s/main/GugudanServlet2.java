package com.lee.s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GugudanServlet2")
public class GugudanServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	public GugudanServlet2() {
        super();
    }

	// 요청 파라메터
	// 		사용자가 WAS로 요청할 때 서버로 보내는 정보
	
	// 인터넷 주소 체계
	// 프로토콜:// 		http or https
	// 컴퓨터 주소 		IP주소 or DomainName
	// :포트번호		80이면 생략가능
	// 폴더명/폴더명/...파일명 파일명이 index.html이면 생략가능
	// ?
	// 변수명=값&변수명=값&... 요청 파라메터
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 파라메터 값 받기
		String d = request.getParameter("dan");
		int dd = Integer.parseInt(d);
		
		int bb = Integer.parseInt(request.getParameter("b"));
		
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		out.printf("<table border='%d'>", bb);
		out.printf("<tr><th>%d단</th></tr>", dd);
		for (int i = 1; i <= 9; i++) {
			out.printf("<tr><td>%d x %d = %d </td></tr>",dd, i, i*dd);
		}
		
		
		out.print("</table>");
		out.print("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
