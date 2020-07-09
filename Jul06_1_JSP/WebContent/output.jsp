<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="NewFile.css">
</head>
<body>
<%
	HashMap<String, String[]> data
		= new HashMap<String, String[]>();
	data.put("a", new String[]{"cm", "inch"}); // 배열 정식문법을 사용해줘야
	data.put("b", new String[]{"평", "㎥"});
	data.put("c", new String[]{"℃", "℉"});
	data.put("d", new String[]{"km/h", "mi/h"});
	// data.get(what)[0]
	
	//
	int n = Integer.parseInt(request.getParameter("n"));
	String what = request.getParameter("what");
	double ans = n * 0.621371; // km/h - mi/h
	if (what.equals("a")) {
		ans = n * 0.394;
	} else if (what.equals("b")) {
		ans = n * 3.3;
	} else if (what.equals("c")) {
		ans = n * 33.8;
	}
	String ans2 = String.format("%.1f", ans);
%>
	<table>
		<tr>
			<th class="test<%=what %>">변환결과</th>
		</tr>
		<tr>
			<td align="center">
				<%=n %> <%=data.get(what)[0] %>
			</td>
		</tr>
		<tr>
			<td align="center">↓</td>
		</tr>
		<tr>
			<td align="center" >
				<%=ans2 %> <%=data.get(what)[1] %>
			</td>
		</tr>
	</table>
</body>
</html>