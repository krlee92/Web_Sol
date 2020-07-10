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
	// JSP에서 Java를 몰아내자
	// 값 받기 - EL로 해결
	
	// 이동 - redirect, forward, include
	// for, if
	// 출력형식지정
	
	// CustomTag
	//		.jsp에서만 가능
	//		DOM객체(html모양) 모양 - 실행 때 자바코드로 바뀌는
	//		<접두어:xxx></접두어:xxx>
	
	//		JSP표준액션태그
	//			 .jsp환경에서 기본적으로 사용 가능한거
	//			접두어 : jsp
	
	//		커스텀태그
	//			외부 .jar파일 넣어서 쓰는거
	//			접두어 마음대로
	
	// request.getRequestDispatcher("second.jsp").forward(request, response);
	// <jsp:forward page="second.jsp"></jsp:forward>
	
	// request.getRequestDispatcher("second.jsp").include(request, response);
	// <jsp:include page="second.jsp"></jsp:include>
	
%>
	<h1>first</h1>
	<hr>
	<!-- 자바코드include로는 위치조절 x,  표준액션태그 include는 위치조절 가능 -->
	<!-- second.jsp의 소스를 그대로 넣어줌 -->
	<jsp:include page="second.jsp"></jsp:include>
</body>
</html>