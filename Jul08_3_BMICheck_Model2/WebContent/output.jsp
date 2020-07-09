<%@page import="com.lee.bmi.main.Guest"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	
	
	<table>
		<tr>
			<th>검사 결과</th>
		</tr>
		<tr>
			<td align="center">
				<img src="p/${gHaha.photo }">
			</td>
		</tr>
		<tr>
			<td class="td1">이름</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;${gHaha.name }<br><br></td>
		</tr>
		<tr>
			<td class="td1">키</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;${gHaha.height }cm<br><br></td>
		</tr>
		<tr>
			<td class="td1">몸무게</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;${gHaha.weight }kg<br><br></td>
		</tr>
		<tr>
			<td class="td1">BMI</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;${gHaha.bmi }<br><br></td>
		</tr>
		<tr>
			<td align="center" style="color:red; font-weight: 900; font-size: 15pt;">
				${gHaha.result }<br><br>
			</td>
		</tr>
	</table>
</body>
</html>







