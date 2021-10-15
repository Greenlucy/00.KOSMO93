<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>formdata_get_servlet</title>
</head>
<body>
<h3>formdata_get_servlet</h3>
<hr>
<h3>스프링 콘트롤러에서 request 객체로 받아오기</h3> 
<hr>
<%
	String datanum = request.getParameter("datanum");
	String dataid = request.getParameter("dataid");
	String datapw = request.getParameter("datapw");
	String dataname = request.getParameter("dataname");
	System.out.println("formdata_get_servlet.jsp :::: datanum >>> : " + datanum);
	System.out.println("formdata_get_servlet.jsp :::: dataid >>> : " + dataid);
	System.out.println("formdata_get_servlet.jsp :::: datapw >>> : " + datapw);
	System.out.println("formdata_get_servlet.jsp:::: dataname >>> : " + dataname);	
	out.println("formdata_get_servlet.jsp :::: datanum >>> : " + datanum + "<br>");
	out.println("formdata_get_servlet.jsp :::: dataid >>> : " + dataid + "<br>");
	out.println("formdata_get_servlet.jsp :::: datapw >>> : " + datapw + "<br>");
	out.println("formdata_get_servlet.jsp :::: dataname >>> : " + dataname + "<br>");
%>
<p>
<h3>스프링 콘트롤러에서 el 객체로 받아오기</h3> 
<hr>
${el_datanum }<br>
${el_dataid }<br>
${el_datapw }<br>
${el_dataname}<br>
<h3>스프링 콘트롤러에서 request.setAttribute() 객체로 받아오기</h3> 
<hr>
${request_datanum }<br>
${request_dataid }<br>
${request_datapw }<br>
${request_dataname }<br>
</body>
</html>