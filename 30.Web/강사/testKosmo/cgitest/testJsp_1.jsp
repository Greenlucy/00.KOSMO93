<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!-- 
page : page ��Ƽ�� 
language="java" : �� ���������� ����ϴ� ���� �ڹ� �Դϴ� . ���� ���� 

contentType : ���� jsp ������ ��������(��������)�� ���ڵ� ����

text/html : MIME : �� ���� �������� html ������ �ϰ� �ִ�. 
	MIME : Multipurose Internet Mail Extensions : ���ڿ����� ���� ���ͳ� ǥ�� ����. 
			������ ���� �� ���ڵ� ���� ǥ�� 
charset="EUC-KR" : ���� jsp �������� ���ڵ��� EUC-KR �̴�. 
 -->

<!-- jsp ���Ͽ� ��ü�� �ҷ����� (import �ϱ� ) -->
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<!-- 
	�� �������� html�� ���ڵ��� EUC-KR �̴�. 
 -->
<meta charset="EUC-KR">
<title>jsp �±׵� </title>
</head>
<body>
<h3>JSP �±�(���, ������Ʈ) ����</h3>
<hr>
<%-- jsp �ּ� : ��������(Ŭ���̾�Ʈ)�� �Ѿ�� �ʴ´�.  --%>
<!-- ��ũ��Ʋ�� ���(�±�, ������Ʈ) -->
<%
	out.println("���� ��ũ��Ʋ�� �����̴�. <br>");
	out.println("�ڹ� �ڵ带 �����ϸ� �ȴ�. <br>");
	out.println("1. jsp ������ ������Ʈ  : request, response <br>");
	out.println("2. Servlet �ڵ� <br>");
	out.println("3. java �ڵ� <br>");
	out.println("4. ���α׷� ���� ����� Ŭ���̾�Ʈ�� �����Ѵ�. <br>");
	
	out.println(new Date() + "<br>");
%>
<!-- ǥ���� ���(�±�, ������Ʈ) -->
<%= "���� ǥ���� �����̴�." %><br>
<%= "�ϴ� ��Ȱ�� �������� ����� ����Ѵ�." %><br>
<%= "��ũ��Ʋ�� �������� ����ϴ� out.println() �� ���� ����̴�." %><br>
<%= new Date() %><br>

<!-- ���𸣵� ��Ƽ�� ���(�±�, ������Ʈ), ������ �ҷ����� : ������ ��� -->
<!-- ���������� footer �뵵�� ����Ѵ�.  -->
<%@ include file="testJsp.jsp" %>

</body>
</html>











