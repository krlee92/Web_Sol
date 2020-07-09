package com.lee.bmi.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 실행은 여기서(진입점)

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
    }
    
    // 사이트 처음들어오면 GET방식
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("input.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Doctor.calc(request);
		request.getRequestDispatcher("output.jsp").forward(request, response);
	}

}
