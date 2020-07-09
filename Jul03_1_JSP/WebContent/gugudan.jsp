<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	table{
		float:left;
	}
	
.r0{
	background-color: #006622;
	color : white;
}

.r1{
	color:#0D47A1;
}	
</style>
</head>
<body>
<%
	int start = Integer.parseInt(request.getParameter("start"));
	int end = Integer.parseInt(request.getParameter("end"));
	
	for(int dan= start; dan<= end; dan++){
		
%>
	<table border="1">
		<tr>
			<th><%=dan %>단</th>
		</tr> 
		<%
			for(int i=1; i<= 9; i++){
				
		%>
				<tr>
					<td class="r<%=i%2 %>"><%=dan %>x<%=i %> = <%=dan*i %></td>
				</tr>				
		<%
			}
	}
		%>
	</table>
</body>
</html>