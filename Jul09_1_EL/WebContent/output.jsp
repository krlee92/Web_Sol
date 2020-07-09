<%@page import="com.lee.jm2.main.Dog"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lee.jm2.main.Result"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>강남의 4번타자</title>
<link rel="stylesheet" href="bb.css">
</head>
<body>
	<%
		Result r = (Result) request.getAttribute("r");
//	 	V(.jsp)에 자바코드가
// 		.jsp에 자바코드 언제 쓰나
//			값 받을때 - EL

//			for, if - CustomTag
//			출력형식 지정
//			페이지 이동
//			공사중
	%>
	
	<table id="t2" style="background-image: url('<%=r.getImg() %>');">
		<tr>
			<th><span id="s1">강남</span>의 <span id="s2">4</span>번타자의 성적</th>
		</tr>
		<tr>
			<td align="center">
				<%=r.getTasu()%>타수
			</td>
		</tr>
		<tr>
			<td align="center">
				<%=r.getAnta()%>안타
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
	// parameter 읽기
	String tasu = request.getParameter("tasu");
	int tasu2 = Integer.parseInt(tasu);
	
	// attribute 읽기
	Object aaa = request.getAttribute("aa");
	Integer aaaa = (Integer) aaa;
	int aaaaa = aaaa.intValue();
	
	// attribute 읽기(객체 ArrayList)
	Object ds = request.getAttribute("ds");
	ArrayList<Dog> dsds = (ArrayList) ds;
	
	
%>	
파라메터 : <%=tasu %>
어트리뷰트(int) : <%=aaaaa %>
어트리뷰트(객체AL) : <%=dsds.get(1).getName() %>)
<hr>
<%
	// Expression Language : EL
	//		값 읽을때 사용
	//		값이 없으면 그냥 없는거(exception안터짐)
	//		형변환 자동
	//		연산자 사용 가능
	//		실제로는 자바 코드로 바뀌어서 실행
	
	//		${XXX}
	// 		파라메터 읽기 : ${param.파라메터명}
	//		어트리뷰트 읽기 : ${어트리뷰트명}
	//		어트리뷰트(객체) 읽기 : ${어트리뷰트명.멤버변수명} - getter호출
	//			request.setAttribute("r"<--어트리뷰트명, r); , private String tayul<--멤버변수명;
	//		어트리뷰트(객체AL) 읽기 : ${어트리뷰트명[인덱스].멤버변수명}
	
	
%>
파라메터 : ${param.tasu }<p>
파라메터 : ${param.fddfg }<p>
파라메터 : ${param.tasu + 5 }<p>
파라메터 : ${param.anta / param.tasu }<p>
어트리뷰트(int) : ${aa }<p>
<!-- 어트리뷰트(객체) : ${r }<p> 주소가 찍힘 -->
어트리뷰트(객체) : ${r.tayul }<p> <!-- 실제로는 r.getter호출한거 -->
어트리뷰트(객체) : ${dd.name }, ${dd.age }<p>
어트리뷰트(객체AL) : ${ds[1].name }<p>



</body>
</html>