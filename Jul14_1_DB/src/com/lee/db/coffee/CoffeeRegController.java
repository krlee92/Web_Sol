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
    
    // 등록하러 올 때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("contentPage", "coffee/reg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	// 등록하기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 커피 등록 먼저하고
		CoffeeDAO.coffeeReg(request);
		
		// 커피 목록을 가져와야
		CoffeeDAO.getCoffee(request);
		// 등록 하고 다시 등록 페이지로
//		request.setAttribute("contentPage", "coffee/reg.jsp");
//		request.getRequestDispatcher("index.jsp").forward(request, response);
		// 등록 하고 게시판쪽으로
		request.setAttribute("contentPage", "coffee/bbs.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
