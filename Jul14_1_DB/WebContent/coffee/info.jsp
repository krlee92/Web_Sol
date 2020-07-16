<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
		<form action="CoffeeUpdateController">
			<tr>
				<td>
					<input name = "name" value="${c.name }" readonly="readonly">
				</td>
			</tr> 
			<tr>
				<td>
					<input name = "price" value="${c.price }">
				</td>
			</tr>
			<tr>
				<td>
					<button>수정</button>
		</form>
					<button onclick="deleteCoffee('${c.name}');">삭제</button>
				</td>
			</tr>
		</table>
</body>
</html>