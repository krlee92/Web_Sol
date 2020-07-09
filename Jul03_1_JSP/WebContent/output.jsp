<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%! 
	public int getCha(int a, int b){
		return a - b;
		
	}
	public String getMoks(int a, int b){
		double c = a / (double)b;
		return String.format("%.1f", c);
	}
%>
</head>
<body>
<%
	// response.setCharacterEncoding("euc-kr"); 필요없음
	int x = Integer.parseInt(request.getParameter("xx"));
	int y = Integer.parseInt(request.getParameter("yy"));
	int a = x + y;
	int b = getCha(x, y);
	int c = x * y;
	int d = x / y;

	
%>
	<h1>계산결과</h1>
<%
	if(a > 20){
%>	
		<marquee><%=x %>+<%=y %> =<%=a %> </marquee>
		<marquee><%=x %>-<%=y %> =<%=b %> </marquee>
		<marquee><%=x %>*<%=y %> =<%=x*y %> </marquee>
		<marquee><%=x %>/<%=y %> =<%=getMoks(x, y) %> </marquee>
<% 
	}
%>		
</body>
</html>