<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="CoffeeRegController" method="post"
	 
		name="coffeeRegForm"
		onsubmit="return coffeeRegCheck();">
		<table id="coffeeRegTbl">
			<tr>
				<th>�޴����</th>
			</tr>
			<tr>
				<td align="center">
				${r }
					<input name="c_name" placeholder="�޴���" maxlength="10" autocomplete="off" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input name="c_price" placeholder="����" maxlength="5" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>���</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>