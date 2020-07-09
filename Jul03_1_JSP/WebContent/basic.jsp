<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- 
	JSP(Java Servlet Page)
		HTML베이스에 자바코드를 넣는 형태로 작업 -> 작업 편해짐
		톰캣이 Servlet으로 바꿔서 실행

 -->
 <%
 	int a = 10 + 20;
 %>
 	<h1><%=a %></h1>
</body>
</html>

