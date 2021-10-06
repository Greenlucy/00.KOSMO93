<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>PW CHECK</title>
</head>
<body>
<h3>PW CHECK</h3>
<hr>
<%
	Object obj = request.getAttribute("pwCheckVal");
	if(obj == null) return;
	
	String pwCheckVal = (String)obj;	
	System.out.println("pwCheckVal >>> : " + pwCheckVal);
		
%>
<?xml version='1.0' encoding='UTF-8'?>
<login>
	<result><%= pwCheckVal %></result>	
</login>
</body>
</html>