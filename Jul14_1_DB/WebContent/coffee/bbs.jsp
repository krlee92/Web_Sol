<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="coffeeTbl">
		<tr>
			<td align="right">
				<a href="CoffeeRegController" id="coffeeRegGo">[메뉴등록]</a>
			</td>
		</tr>
		<tr>
			<td align="center">
				<table id="coffeeBBS">
					<tr>
						<th>메뉴명</th>
						<th>가격</th>
					</tr>
					<c:forEach var="c" items="${coffees }">
						<tr class="dataTr">
							<td>${c.name }</td>
							<td align="right"><fmt:formatNumber value="${c.price }" type="currency"/></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">1 2 3 4</td>
		</tr>
		<tr>
			<td align="center">검색</td>
		</tr>
	</table>
</body>
</html>