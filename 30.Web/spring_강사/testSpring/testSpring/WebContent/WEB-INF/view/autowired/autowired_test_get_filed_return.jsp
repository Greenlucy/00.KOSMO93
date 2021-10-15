<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="a.b.c.com.vo.FormDataVO" %>
<%@ page import="java.util.List" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>autowired_test_get_filed_return</title>
</head>
<body>
<h3>autowired_test_get_filed_return</h3>
<hr>
<%

	Object obj = request.getAttribute("list");	
	if (obj == null) return;
		
	List<FormDataVO> list = (List)obj;		
	if (list.size() > 0){
		
		FormDataVO fdvo = list.get(0);
		out.println("fdvo.getDatanum() >>> : " + fdvo.getDatanum() + "<br>");
		out.println("fdvo.getDataid() >>> : " + fdvo.getDataid() + "<br>");
		out.println("fdvo.getDatapw() >>> : " + fdvo.getDatapw() + "<br>");
		out.println("fdvo.getDataname() >>> : " + fdvo.getDataname() + "<br>");
	}
%>
</body>
</html>