<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>third</h1>
<%
	int a = Integer.parseInt(request.getParameter("a"));
	int b = Integer.parseInt(request.getParameter("b"));
	
	/* Object c = request.getAttribute("ccc");
	Integer c2 = (Integer) c;
	int c3 = c2.intValue(); */
	
	/* Object c = request.getAttribute("ccc");
	int c3 = (Integer) c; */
	
	int c3 = (Integer) request.getAttribute("ccc");
			
%>
	<%=a %>
	<%=b %>
	<%=c3 %>
</body>
</html>