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
				<img src="s.png">
			</a>
		</td>
		<td align="center" class="what">
			<a href="HomeController?h=2">
				<img src="r.png">
			</a>
		</td>
		<td align="center" class="what">
			<a href="HomeController?h=3">
				<img src="p.png">
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
		<td align="center" colspan="3" class="resultTd2">승</td>
	</tr>
	<tr>
		<td align="center" colspan="3" class="resultTd2">1승 2무 3패</td>
	</tr>
</table>

	
</body>
</html>






