<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/index.css">
<link rel="stylesheet" href="CSS/calc.css">
<script type="text/javascript" src="js/validCheck.js"></script>
<script type="text/javascript" src="js/jul10Check.js"></script>
</head>
<body>
	<table id="index" border="1">
		<tr>
			<th id="title" align="left"><a href="HomeController">&nbsp;Jul13</a></th>
		</tr>
		<tr>
			<td id="menu" align="left">
				<a href="HomeController">Ȩ</a>
				<a href="CalcController">����</a>
				<a href="BBController">���ھ߱�</a>
				<a href="KrageController">�ѱ�����</a>
				<a href="LottoController">�ζǻ̱�</a>
				<a href="JSTLFController">JSTLFormat</a>
			</td>
		</tr>
		<tr>
			<td id="content">
				<jsp:include page="${contentPage }"></jsp:include>
			</td>
			</tr>
	</table>
</body>
</html>