package com.lee.db.coffee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CoffeeUpdateController")
public class CoffeeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CoffeeUpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoffeeDAO.getCdao().UpdateCoffee(request);
		CoffeeDAO.getCdao().getCoffee(1, request);
		request.setAttribute("contentPage", "coffee/bbs.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
