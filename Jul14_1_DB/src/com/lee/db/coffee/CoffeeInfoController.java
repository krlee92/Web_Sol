package com.lee.db.coffee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CoffeeInfoController")
public class CoffeeInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CoffeeInfoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (CoffeeDAO.getCdao().getCoffeeInfo(request)) {
			request.setAttribute("contentPage", "coffee/info.jsp"); // coffeeinfo값 가져오면
		} else {
			CoffeeDAO.getCdao().getCoffee(1, request); // 가져오는데 실패하면
			request.setAttribute("contentPage", "coffee/bbs.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
