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
				<a href="HomeController">Ȩ</a>
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
		<!-- ���ѷ��� : include������ ��ã���� -->
</body>
</html>


