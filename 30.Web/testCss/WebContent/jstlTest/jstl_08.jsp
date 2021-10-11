<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %> 
<%@ page import="a.b.c.com.common.EL_MemberVO" %> 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 요건 제대로 되는건지 잘 모르겠다.... 
	 out.println(+ " : ")추가 후, 확신 : 제대로 나오는 것 맞네!! --%>
<%
	ArrayList<EL_MemberVO> list = new ArrayList<>();
	list.add(new EL_MemberVO("홍길동", "hong", "1234", 11, "서울특별시", "010-1111-1111"));
	list.add(new EL_MemberVO("홍길동", "hong", "1234", 22, "서울특별시", "010-1111-1111"));
	list.add(new EL_MemberVO("홍길동", "hong", "1234", 33, "서울특별시", "010-1111-1111"));
	list.add(new EL_MemberVO("홍길동", "hong", "1234", 44, "서울특별시", "010-1111-1111"));
	list.add(new EL_MemberVO("홍길동", "hong", "1234", 55, "서울특별시", "010-1111-1111"));
	
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>jstl_08</title>
</head>
<body>
	<h3>jstl_08</h3>
	<hr>
	JAVA for<br/>
	<ul>
		<%
			for(int i=0; i < list.size(); i++){
				out.println("<li>" + list.get(i).getIrum() + " : ");
				out.println(list.get(i).getId() + " : ");
				out.println(list.get(i).getPw() + " : ");
				out.println(list.get(i).getAge() + " : ");
				out.println(list.get(i).getAddr() + " : ");
				out.println(list.get(i).getTel() + "</li>");
			}
		%>
	</ul>
	<hr/>
	
	JAVA forEach<br/>
	<ul>
		<%
			for(EL_MemberVO mvo : list){
				out.println("<li>");
				out.println(mvo.getIrum() + " : ");
				out.println(mvo.getId() + " : ");
				out.println(mvo.getPw() + " : ");
				out.println(mvo.getAge() + " : ");
				out.println(mvo.getAddr() + " : ");
				out.println(mvo.getTel());
				out.println("</li>");
			}
		%>
	</ul>
	<hr/>
	EL 표기법<br/>
	<ul>
		<li>${ list[0].irum } ${ list[0].id } ${ list[0].pw } ${ list[0].age } ${ list[0].addr } ${ list[0].tel }</li>
		<li>${ list[1].irum } ${ list[1].id } ${ list[1].pw } ${ list[1].age } ${ list[1].addr } ${ list[1].tel }</li>
		<li>${ list[2].irum } ${ list[2].id } ${ list[2].pw } ${ list[2].age } ${ list[2].addr } ${ list[2].tel }</li>
		<li>${ list[3].irum } ${ list[3].id } ${ list[3].pw } ${ list[3].age } ${ list[3].addr } ${ list[3].tel }</li>
		<li>${ list[4].irum } ${ list[4].id } ${ list[4].pw } ${ list[4].age } ${ list[4].addr } ${ list[4].tel }</li>
	</ul>
	<hr/>
	JSTL core<br/>
	<ul>
		<c:forEach var="i" items="${ list }">
			<li>${ i.irum } ${ i.id } ${ i.pw } ${ i.age } ${ i.addr } ${ i.tel }</li>
		</c:forEach>
	</ul>
</body>
</html>