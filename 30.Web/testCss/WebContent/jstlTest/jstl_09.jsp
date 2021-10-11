<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>jstl_09</title>
</head>
<body>
	<h3>jstl_09</h3>
	<hr>
	<c:set var="num" value="123456789" />
	<h3>���� ���� : ${ num }</h3>
	����1 : <fmt:formatNumber value="${ num }" groupingUsed="true"/><br/>
	����2 : <fmt:formatNumber value="${ num }" groupingUsed="false" /><br/>
	����3 : <fmt:formatNumber value="${ num }" pattern="#,##0" /><br/>
	����4 : <fmt:formatNumber value="${ num }" pattern="#,##0��" /><br/>
	<%--
		(������ ���� ��µ� ���)		
		���� ���� : 123456789
		����1 : 123,456,789		groupingUsed="true"
		����2 : 123456789			gruopingUsed="false"
		����3 : 123,456,789		pattern="#,##0"
		����4 : 123,456,789��		pattern="#,##0��"
	 --%>
	
	
	<h3>��Ÿ ���� : ��ȭ, �����</h3>
	<%-- ��ȭ ��ȣ�� �Է��� ��� Ư������ : �� > ���� --%>
	�ݾ�1 : <fmt:formatNumber value="${ num }" type="currency" currencySymbol="��"/><br/>
	�ݾ�2 : <fmt:formatNumber value="${ num }" type="currency" currencySymbol="��"/><br/>
	�ݾ�3 : <fmt:formatNumber value="${ num }" pattern="��#,##0��" /><br/>
	�����1 : <fmt:formatNumber value="0.123" type="percent" /><br/>
	�����2 : <fmt:formatNumber value="0.123" pattern="0.00%" /><br/>
	<%--
		(������ ���� ��µ� ���)
		��Ÿ ���� : ��ȭ, �����
		�ݾ�1 : ��123,456,789		type="currency"
		�ݾ�2 : ��123,456,789		type="currency"
		�ݾ�3 : ��123,456,789��		pattern="��#,##0��"
		�����1 : 12%				type="percent"
		�����2 : 12.30%			pattern="0.00%"
	 --%>
</body>
</html>