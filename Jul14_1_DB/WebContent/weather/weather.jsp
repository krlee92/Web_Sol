<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/weather.css">
</head>
<body>
	<c:forEach var="w" items="${weathers }">
		<table class="w">
			<tr>
				<td colspan="2" class="wHour" align="center">
					${w.hour }
				</td>
			</tr>
			<tr>
				<td rowspan="2" class="wImg" align="center">
					<img src="img/weather/${w.img }">
				</td>
				<td style="font-size:20pt;">${w.weather }</td>
			</tr>
			<tr>
				<td align="right">${w.temp }&nbsp;</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>