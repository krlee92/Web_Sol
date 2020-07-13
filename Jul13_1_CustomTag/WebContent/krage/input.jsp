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
<br><br><br><br><br>
	<form action="KrageController" name="ageForm" onsubmit="return ageCheck();">
		<select name="birthYear">
			<c:forEach var="y" begin="1970" end="2020">
				<option>${y }</option>
			</c:forEach>
		</select>
		<button id="ageBtn">확인</button>
	</form>
</body>
</html>