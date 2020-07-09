package com.lee.s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanServlet
 */
@WebServlet("/GugudanServlet")
public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GugudanServlet() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		out.print("<table border='1'>");
		out.print("<tr><th>2단</th></tr>");
		for (int i = 1; i <= 9; i++) {
			out.printf("<tr><td>2 x %d = %d </td></tr>", i, i*2);
		}
		
		
		out.print("</table>");
		out.print("</body></html>");
		}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
