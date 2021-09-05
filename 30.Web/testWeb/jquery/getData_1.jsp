<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>getData JSP</title>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR"); %>		// 맨 위에 이거 쓰고 시작하기
<%
	String isudtype = request.getParameter("isudtype");
	String mnum = request.getParameter("mnum");
	String mname = request.getParameter("mname");
	String maddr = request.getParameter("maddr");
	
	out.println("getData_1.jsp 에 진입 >>> : <br>");
	out.println("isudtype >>> : " + isudtype + "<br>");
	out.println("mnum >>> : " + mnum + "<br>");
	out.println("mname >>> : " + mname + "<br>");
	out.println("maddr >>> : " + maddr + "<br>");
	
	System.out.println("isudtype >>> : " + isudtype);
	System.out.println("mnum >>> : " + mnum);
	System.out.println("mname >>> : " + mname);
	System.out.println("maddr >>> : " + maddr);	
%>
</body>
</html>
