package com.lee.io.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OddEven")
public class OddEven extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OddEven() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int no = Integer.parseInt(request.getParameter("no"));
		String oe = "¦";
		if(no % 2 ==1) {
			oe = "Ȧ";
		}
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();
		
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		out.printf("<marquee>%s</marquee>", oe);
		out.print("</body></html>");
	}
	
	

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
