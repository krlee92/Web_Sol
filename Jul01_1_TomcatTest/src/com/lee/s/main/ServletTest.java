package com.lee.s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// main() => ��Ĺ��
// ��Ĺ�� ���� ��ü�� �ڵ����� ����
// -> �̺�Ʈ ����




// @XXX : annotation - �ڵ����� ���� ����

// Tomcat 5.0���� : ���� ����� ��Ĺ ���� ���Ͽ�
//				���� ����� �ؾ� ��� ����

@WebServlet("/ServletTest") // �ڵ� ��
public class ServletTest extends HttpServlet implements Servlet {
       
	// ���� ǥ���϶�� ����� �� ����, ������ �������
	private static final long serialVersionUID = 1L;
	
    public ServletTest() {
        super();
    }
    // Socket��� : �ǽð� ���
    // HTTP��� :
    //		Ŭ���̾�Ʈ�� �������� ��û(GET���/POST���)
    //		������ �� ��û�� ���� ����
    
    // Ŭ���̾�Ʈ�κ��� GET��� ��û ������ �ڵ� ȣ��
//    		�ּ� ���� �ļ� ����Ʈ ����
//    		Ŭ���ؼ�(<a></a>) ����Ʈ ����
    		
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	// �����Ҷ� ���ڵ������ �˷��ִ� ����
	response.setCharacterEncoding("euc-kr");
		
	// Ŭ���̾�Ʈ���� ������ ���� ��(����) ����ϴ� ����
	PrintWriter out = response.getWriter();
	out.print("<html>");	
	out.print("<head><meta charset='euc-kr'></head>");
	out.print("<body>");
	int a = 365 * 32;
	out.printf("<marquee>%d��</marquee>",a);
	out.print("</body></html>");
	}
	
	

    // Ŭ���̾�Ʈ�κ��� POST��� ��û ������ �ڵ� ȣ��
//			�α��ΰ��� ���ȹ����� �ִ� ����Ʈ ����
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("��");
	}

}
