package com.lee.jm2.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// C(Controller)
//		��Ȳ�Ǵ��ؼ� �ʿ��� ������ ������
//		������Ʈ ��ü�� ������(���� ���⼭ ctrl f11)

@WebServlet("/C")
public class C extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public C() {
        super();
    }

    // �ּ� �ļ� ����
    // Ŭ���ؼ� ����
    // � ����Ʈ�� ó�� ���� : GET��� ��û
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher rd
//			= request.getRequestDispatcher("V1.html");
//		rd.forward(request, response);
		
		// ����Ʈ ù���ӽ� V1���� ����
		request.getRequestDispatcher("V1.html").forward(request, response); // ���ٷ�
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		M.calculate(request);
		request.getRequestDispatcher("V2.jsp").forward(request, response); // ����ư ������ V2�� ����
		
	}

}
