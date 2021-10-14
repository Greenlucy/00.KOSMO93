<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>helloWorld_return_jspfile_name</title>
</head>
<body>
	<h3>RETURN JSP</h3>
	<hr>
	<h3>${ msg }</h3>
	<%
		/* 	서블릿 컨트롤러에서 받아옴
		model.addAttribute("msg", "Hello World Spring !!!! again >>> : ");
		*/
		String msg = String.valueOf(request.getAttribute("msg"));
		System.out.println("msg >>> : " + msg);
		out.println("msg >>> : " + msg);
	%>
</body>
</html>