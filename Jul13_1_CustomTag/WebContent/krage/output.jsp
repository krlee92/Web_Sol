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
	// JSTL core ����

	// 20�� ������ h1���� �������
	// �ȵǸ� marquee�� ����
//		if�� �ʿ�

	// CustomTag
	//		<���ξ�:xxx>

	//		JSPǥ�ؾ׼��±�(��ǰ)
	//			<jsp:xxx> - forward, include
	
	//		CustomTag(����ǰ)
	//			<%@ taglib prefix(���ξ�)="c" uri="http://java.sun.com/jsp/jstl/core" % ���� �վ��ֱ�
	//			<���ξ� �������:xxx> -> ���ξ�c�� �ϴ°� �̹ٴ��� ���
	//			JSTL(JSP Standard Tag Library)��ǰ���..
	//				core		- if, for, redirect
	//				formatting	- �����������(�Ҽ������°,��¥..)
	//				functions	- ���ڿ� ���� �޼ҵ�
	//				....
%>
	<br><br><br><br><br>
	<div id="age">���� : <span id="age2">${age }</span>��</div>
	<c:if test="${age >20 }">
		<h1>�������</h1>
	</c:if>
	<hr>
	<!-- if�� -->
	<c:choose>
		<c:when test="${age > 20 }">
			<h1>�������</h1>
		</c:when>
		<c:when test="${age > 10 }">
			<marquee>����</marquee>
		</c:when>
		<c:otherwise>
			<h3>��</h3>
		</c:otherwise>	
	</c:choose>
	<hr>
	
	<!-- for �ݺ��� -->
	<!-- step�� ������ �ȵ�(�Ųٷ��ϴ°�) -->
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
			<th>�޴���</th>
			<th>����</th>
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