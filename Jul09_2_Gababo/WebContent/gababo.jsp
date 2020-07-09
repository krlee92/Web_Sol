<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="rsp.css">
</head>
<body>
	<!--  <form action="HomeController" > 
	<h1>가위바위보</h1><p>
	<h3>1. 가위</h3><p>
	<h3>1. 바위</h3><p>
	<h3>1. 보</h3>
	뭐 : <input name = "userhand"><p>
	<button>내기</button>
	</form> -->
	
	<table>
	<tr>
		<th colspan="3">가위바위보</th>
	</tr>
	<tr>
		<td align="center" colspan="3" id="whatTitle" >뭐</td>
	</tr>
	<tr>
		<td align="center" class="what">
			<a href="HomeController?h=1">
				<img src="3.png">
			</a>
		</td>
		<td align="center" class="what">
			<a href="HomeController?h=2">
				<img src="1.png">
			</a>
		</td>
		<td align="center" class="what">
			<a href="HomeController?h=3">
				<img src="2.png">
			</a>
		</td>
	</tr>
	<tr>
		<td align="center" colspan="3" id="resultTitle" >결과</td>
	</tr>
	<tr>
		<td align="center" class="resultTd1">
			나
		</td>
		<td align="center" class="resultTd1">
			
		</td>
		<td align="center" class="resultTd1">
			컴
		</td>
	</tr>
	<tr>
		<td align="center" class="resultTd1">
			<img src="${userHand }">
		</td>
		<td align="center" class="resultTd1">
			VS
		</td>
		<td align="center" class="resultTd1">
			<img src="${comHand }">
		</td>
	</tr>
	<tr>
		<td align="center" colspan="3" class="resultTd2">${result }</td>
	</tr>
	<tr>
		<td align="center" colspan="3" class="resultTd2">${win }승${draw }무${lose }패</td>
	</tr>
</table>

	
	
	
	

</body>
</html>