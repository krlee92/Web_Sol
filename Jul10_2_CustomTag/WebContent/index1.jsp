<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Jul10_2</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<table id="site">
		<tr>
			<td id="siteTitleArea">Jul10</td>
		</tr>
		<tr>
			<td id="siteMenuArea">
				<a href="HomeController">홈</a>
				<a href="AController">A</a>
				<a href="">B</a>
			</td>
		</tr>
		<tr>
			<td id="siteContentArea" align="center">
				<jsp:include page="${contentPageHaha }"></jsp:include>
			</td>
		</tr>
	</table>
		<!-- 무한루프 : include페이지 못찾을때 -->
</body>
</html>


