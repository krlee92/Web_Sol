package com.lee.io.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/pr")
public class pr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public pr() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();	
		
		String name = request.getParameter("name");
		
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		out.printf("이름 : %s", name);
		
		out.print("</body></html>");
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();	
		
		
		
		int x = Integer.parseInt(request.getParameter("x"));
		String[] what = request.getParameterValues("what");
		int y = Integer.parseInt(request.getParameter("y"));
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		if (what != null) {
			for (String w : what) {
				out.printf("%d %s %d = ", x, w, y);
				if(w.equals("+")) {
					out.print(x + y);
				}else if (w.equals("-")) {
					out.print(x - y);
				}else if (w.equals("*")) {
					out.print(x * y);
				}else if (w.equals("/")) {
					out.print(x / y);
				}
				out.print("<p>");
			}
		}
		out.print("</body></html>");
		
	}

}
