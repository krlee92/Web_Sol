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
	<h1>����������</h1><p>
	<h3>1. ����</h3><p>
	<h3>1. ����</h3><p>
	<h3>1. ��</h3>
	�� : <input name = "userhand"><p>
	<button>����</button>
	</form> -->
	
	<table>
	<tr>
		<th colspan="3">����������</th>
	</tr>
	<tr>
		<td align="center" colspan="3" id="whatTitle" >��</td>
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
		<td align="center" colspan="3" id="resultTitle" >���</td>
	</tr>
	<tr>
		<td align="center" class="resultTd1">
			��
		</td>
		<td align="center" class="resultTd1">
			
		</td>
		<td align="center" class="resultTd1">
			��
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
		<td align="center" colspan="3" class="resultTd2">${win }��${draw }��${lose }��</td>
	</tr>
</table>

	
	
	
	

</body>
</html>