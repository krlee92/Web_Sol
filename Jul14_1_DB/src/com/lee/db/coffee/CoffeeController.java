package com.lee.db.coffee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CoffeeController")
public class CoffeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CoffeeController() {
        super();
    }
    // 커피페이지 처음 들어올때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CoffeeDAO.getCdao().getCoffee(1, request);
		// 폴더명을 써서 구별이 되니까 파일명이 coffeeBBS.jsp일 필요 없다
		request.setAttribute("contentPage", "coffee/bbs.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
