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
				<th id="title" align="left">&nbsp;����</th>
			</tr>
			<tr>
				<td id="menu">
					<a href="HomeController">Ȩ</a>
					<a href="AController">A</a>
					<a href="CalcController">����</a>
				</td>
			</tr>
			<tr>
				<td  >
					<ul>
					<li><a href="HomeController">Ȩ</a></li>
					<li><a href="AController">A</a></li>
					<li><a href="CalcController">����</a></li>
					<li><a href="CalcController">����</a></li>
					<li><a href="CalcController">����</a></li>
					<li><a href="CalcController">����</a></li>
					<li><a href="CalcController">����</a></li>
					<li><a href="CalcController">����</a></li>
					<li><a href="CalcController">����</a></li>
					<li><a href="CalcController">����</a></li>
					<li><a href="CalcController">����</a></li>
					<li><a href="CalcController">����</a></li>
					
					
					</ul>
				</td>
			</tr>
			<tr>
				<td>
					<table id="tt" align="center">
						<tr>
							<td align="center">
								<a href="HomeController">Ȩ</a>
							</td>	
							<td align="center">
								<a href="AController">A</a>
							</td>
							<td align="center">
								<a href="CalcController">����</a>
							</td>
						</tr>
					</table>
					<div id="ch_menu" align="center">
					<span>Ȩ</span>
					<span>A</span>
					<span>����</span>
					</div>
				</td>
			</tr>
			<tr>
			<!-- ���ѷ��� : include������ ��ã���� -->
				<td id="content">
					<jsp:include page="${contentPageHaha }"></jsp:include>
				</td>
			</tr>
		</table>
</body>
</html>