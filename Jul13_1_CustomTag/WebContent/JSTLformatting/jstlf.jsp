<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<fmt:formatNumber value="${a }" type="number" />
	<hr>	
	<fmt:formatNumber value="${a }" type="currency" />
	<hr>
	<fmt:formatNumber value="${b }" type="percent" />
	<hr>
	
	<!-- 
		# : 숫자가 있으면 넣기
		0 : 자릿수 보존
	 -->
	<fmt:formatNumber value="${b }" pattern="#.00" />
	<hr>
	<fmt:formatNumber value="${c }" pattern="#,##0.000" />
	<hr>
	
	<fmt:formatDate value="${d }" type="date" dateStyle="short"/><br>
	<fmt:formatDate value="${d }" type="date" dateStyle="long"/><br>
	
	<fmt:formatDate value="${d }" type="time" timeStyle="short"/><br>
	<fmt:formatDate value="${d }" type="time" timeStyle="long"/><br>
	
	<fmt:formatDate value="${d }" type="both" dateStyle="long" timeStyle="short" />
	<hr>
	<fmt:formatDate value="${d }" pattern="yyyy/hh a"/>
	
	<table border="1">
		<tr>
			<th>품명</th>
			<th>가격</th>
			<th>유통기한</th>
		</tr>
		<c:forEach var="t" items="${snacks }">
		<tr>
			<td>${t.name }</td>
			
			<td>
				<fmt:formatNumber value="${t.price }" type="currency" />
			</td>
			
			<td>
				<fmt:formatDate value="${t.exp }" type="date" dateStyle="long" />
			</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>