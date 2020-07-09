<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="NewFile.css">
</head>
<body>
	<%
		// 사진이 업로드 될 폴더(서버상의 절대경로)
	String path = request.getSession().getServletContext().getRealPath("p");

	// request : 비닐 포장(기본값)
	// mr : 박스 포장
	MultipartRequest mr = new MultipartRequest(request, path, 10485760, "euc-kr", new DefaultFileRenamePolicy());

	String name = mr.getParameter("n");
	int height = Integer.parseInt(mr.getParameter("h"));
	int weight = Integer.parseInt(mr.getParameter("w"));
	String photo = mr.getFilesystemName("p");
	photo = URLEncoder.encode(photo, "euc-kr");
	photo = photo.replace("+", " ");

	double h2 = height / 100.0;
	double bmi = (double) weight / (h2 * h2);

	String result = "저체중";
	if (bmi >= 40) {
		result = "고도 비만";
	} else if (bmi >= 35) {
		result = "중등도 비만";
	} else if (bmi >= 30) {
		result = "경도 비만";
	} else if (bmi >= 25) {
		result = "과체중";
	} else if (bmi >= 18.5) {
		result = "정상";
	}
	%>
	<table>
		<tr>
			<th>검사 결과</th>
		</tr>
		<tr>
			<td align="center">
				<img src="p/<%=photo%>">
			</td>
		</tr>
		<tr>
			<td class="td1">이름</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;<%=name %><br><br></td>
		</tr>
		<tr>
			<td class="td1">키</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;<%=height %>cm<br><br></td>
		</tr>
		<tr>
			<td class="td1">몸무게</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;<%=weight %>kg<br><br></td>
		</tr>
		<tr>
			<td class="td1">BMI</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;<%=bmi %><br><br></td>
		</tr>
		<tr>
			<td align="center" style="color:red; font-weight: 900; font-size: 15pt;">
				<%=result %><br><br>
			</td>
		</tr>
	</table>
</body>
</html>







