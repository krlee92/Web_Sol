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
		// ������ ���ε� �� ����(�������� ������)
	String path = request.getSession().getServletContext().getRealPath("p");

	// request : ��� ����(�⺻��)
	// mr : �ڽ� ����
	MultipartRequest mr = new MultipartRequest(request, path, 10485760, "euc-kr", new DefaultFileRenamePolicy());

	String name = mr.getParameter("n");
	int height = Integer.parseInt(mr.getParameter("h"));
	int weight = Integer.parseInt(mr.getParameter("w"));
	String photo = mr.getFilesystemName("p");
	photo = URLEncoder.encode(photo, "euc-kr");
	photo = photo.replace("+", " ");

	double h2 = height / 100.0;
	double bmi = (double) weight / (h2 * h2);

	String result = "��ü��";
	if (bmi >= 40) {
		result = "�� ��";
	} else if (bmi >= 35) {
		result = "�ߵ ��";
	} else if (bmi >= 30) {
		result = "�浵 ��";
	} else if (bmi >= 25) {
		result = "��ü��";
	} else if (bmi >= 18.5) {
		result = "����";
	}
	%>
	<table>
		<tr>
			<th>�˻� ���</th>
		</tr>
		<tr>
			<td align="center">
				<img src="p/<%=photo%>">
			</td>
		</tr>
		<tr>
			<td class="td1">�̸�</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;<%=name %><br><br></td>
		</tr>
		<tr>
			<td class="td1">Ű</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;<%=height %>cm<br><br></td>
		</tr>
		<tr>
			<td class="td1">������</td>
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







