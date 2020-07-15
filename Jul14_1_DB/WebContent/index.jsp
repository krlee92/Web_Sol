<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Jul14</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/weather.css">
<link rel="stylesheet" href="css/loc.css">
<link rel="stylesheet" href="css/coffee.css">
<script type="text/javascript" src="js/validCheck.js"></script>
<script type="text/javascript" src="js/jul15Check.js"></script>
<script type="text/javascript" src="js/notice.js"></script>
</head>
<c:choose>
	<c:when test="${r != null }">
		<body onload="showAlert('${r}');">
	</c:when>
	<c:otherwise>
		<body>
	</c:otherwise>
</c:choose>
<!-- r���� �������� body onload = showAlert
	�ƴϸ� ���� body
 -->


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
			<td><a href="WeatherController">����</a></td>
		</tr>
		<tr>
			<td><a href="LocController">�˻�</a></td>
		</tr>
		<tr>
			<td><a href="GController">HTML5 Graphic</a></td>
		</tr>
		<tr>
			<td><a href="DBController">DB</a></td>
		</tr>
		<tr>
			<td><a href="CoffeeController">Ŀ��</a></td>
		</tr>
	</table>
</body>
</html>