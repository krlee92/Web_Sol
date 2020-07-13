<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	// JSTL core 예제

	// 20살 넘으면 h1으로 어서오세요
	// 안되면 marquee로 나가
//		if문 필요

	// CustomTag
	//		<접두어:xxx>

	//		JSP표준액션태그(정품)
	//			<jsp:xxx> - forward, include
	
	//		CustomTag(사제품)
	//			<%@ taglib prefix(접두어)="c" uri="http://java.sun.com/jsp/jstl/core" % 위에 뚫어주기
	//			<접두어 마음대로:xxx> -> 접두어c로 하는게 이바닥의 약속
	//			JSTL(JSP Standard Tag Library)정품취급..
	//				core		- if, for, redirect
	//				formatting	- 출력형식지정(소수점몇번째,날짜..)
	//				functions	- 문자열 관련 메소드
	//				....
%>
	<br><br><br><br><br>
	<div id="age">나이 : <span id="age2">${age }</span>살</div>
	<c:if test="${age >20 }">
		<h1>어서오세요</h1>
	</c:if>
	<hr>
	<!-- if문 -->
	<c:choose>
		<c:when test="${age > 20 }">
			<h1>어서오세요</h1>
		</c:when>
		<c:when test="${age > 10 }">
			<marquee>나가</marquee>
		</c:when>
		<c:otherwise>
			<h3>떽</h3>
		</c:otherwise>	
	</c:choose>
	<hr>
	
	<!-- for 반복문 -->
	<!-- step에 음수는 안됨(거꾸로하는거) -->
	<c:forEach var="i" begin="1" end="${age }" step="3">
		${i }
	</c:forEach>
	<hr>
	
	<c:forEach var="a" items="${ar } }">
		${a }
	</c:forEach>
	<hr>
	
	
	<table border="1">
		<tr>
			<th>메뉴명</th>
			<th>가격</th>
		</tr>
		<c:forEach var="m" items="${ms }">
		<tr>
			<td>${m.name }</td>
			<td>${m.price }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>