package com.lee.io.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/fileUpload")
public class fileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public fileUpload() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();	
		
		String name = request.getParameter("name");
		
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		out.printf("이름 : %s", name);
		
		out.print("</body></html>");
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 사용자가 보내준 파일을 저장할 폴더 (서버상의)절대경로가 필요함
		String path = request.getSession()
				.getServletContext().getRealPath("p");
		System.out.println(path);
		
		// 파일 업로드 처리 됐음
		MultipartRequest mr =
				new MultipartRequest(
					request, path,
					30 * 1024 * 1024, // 30메가 허용 파일 최대 크기(넘어서면 예외처리)
					"euc-kr",	// request.setCharacterEncoding()에 해당
					new DefaultFileRenamePolicy()	// 파일명 중복 됐을때(숫자 붙여서)
						);
		
//		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();	
		
//		String name = request.getParameter("name"); // 비닐포장 뜯는코드(기존)
		String name = mr.getParameter("name"); // 박스포장 뜯는코드(기존)
		
		// 업로드한 파일명(중복 때문에 바뀌어있을수가있다)
		String fName = mr.getFilesystemName("p");
		// 톰캣이 한글 파일명 인식 못함
		// ㅋ -> %2A 인코딩 필요
		// 띄어쓰기 -> +로 바뀜
		fName = URLEncoder.encode(fName, "euc-kr");
		fName = fName.replace("+", " "); //띄어쓰기 처리된 +를 띄어쓰기로 처리
		
		String fName2 = mr.getFilesystemName("e");
		fName2 = URLEncoder.encode(fName2, "euc-kr");
		fName2= fName2.replace("+", " ");
		
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		out.printf("이름 : %s", name);
		out.printf("<img src='imgHaha/%s'>", fName);
		out.printf("<a href='imgHaha/%s'>다운</a><hr>", fName2);
		out.print("</body></html>");
		
	}

}
