<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Jul14</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<table id="siteTitleArea">
		<tr>
			<td align="center">
				<a href="HomeController">Jul14</a>
			</td>
		</tr>
	</table>
	<table id="siteContentArea">
		<tr>
			<td align="center">
				<jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
	<table id="siteMenuArea">
		<tr>
			<td><a href="WeatherController">날씨</a></td>
		</tr>
		<tr>
			<td><a href="LocController">검색</a></td>
		</tr>
		<tr>
			<td><a href="GController">HTML5 Graphic</a></td>
		</tr>
	</table>
</body>
</html>