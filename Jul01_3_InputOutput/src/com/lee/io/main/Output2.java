package com.lee.io.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Output2")
public class Output2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Output2() {
        super();
    }

    // �Է¹��� �����Ͱ� ���ͳ� �ּҿ� �Ƿ��� �Ѿ���� ��
    // ���ͳ� �ּҿ��� �ѱ�, Ư������ ��� �Ұ�
    // �� -> %2A(URL���ڵ�)
    
    // ��Ĺ�� �˾Ƽ� �� -> %2A
    // ��Ĺ�� �˾Ƽ� 2A -> ��
     
    // ��Ĺ ���� ���� : �ڵ����� �ٲ� �� euc-kr�� ������
//    		���� iso-8859-1
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String say = "����";
		if (age >=20) {
			say = "�������";
		}
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();
		
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		out.printf("<marquee>%s�� %s</marquee>", name, say);
		out.print("</body></html>");
	}
	
	

	// GET��� : ��û�Ķ���Ͱ� �ּҿ� - �ѱ�ó�� ����
	// PSOT���: ��û�Ķ���Ͱ� ���������� ���� - request.setC
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		doGet�� POST������ �����
//		doGet(request, response);
		
		// POST��� ��û �Ķ���� �ѱ�ó��
		request.setCharacterEncoding("euc-kr");
		
		response.setCharacterEncoding("euc-kr");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String say = "����";
		if (age >=20) {
			say = "�������";
		}
		PrintWriter out = response.getWriter();
		
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		out.printf("<marquee>%s�� %s</marquee>", name, say);
		out.print("</body></html>");
		
	}

}
