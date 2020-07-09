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
	
	
// 값
//		1. parameter(first.html에서만든 a, b)
//			html에서 만든 값
//			String or String[](체크박스일때)
//			request객체에 실려서 전송

//		2. attribute
//			java에서 만든 값
//			Object면 다 가능
//			request객체에 실려서 전송


// 자동이동
// 		1. redirect - 공사중
//	response.sendRedirect("third.jsp");

//		2. forward
//			first에서 second로 넘어올때 한 요청정보(request)를
//			third까지 전달해줌
	RequestDispatcher rd
		= request.getRequestDispatcher("third.jsp");
	rd.forward(request, response);
	
//		3. include : 위치 조절 불가(무조건 제일 위에)
//	rd.include(request, response);



%>
	결과 : <%=c %>
</body>
</html>