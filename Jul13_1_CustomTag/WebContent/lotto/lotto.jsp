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
// �ݺ��� ������ ���� �ھ���̺귯�� ������ ������ ����.
%>
	<br><br><br><br><br><br>
	<c:forEach var="b" items="${lottoBall }">
		<img src="img/lottoimg/ball_${b }.png">
	</c:forEach>
</body>
</html>