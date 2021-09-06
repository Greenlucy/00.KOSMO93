<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
	<script type="text/javascript">
	
	</script>
	<style type="text/css">
	
	</style>
</head>
<body>
	Hello JSP !!! <br>
	<hr>
	<%
		out.println("스크립틀릿 태그 !!!" + "<br>");
		out.println("이 부분은 서버사이드 스크립트 영역으로 웹브라우저 영역에서 읽어줄 수 있다." + "<br>");
		out.println("서버에서 결과를 만들어서 웹브라우저에 전달된 내용만 읽어준다." + "<br>");
	%>
</body>
<?xml version="1.0" encoding="UTF-8" ?>
<root>
<test>test</test>
</root>
</html>
