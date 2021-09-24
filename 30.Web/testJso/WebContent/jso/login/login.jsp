<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<title>LOGIN</title>
	<style type="text/css">
		div,h3 {
			text-align: center;
		}
		
		/* a 태그 밑줄 없애기 */
		a { text-decoration:none }
	</style>
</head>
<body>
	<% request.setCharacterEncoding("EUC-KR"); %>
	<h3>Login Session Testing :: LOGIN SUCCESS</h3>
	<%
		Object obj = request.getAttribute("nCntL");
		int nCntL = ((Integer)obj).intValue();
		
		if (nCntL > 0){
			String mid = request.getParameter("mid");
			out.println(mid + "님 로그인 성공");
	%>
		<script>
			alert("<%= mid %> 님 로그인 성공");
		</script>
		<div>
			<a href="/testJso/login?login_type=LOGOUT&mid=<%= mid %>">로그아웃 하기</a>
		</div>
	<% 
		}
	%>
</body>
</html>