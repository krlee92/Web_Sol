<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="validCheck.js"></script>
<script type="text/javascript" src="VC2.js"></script>
</head>
<body>
<form action="HomeController" name="bb" onsubmit="return check();">
	<table>
		<tr>
			<th align="center">
				숫자야구
			</th>
		</tr>
		<tr>
			<td align="center">
				<input name="n">
			</td>
		</tr>
		<tr>
			<td align="center">
				숫자만 3자리, 중복숫자 x
			</td>
		</tr>
		<tr>
			<td align="center">
				<button>확인</button>
			</td>
		</tr>
	</table>
</form>
<hr>
${param.n }<p>
S : ${s }<p>
B : ${b }<p>
</body>
</html>