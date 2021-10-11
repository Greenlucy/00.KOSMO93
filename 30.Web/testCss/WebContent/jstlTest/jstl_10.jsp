<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>jstl_10</title>
</head>
<body>
	<h3>jstl_10</h3>
	<hr>
	<c:set var="date" value="<%= new Date() %>" />
	<h3>��¥�� �ð��� �⺻���� ǥ�� : ${ date }</h3>
	������ ��¥ : <fmt:formatDate value="${ date }" type="date" /><br/>
	������ �ð� : <fmt:formatDate value="${ date }" type="time" /><br/>
	��¥�� �ð� : <fmt:formatDate value="${ date }" type="both" /><br/>
	Short : <fmt:formatDate value="${ date }" type="both" dateStyle="short" timeStyle="short" /><br/>
	Medium : <fmt:formatDate value="${ date }" type="both" dateStyle="medium" timeStyle="medium" /><br/>
	Long : <fmt:formatDate value="${ date }" type="both" dateStyle="long" timeStyle="long" /><br/>
	Full : <fmt:formatDate value="${ date }" type="both" dateStyle="full" timeStyle="full" /><br/>
	Pattern1 : <fmt:formatDate value="${ date }" type="date" pattern="yyyy�� MM�� dd��(E)" /><br/>
	Pattern2 : <fmt:formatDate value="${ date }" type="time" pattern="(a) hh�� mm��" /><br/>
	<%--
		(�������� ��µ� ����)
		��¥�� �ð��� �⺻���� ǥ�� : Mon Oct 11 15:40:17 KST 2021
		������ ��¥ : 2021. 10. 11							type="date"
		������ �ð� : ���� 3:40:17							type="time"
		��¥�� �ð� : 2021. 10. 11 ���� 3:40:17				type="both"
		Short : 21. 10. 11 ���� 3:40						(date, timeStyle="short" �б�����)
		Medium : 2021. 10. 11 ���� 3:40:17					(date, timeStyle="medium" 2021ǥ�� / �ʱ�����)
		Long : 2021�� 10�� 11�� (��) ���� 3�� 40�� 17��			(date, timeStyle="long" ��,��,��(����) ǥ�� / ��,��,�� ��������)
		Full : 2021�� 10�� 11�� ������ ���� 3�� 40�� 17�� KST		(date, timeStyle="full" ��,��,��,���� ǥ�� / KST����)
		Pattern1 : 2021�� 10�� 11��(��)						���� ������ ���� : yyyy�� MM�� dd��(E)
		Pattern2 : (����) 03�� 40��						���� ������ ���� : (a) hh�� mm��
	 --%>
	
	<br/><hr/><br/>
	<%
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��");
	%>
	JAVA : <%= now %><br/>
	JAVA Format : <%= sdf.format(now) %>
	<%--
		(�������� ��µ� ����)
		JAVA : Mon Oct 11 15:40:17 KST 2021
		JAVA Format : 2021�� 10�� 11�� 15�� 40�� 17��
	 --%>
</body>
</html>