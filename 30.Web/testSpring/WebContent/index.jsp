<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Spring Hello</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			alert("button ready >>> : ");
			
			// GET 방식
			$(document).on("click", "#getbtn", function(){
				alert("getbtn >>> : 진입");
				
				$("#methodForm").attr({
					"action":"helloWorld_get.jso",
					"method":"GET",
					"enctype":"application/x-www-form-urlencoded"
				}).submit();
			});
			
			// POST 방식
			$(document).on("click", "#postbtn", function(){
				alert("postbtn >>> : 진입");
				
				$("#methodForm").attr({
					"action":"helloWorld_post.jso",
					"method":"POST",
					"enctype":"applicatin/x-www-form-urlencoded"
				}).submit();
			});
		});
	</script>
</head>
<body>
	<h3>Spring Hello</h3>
	<hr>
	<!-- java 서블릿 파일의 어노테이션이 동일한 부분으로 이동 -->
	<a href="helloWorld_Controller_find.jso">HelloWorld 실행</a><br/>
	<a href="helloWorld_get.jso">HelloWorld GET Method 실행</a><br/>
	<a href="helloWrold_post.jso">HelloWorld POST Method 실행</a><br/>
	<form name="methodForm" id="methodForm">
		<button type="button" id="getbtn">GET</button>
		<button type="button" id="postbtn">POST</button>
	</form>
	<hr>
	<a href="veiwJsp_1_stringTest_find.jso">viewJsp_1_stringTest_find.jso 실행</a><br/>
	<a href="viewJsp_2_modelandview_find.jso">viewJsp_2_modelandview_find.jso 실행</a><br/>
	<a href="viewJsp_3_voidTest_find.jso">viewJsp_3_voidTest_find.jso 실행</a><br/>
	<hr>
	<a href="formdata_find.jso">FORM DATA 실행</a>
</body>
</html>