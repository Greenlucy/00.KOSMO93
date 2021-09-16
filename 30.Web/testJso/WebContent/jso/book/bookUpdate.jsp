<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>도서정보 수정</title>
</head>
<body>
	<h3>도서정보 수정</h3>
	<%
		Object obj = request.getAttribute("nCntU");
		int nCnt = ((Integer)obj).intValue();
		
		if (nCnt > 0){
			System.out.println("nCnt >>> : " + nCnt + " 건 수정 완료");
	%>
		<script type="text/javascript">
			location.href="/testJso/book?isudtype=SALL";
		</script>
	<%
		}
		
	%>
</body>
</html>