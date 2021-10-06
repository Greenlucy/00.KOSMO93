<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ID CHECK</title>
</head>
<body>
<h3>ID CHECK</h3>
<hr>
<%
	Object obj = request.getAttribute("idCheckVal");
	if(obj == null) return;
	
	String idCheckVal = (String)obj;	
	System.out.println("idCheckVal >>> : " + idCheckVal);
		
%>
<?xml version='1.0' encoding='UTF-8'?>
<login>
	<result><%= idCheckVal %></result>	
</login>
</body>
</html>