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

	// ��û �Ķ����
	// 		����ڰ� WAS�� ��û�� �� ������ ������ ����
	
	// ���ͳ� �ּ� ü��
	// ��������:// 		http or https
	// ��ǻ�� �ּ� 		IP�ּ� or DomainName
	// :��Ʈ��ȣ		80�̸� ��������
	// ������/������/...���ϸ� ���ϸ��� index.html�̸� ��������
	// ?
	// ������=��&������=��&... ��û �Ķ����
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ��û �Ķ���� �� �ޱ�
		String d = request.getParameter("dan");
		int dd = Integer.parseInt(d);
		
		int bb = Integer.parseInt(request.getParameter("b"));
		
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		out.printf("<table border='%d'>", bb);
		out.printf("<tr><th>%d��</th></tr>", dd);
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
