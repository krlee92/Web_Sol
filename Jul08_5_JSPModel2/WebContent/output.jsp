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
		<th><span>������ õ��</span>�� ���ϴ�</th>
	</tr>
	<tr>
		<td>õ�簡 �ֽ��ؼ� �� ��</td>
	</tr>
	<tr>
		<td class="td1" align="right"><%=r.getMoney() %>��</td>
	</tr>
	<tr>
		<td>õ�簡 ��� ȸ�ĺ�</td>
	</tr>
	<tr>
		<td class="td1" align="right"><%=r.getTomorrow() %>��</td>
	</tr>
	<tr>
		<td>��� ���� ��</td>
	</tr>
	<tr>
		<td class="td1" align="right"><%=r.getRemain() %>��</td>
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