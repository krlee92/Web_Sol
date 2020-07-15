package com.lee.db.coffee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CoffeeRegController")
public class CoffeeRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CoffeeRegController() {
        super();
    }
    
    // ����Ϸ� �� ��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("contentPage", "coffee/reg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	// ����ϱ�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ŀ�� ��� �����ϰ�
		CoffeeDAO.coffeeReg(request);
		
		// Ŀ�� ����� �����;�
		CoffeeDAO.getCoffee(request);
		// ��� �ϰ� �ٽ� ��� ��������
//		request.setAttribute("contentPage", "coffee/reg.jsp");
//		request.getRequestDispatcher("index.jsp").forward(request, response);
		// ��� �ϰ� �Խ���������
		request.setAttribute("contentPage", "coffee/bbs.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
