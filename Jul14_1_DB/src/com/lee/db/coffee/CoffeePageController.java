package com.lee.db.coffee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class COffeePageController
 */
@WebServlet("/CoffeePageController")
public class CoffeePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CoffeePageController() {
        super();
    }
    
    // 페이지 전환용
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int p = Integer.parseInt(request.getParameter("p"));
		CoffeeDAO.getCdao().getCoffee(p, request);
		request.setAttribute("contentPage", "coffee/bbs.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
