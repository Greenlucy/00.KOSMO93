<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>도서정보 삭제</title>
</head>
<body>
	<% request.setCharacterEncoding("EUC-KR"); %>
	DELETE
	<%
		Object obj = request.getAttribute("nCntD");
		int nCntD = ((Integer)obj).intValue();
		
		if (nCntD > 0){
			System.out.println("bookDelete.jsp >>> : 삭제 성공 " + nCntD + " 건 <br>");
	%>
		<script>
			location.href="/testJso/book?isudtype=SALL";
		</script>
	<%
		}else{
			System.out.println("bookDelete.jsp >>> : 삭제 실패");
		}
	%>
</body>
</html>