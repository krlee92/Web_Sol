<%@page import="com.lee.jm2.main.Result"%>
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
	// parameter : String
	// Attribute : Object
	Result rrrrr = (Result) request.getAttribute("rrr");
%>

	남은 돈<%=rrrrr.getR() %><p>
	인사 : <%=rrrrr.getS() %>
</body>
</html>