<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>�Խ��� JSP</title>
</head>
<body>
	<h3>�Խ��� JSP</h3>
	<hr>
<%-- �ѱ� ���ڵ� : form �±��� method�� ���� POST�� �� ���� --%>
<% request.setCharacterEncoding("EUC-KR"); %>
<%
	String isud_type= request.getParameter("ISUD_TYPE");
	String bnum = request.getParameter("bnum");
	String bsubject = request.getParameter("bsubject");
	String bwriter = request.getParameter("bwriter");
	String bpw = request.getParameter("bpw");
	String bmemo = request.getParameter("bmemo");
	String bphoto = request.getParameter("bphoto");
	
	out.println("isud_type >>> : " + isud_type + "<br>");
	out.println("bnum >>> : " + bnum + "<br>");
	out.println("bsubject >>> : " + bsubject + "<br>");
	out.println("bwriter >>> : " + bwriter + "<br>");
	out.println("bpw >>> : " + bpw + "<br>");
	out.println("bmemo >>> : " + bmemo + "<br>");
	out.println("bphoto >>> : " + bphoto + "<br>");
%>
</body>
</html>