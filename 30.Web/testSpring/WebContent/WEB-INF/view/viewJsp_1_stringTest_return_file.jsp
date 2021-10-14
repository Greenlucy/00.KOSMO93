<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Model Return Test</title>
</head>
<body>
	<h3>Model Return Test</h3>
	<hr>
	<h3> 컨트롤러에서 받아온 mdata :: ${ mdata }</h3>
	view 페이지에 데이터 전달은 Model 인터페이스<br>
	view 페이지 찾기는 함수의 String 리턴형 value를 이용<br>	
	<%
		String mdata = String.valueOf(request.getAttribute("mata"));
	%>
</body>
</html>