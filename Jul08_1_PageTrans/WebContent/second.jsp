<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	int a = Integer.parseInt(request.getParameter("a"));
	int b = Integer.parseInt(request.getParameter("b"));
	int c = a+b;
	request.setAttribute("ccc", c);
	
	
// ��
//		1. parameter(first.html�������� a, b)
//			html���� ���� ��
//			String or String[](üũ�ڽ��϶�)
//			request��ü�� �Ƿ��� ����

//		2. attribute
//			java���� ���� ��
//			Object�� �� ����
//			request��ü�� �Ƿ��� ����


// �ڵ��̵�
// 		1. redirect - ������
//	response.sendRedirect("third.jsp");

//		2. forward
//			first���� second�� �Ѿ�ö� �� ��û����(request)��
//			third���� ��������
	RequestDispatcher rd
		= request.getRequestDispatcher("third.jsp");
	rd.forward(request, response);
	
//		3. include : ��ġ ���� �Ұ�(������ ���� ����)
//	rd.include(request, response);



%>
	��� : <%=c %>
</body>
</html>