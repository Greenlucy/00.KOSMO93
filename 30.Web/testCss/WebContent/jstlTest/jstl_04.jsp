<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>jstl_04</title>
</head>
<body>
	<h3>jstl_04</h3>
	<hr>
	<!-- jstl_04.jsp?num=1 -->
	<!-- jstl_04.jsp?num=2 -->
	<!-- jstl_04.jsp?num=3 -->
	<%
		// Integer.parseInt() : String > int�� �ٲ��ִ� �Լ� :: null���� ���� �� �ؼ�
		// int num = Integer.parseInt(request.getParameter("num")); �ϸ� HTTP ���� 500 ���� �߻� ��.
		int num = Integer.parseInt(request.getParameter("num"));
		if(num == 1){
			out.println("ó�� �˰ڽ��ϴ�. (java:if)");
		}else if(num == 2){
			out.println("�ȳ��ϼ���. (java:if)");
		}else{
			out.println("�ݰ����ϴ�. (java:if)");
		}
	%>
	<br/><br/>
	<c:if test="${ param.num == 1 }" >ó�� �˰ڽ��ϴ�. (c:if)</c:if>
	<c:if test="${ param.num == 2 }" >�ȳ��ϼ���. (c:if)</c:if>
	<c:if test="${ param.num == 3 }" >�ݰ����ϴ�. (c:if)</c:if>
	<br/><br/>
	
	<%--
		JAVA : switch(�񱳰�) case ���ذ� default
		JSTL core : <c:choose>
						<c:when test="���ǽ�">���๮</c:when>
						<c:when test="���ǽ�">���๮</c:when>
						<c:otherwise>���๮</c:otherwise>
					</c:choose>
	 --%>
	 <%
	 	switch(num) {
	 	case 1 :
	 			out.println("ó�� �˰ڽ��ϴ�. (java:switch)");
	 			break;
	 	case 2 :
	 			out.println("�ȳ��ϼ���. (java:switch)");
	 			break;
	 	default :
	 			out.println("�ݰ����ϴ�. (java:switch)");
	 			break;
	 	}
	 %>
	 <br/><br/>
	 <c:choose>
	 	<c:when test="${ param.num == 1 }">ó�� �˰ڽ��ϴ�. (c:choose)</c:when>
	 	<c:when test="${ param.num == 2 }">�ȳ��ϼ���. (c:choose)</c:when>
	 	<c:otherwise>�ݰ����ϴ�. (c:choose)</c:otherwise>
	 </c:choose>
</body>
</html>