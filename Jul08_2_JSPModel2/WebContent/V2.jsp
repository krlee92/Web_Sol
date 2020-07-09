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
	String a = request.getParameter("a");
	String b = request.getParameter("b");
	
	int c = (Integer)request.getAttribute("ccc");
%>	

	<h1>계산결과</h1>
	<%=a %> + <%=b %> = <%=c %>
</body>
</html>