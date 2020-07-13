package com.lee.game.bb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BBController")
public class BBController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public BBController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) {
			Referee.getReferee().Á¤´ä»Ì±â();
		} else {
			Referee.getReferee().judge(request);
		}
		request.setAttribute("contentPage", "bb/bb.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
