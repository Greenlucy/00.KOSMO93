<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	ArrayList<String> list = new ArrayList<>();
	list.add("���");
	list.add("���");
	list.add("������");
	list.add("�ٳ���");
	list.add("���ξ���");
	
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>jstl_07</title>
</head>
<body>
	<h3>jstl_07</h3>
	<hr>
	JAVA for<br/>
	<ul>
		<%
			for(int i=0; i < list.size(); i++){
				out.println("<li>" + list.get(i) + "</li>");
			}
		%>
	</ul>
	<hr/>
	JAVA forEach<br/>
	<ul>
		<%
			for(String str : list){
				out.println("<li>" + str + "</li>");
			}
		%>
	</ul>
	<hr/>
	EL ǥ���<br/>
	<ul>
		<li>${ list[0] }</li>
		<li>${ list[1] }</li>
		<li>${ list[2] }</li>
		<li>${ list[3] }</li>
		<li>${ list[4] }</li>
	</ul>
	<hr/>
	JSTL core<br/>
	<ul>
		<c:forEach var="i" items="${ list }">
			<li>${ i }</li>
		</c:forEach>
	</ul>
</body>
</html>