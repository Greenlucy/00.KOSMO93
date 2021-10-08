<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<title>jstl_05</title>
	</head>
<body>
	<h3>jstl_05</h3>
	<hr>
	<%--
		JAVA �ݺ��� : for, while, do~while
		JSTL �ݺ��� : <c:forEach>���๮</c:forEach>
			<c:forEach var="�ݺ�������" begin="�ʱ갪" end="������" step="������">���๮</c:forEach>
	 --%>
	 JAVA �ݺ���(for)<br/>
	 <%
	 	for(int i=1; i <= 7; i++){
	 		out.println("<font size=" + i + ">" + i + " >>> : �ȳ��ϼ���</font><br/>");
	 	}
	 %>
	 <br/><br/>
	 
	 JSTL �ݺ���(c:forEach)<br/>
	 <c:forEach var="i" begin="1" end="7"> <!-- step�� ���� 1�̶�� ���������ϴ�. -->
	 	<font size="${i }" > ${ i } �ݰ����ϴ�.</font><br/>
	 </c:forEach>
	 <br/><br/>
	 
	 <c:forEach var="i" begin="1" end="7" step="2"><!-- step�� ���� 1�̶�� ���������ϴ�. -->
	 	<font size="${i }" > ${ i } �ݰ����ϴ�.</font><br/>
	 </c:forEach>
</body>
</html>