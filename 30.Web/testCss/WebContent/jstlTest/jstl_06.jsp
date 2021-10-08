<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String[] fruit = {"���", "���", "������", "�ٳ���", "���ξ���"};
	pageContext.setAttribute("fruit", fruit);
	// ���� ���������� ����� ���ε� ��ü ����
	// fruit�� �ٸ� ���������� �Ѱܹ޾����� ���ε� ��ü�� ������ �ʿ䰡 ������
	// ���� ���������� ��������Ƿ� EL ǥ������� ����ϱ� ���� ��ü�� ������ �ʿ䰡 �ִ�.
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>jstl_06</title>
</head>
<body>
	<h3>jstl_06</h3>
	<hr>
	JAVA �ݺ���(�迭)<br/>
	<ul>
		<%
			for(int i=0; i < fruit.length; i++){
				out.println("<li>" + fruit[i] + "</li>");
			}
		%>
	</ul>
	
	<%--
		JSTL �ݺ��� : <c:forEach>���๮</c:forEach>
			<c:forEach var="�ݺ�������" items="${�迭��}" >���๮</c:forEach>
	 --%>
	 JSTL �ݺ���(�迭)<br/>
	 <ul>
	 	<c:forEach var="i" items="${ fruit }">
	 		<li>${ i }</li>
	 	</c:forEach>
	 </ul>
</body>
</html>