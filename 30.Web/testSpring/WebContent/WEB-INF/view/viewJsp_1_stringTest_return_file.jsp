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
	<h3> ��Ʈ�ѷ����� �޾ƿ� mdata :: ${ mdata }</h3>
	view �������� ������ ������ Model �������̽�<br>
	view ������ ã��� �Լ��� String ������ value�� �̿�<br>	
	<%
		String mdata = String.valueOf(request.getAttribute("mata"));
	%>
</body>
</html>