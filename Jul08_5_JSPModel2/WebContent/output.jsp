<%@page import="com.lee.jm2.main.Result"%>
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
	Result r = (Result) request.getAttribute("r");
%>
<table>
	<tr>
		<th><span>간헐적 천재</span>가 쏩니다</th>
	</tr>
	<tr>
		<td>천재가 주식해서 번 돈</td>
	</tr>
	<tr>
		<td class="td1" align="right"><%=r.getMoney() %>원</td>
	</tr>
	<tr>
		<td>천재가 쏘는 회식비</td>
	</tr>
	<tr>
		<td class="td1" align="right"><%=r.getTomorrow() %>원</td>
	</tr>
	<tr>
		<td>쏘고 남은 돈</td>
	</tr>
	<tr>
		<td class="td1" align="right"><%=r.getRemain() %>원</td>
	</tr>
	<%
		for(String s:r.getAl()){
	%>
		<tr>
			<td class="td1" align="right"><%=s %></td>
		</tr>
	<%
		}
	%>
</table>

</body>
</html>