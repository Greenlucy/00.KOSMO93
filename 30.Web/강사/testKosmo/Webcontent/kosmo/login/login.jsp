<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>LOGIN</title>
<style type="text/css">
	div,h3  {
		 text-align: center;
	}
			
	/* a 태그 밑줄 없애기 */
	a { text-decoration:none }
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
<h3>Login Session Testing :: LOGIN SUCCESS</h3>
<hr>
<% request.setCharacterEncoding("EUC-KR"); %>
<%
	Object obj = request.getAttribute("nCnt");
	if (obj == null) return;
	
	int nCnt = ((Integer)obj).intValue();
	
	if (nCnt == 1){
		String mid = request.getParameter("mid");
%>
		<script>
			alert("<%= mid %> 님 로그인 성공");
		</script>
		<div>
  			<a href="/testKosmo/login?login_type=LOOUT&mid=<%= mid %>">로그아웃 하기</a>
		</div>
<% 		
	}
%>
</body>
</html>