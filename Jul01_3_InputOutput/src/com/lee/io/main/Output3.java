package com.lee.io.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Output3")
public class Output3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Output3() {
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
		
		String n = request.getParameter("n");
		String[] n2 = n.split("/"); 
		int sum = 0;
		for (String s : n2) {
			sum += Integer.parseInt(s);
		}
		
		PrintWriter out = response.getWriter();
		
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		out.printf("�հ� : %d<P>", sum);
		out.printf("��� : %.1f<P>", (double)sum / n2.length);
		
		out.print("</body></html>");
		
	}

}
