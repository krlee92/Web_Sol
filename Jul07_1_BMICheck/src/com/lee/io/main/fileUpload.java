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
		out.printf("�̸� : %s", name);
		
		out.print("</body></html>");
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ����ڰ� ������ ������ ������ ���� (��������)�����ΰ� �ʿ���
		String path = request.getSession()
				.getServletContext().getRealPath("p");
		System.out.println(path);
		
		// ���� ���ε� ó�� ����
		MultipartRequest mr =
				new MultipartRequest(
					request, path,
					30 * 1024 * 1024, // 30�ް� ��� ���� �ִ� ũ��(�Ѿ�� ����ó��)
					"euc-kr",	// request.setCharacterEncoding()�� �ش�
					new DefaultFileRenamePolicy()	// ���ϸ� �ߺ� ������(���� �ٿ���)
						);
		
//		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();	
		
//		String name = request.getParameter("name"); // ������� ����ڵ�(����)
		String name = mr.getParameter("name"); // �ڽ����� ����ڵ�(����)
		
		// ���ε��� ���ϸ�(�ߺ� ������ �ٲ�����������ִ�)
		String fName = mr.getFilesystemName("p");
		// ��Ĺ�� �ѱ� ���ϸ� �ν� ����
		// �� -> %2A ���ڵ� �ʿ�
		// ���� -> +�� �ٲ�
		fName = URLEncoder.encode(fName, "euc-kr");
		fName = fName.replace("+", " "); //���� ó���� +�� ����� ó��
		
		String fName2 = mr.getFilesystemName("e");
		fName2 = URLEncoder.encode(fName2, "euc-kr");
		fName2= fName2.replace("+", " ");
		
		
		out.print("<html>");	
		out.print("<head><meta charset='euc-kr'></head>");
		out.print("<body>");
		out.printf("�̸� : %s", name);
		out.printf("<img src='imgHaha/%s'>", fName);
		out.printf("<a href='imgHaha/%s'>�ٿ�</a><hr>", fName2);
		out.print("</body></html>");
		
	}

}
