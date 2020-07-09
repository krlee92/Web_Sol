package com.lee.io.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Output2")
public class Output2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Output2() {
        super();
    }

    // 입력받은 데이터가 인터넷 주소에 실려서 넘어오는 중
    // 인터넷 주소에는 한글, 특수문자 사용 불가
    // ㅋ -> %2A(URL인코딩)
    
    // 톰캣이 알아서 ㅋ -> %2A
    // 톰캣이 알아서 2A -> ㅋ
     
    // 톰캣 설정 변경 : 자동으로 바꿀 때 euc-kr을 쓰도록
//    		현재 iso-8859-1
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String say = "나가";
		if (age >=20) {
			say = "어서오세요";
		}
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();
		
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		out.printf("<marquee>%s씨 %s</marquee>", name, say);
		out.print("</body></html>");
	}
	
	

	// GET방식 : 요청파라메터가 주소에 - 한글처리 안함
	// PSOT방식: 요청파라메터가 내부적으로 전달 - request.setC
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		doGet은 POST에서는 없어야
//		doGet(request, response);
		
		// POST방식 요청 파라메터 한글처리
		request.setCharacterEncoding("euc-kr");
		
		response.setCharacterEncoding("euc-kr");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String say = "나가";
		if (age >=20) {
			say = "어서오세요";
		}
		PrintWriter out = response.getWriter();
		
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		out.printf("<marquee>%s씨 %s</marquee>", name, say);
		out.print("</body></html>");
		
	}

}
