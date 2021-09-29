<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    	String pagefile=request.getParameter("page");
    
    	if(pagefile==null){
    		pagefile="newitem";
    	}
    	
    	String pagefileex=".jsp";
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		* {
			margin: 0;
			padding: 0;
		}
		
		div#wrapper {
			background: yellow;
			border: 1px solid red;
			width: 800px;
			height: 600px;
			margin: 100px auto;
			overflow: hidden;
		}
		
		div#header {
			float: left;
			width: 100%;
			height: 20%;
			border: 1px solid red;
		}
		
		div#sidebar {
			background: orange;
			float: left;
			width: 15%;
			height: 60%;
			text-align: center;
			border: 1px solid red;
		}
		
		div#contents {
			background: cyan;
			float: left;
			width: 84%;
			height: 60%;
			text-align: center;
		}
		
		div#footer {
			background: gray;
			float: left;
			width: 100%;
			height: 20%;
			border: 1px solid red;
		}
	</style>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="top.jsp" />
		</div>
		
		<div id="sidebar">
			<jsp:include page="left.jsp" />
		</div>
		
		<div id="contents">
			<jsp:include page="<%=pagefile+pagefileex %>" />
		</div>
		
		<div id="footer">
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>