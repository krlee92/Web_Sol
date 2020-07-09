package com.lee.s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// main() => 톰캣에
// 톰캣이 서블릿 객체를 자동으로 만듬
// -> 이벤트 루프




// @XXX : annotation - 자동으로 뭔가 해줌

// Tomcat 5.0이전 : 서블릿 만들면 톰캣 설정 파일에
//				따로 등록을 해야 사용 가능

@WebServlet("/ServletTest") // 자동 등
public class ServletTest extends HttpServlet implements Servlet {
       
	// 버전 표시하라고 만들어 준 변수, 지워도 상관없음
	private static final long serialVersionUID = 1L;
	
    public ServletTest() {
        super();
    }
    // Socket통신 : 실시간 통신
    // HTTP통신 :
    //		클라이언트가 서버에게 요청(GET방식/POST방식)
    //		서버가 그 요청에 대한 응답
    
    // 클라이언트로부터 GET방식 요청 받으면 자동 호출
//    		주소 직접 쳐서 사이트 접속
//    		클릭해서(<a></a>) 사이트 접속
    		
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	// 응답할때 인코딩방식을 알려주는 역할
	response.setCharacterEncoding("euc-kr");
		
	// 클라이언트에게 데이터 보낼 때(응답) 사용하는 빨대
	PrintWriter out = response.getWriter();
	out.print("<html>");	
	out.print("<head><meta charset='euc-kr'></head>");
	out.print("<body>");
	int a = 365 * 32;
	out.printf("<marquee>%dㅋ</marquee>",a);
	out.print("</body></html>");
	}
	
	

    // 클라이언트로부터 POST방식 요청 받으면 자동 호출
//			로그인같은 보안문제가 있는 사이트 접속
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("ㅎ");
	}

}
