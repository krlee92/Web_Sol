<%@page import="com.lee.jm2.main.Dog"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lee.jm2.main.Result"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ 4��Ÿ��</title>
<link rel="stylesheet" href="bb.css">
</head>
<body>
	<%
		Result r = (Result) request.getAttribute("r");
//	 	V(.jsp)�� �ڹ��ڵ尡
// 		.jsp�� �ڹ��ڵ� ���� ����
//			�� ������ - EL

//			for, if - CustomTag
//			������� ����
//			������ �̵�
//			������
	%>
	
	<table id="t2" style="background-image: url('<%=r.getImg() %>');">
		<tr>
			<th><span id="s1">����</span>�� <span id="s2">4</span>��Ÿ���� ����</th>
		</tr>
		<tr>
			<td align="center">
				<%=r.getTasu()%>Ÿ��
			</td>
		</tr>
		<tr>
			<td align="center">
				<%=r.getAnta()%>��Ÿ
			</td>
		</tr>
		<tr>
			<td align="center">
				<%=r.getTayul()%>
			</td>
		</tr>
	</table>
	
	<hr>
<%
	// parameter �б�
	String tasu = request.getParameter("tasu");
	int tasu2 = Integer.parseInt(tasu);
	
	// attribute �б�
	Object aaa = request.getAttribute("aa");
	Integer aaaa = (Integer) aaa;
	int aaaaa = aaaa.intValue();
	
	// attribute �б�(��ü ArrayList)
	Object ds = request.getAttribute("ds");
	ArrayList<Dog> dsds = (ArrayList) ds;
	
	
%>	
�Ķ���� : <%=tasu %>
��Ʈ����Ʈ(int) : <%=aaaaa %>
��Ʈ����Ʈ(��üAL) : <%=dsds.get(1).getName() %>)
<hr>
<%
	// Expression Language : EL
	//		�� ������ ���
	//		���� ������ �׳� ���°�(exception������)
	//		����ȯ �ڵ�
	//		������ ��� ����
	//		�����δ� �ڹ� �ڵ�� �ٲ� ����
	
	//		${XXX}
	// 		�Ķ���� �б� : ${param.�Ķ���͸�}
	//		��Ʈ����Ʈ �б� : ${��Ʈ����Ʈ��}
	//		��Ʈ����Ʈ(��ü) �б� : ${��Ʈ����Ʈ��.���������} - getterȣ��
	//			request.setAttribute("r"<--��Ʈ����Ʈ��, r); , private String tayul<--���������;
	//		��Ʈ����Ʈ(��üAL) �б� : ${��Ʈ����Ʈ��[�ε���].���������}
	
	
%>
�Ķ���� : ${param.tasu }<p>
�Ķ���� : ${param.fddfg }<p>
�Ķ���� : ${param.tasu + 5 }<p>
�Ķ���� : ${param.anta / param.tasu }<p>
��Ʈ����Ʈ(int) : ${aa }<p>
<!-- ��Ʈ����Ʈ(��ü) : ${r }<p> �ּҰ� ���� -->
��Ʈ����Ʈ(��ü) : ${r.tayul }<p> <!-- �����δ� r.getterȣ���Ѱ� -->
��Ʈ����Ʈ(��ü) : ${dd.name }, ${dd.age }<p>
��Ʈ����Ʈ(��üAL) : ${ds[1].name }<p>



</body>
</html>