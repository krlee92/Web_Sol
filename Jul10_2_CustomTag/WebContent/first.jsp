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
	// JSP���� Java�� ���Ƴ���
	// �� �ޱ� - EL�� �ذ�
	
	// �̵� - redirect, forward, include
	// for, if
	// �����������
	
	// CustomTag
	//		.jsp������ ����
	//		DOM��ü(html���) ��� - ���� �� �ڹ��ڵ�� �ٲ��
	//		<���ξ�:xxx></���ξ�:xxx>
	
	//		JSPǥ�ؾ׼��±�
	//			 .jspȯ�濡�� �⺻������ ��� �����Ѱ�
	//			���ξ� : jsp
	
	//		Ŀ�����±�
	//			�ܺ� .jar���� �־ ���°�
	//			���ξ� �������
	
	// request.getRequestDispatcher("second.jsp").forward(request, response);
	// <jsp:forward page="second.jsp"></jsp:forward>
	
	// request.getRequestDispatcher("second.jsp").include(request, response);
	// <jsp:include page="second.jsp"></jsp:include>
	
%>
	<h1>first</h1>
	<hr>
	<!-- �ڹ��ڵ�include�δ� ��ġ���� x,  ǥ�ؾ׼��±� include�� ��ġ���� ���� -->
	<!-- second.jsp�� �ҽ��� �״�� �־��� -->
	<jsp:include page="second.jsp"></jsp:include>
</body>
</html>