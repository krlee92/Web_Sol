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
		<table id="site" border="1">
			<tr>
				<th id="title" align="left">&nbsp;제목</th>
			</tr>
			<tr>
				<td id="menu">
					<a href="HomeController">홈</a>
					<a href="AController">A</a>
					<a href="CalcController">덧셈</a>
				</td>
			</tr>
			<tr>
				<td  >
					<ul>
					<li><a href="HomeController">홈</a></li>
					<li><a href="AController">A</a></li>
					<li><a href="CalcController">덧셈</a></li>
					<li><a href="CalcController">덧셈</a></li>
					<li><a href="CalcController">덧셈</a></li>
					<li><a href="CalcController">덧셈</a></li>
					<li><a href="CalcController">덧셈</a></li>
					<li><a href="CalcController">덧셈</a></li>
					<li><a href="CalcController">덧셈</a></li>
					<li><a href="CalcController">덧셈</a></li>
					<li><a href="CalcController">덧셈</a></li>
					<li><a href="CalcController">덧셈</a></li>
					
					
					</ul>
				</td>
			</tr>
			<tr>
				<td>
					<table id="tt" align="center">
						<tr>
							<td align="center">
								<a href="HomeController">홈</a>
							</td>	
							<td align="center">
								<a href="AController">A</a>
							</td>
							<td align="center">
								<a href="CalcController">덧셈</a>
							</td>
						</tr>
					</table>
					<div id="ch_menu" align="center">
					<span>홈</span>
					<span>A</span>
					<span>덧셈</span>
					</div>
				</td>
			</tr>
			<tr>
			<!-- 무한루프 : include페이지 못찾을때 -->
				<td id="content">
					<jsp:include page="${contentPageHaha }"></jsp:include>
				</td>
			</tr>
		</table>
</body>
</html>