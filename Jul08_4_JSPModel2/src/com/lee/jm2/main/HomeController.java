package com.lee.jm2.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("input.html").forward(request, response); // 결과 보냄
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 계산한거 보내야함
		Calculator.gogo(request);
		request.getRequestDispatcher("output.jsp").forward(request, response);
	}

}
