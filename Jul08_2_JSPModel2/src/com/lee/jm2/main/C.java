package com.lee.jm2.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// C(Controller)
//		상황판단해서 필요한 쪽으로 보내는
//		웹사이트 전체의 진입점(실행 여기서 ctrl f11)

@WebServlet("/C")
public class C extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public C() {
        super();
    }

    // 주소 쳐서 접속
    // 클릭해서 접속
    // 어떤 사이트에 처음 들어간다 : GET방식 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher rd
//			= request.getRequestDispatcher("V1.html");
//		rd.forward(request, response);
		
		// 사이트 첫접속시 V1으로 보냄
		request.getRequestDispatcher("V1.html").forward(request, response); // 한줄로
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		M.calculate(request);
		request.getRequestDispatcher("V2.jsp").forward(request, response); // 계산버튼 누르면 V2로 보냄
		
	}

}
