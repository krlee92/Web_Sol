package com.lee.gababo;

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
		if (!request.getParameterNames().hasMoreElements()) {
			request.setAttribute("userHand", "start.gif");
			request.setAttribute("comHand", "start.gif");
			request.setAttribute("win", "0½Â");
			request.setAttribute("draw", "0¹«");
			request.setAttribute("lose", "0ÆÐ");
		} else {
			Referee r = Referee.getReferee();
			r.gogo(request);
			
		}
		request.getRequestDispatcher("gababo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
