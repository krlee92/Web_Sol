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
				���ھ߱�
			</th>
		</tr>
		<tr>
			<td align="center">
				<input name="n">
			</td>
		</tr>
		<tr>
			<td align="center">
				���ڸ� 3�ڸ�, �ߺ����� x
			</td>
		</tr>
		<tr>
			<td align="center">
				<button>Ȯ��</button>
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