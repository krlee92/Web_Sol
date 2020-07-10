<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form name="calcForm" onsubmit="return calcCheck();" action="CalcController" method="post"  >
		x :<input name="x" class="calcInput" placeholder="x"><p>
		y :<input name="y" class="calcInput" placeholder="y"><p>
		<button id="calcBtn">계산</button>
	</form>
</body>
</html>