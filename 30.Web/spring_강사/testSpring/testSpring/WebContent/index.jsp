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
	// alert("ready >>> : ");
	
	// GET 방식
	$(document).on("click", "#getbtn", function(){
		alert("getbtn >>> : 진입 ");
		
		$("#methodForm").attr({
			"action":"helloWorld_get.hbe",
			"method":"GET",
			"enctype":"application/x-www-form-urlencoded"
		}).submit();
	});
	
	// POST 방식
	$(document).on("click", "#postbtn", function(){		
		alert("postbtn >>> : 진입 ");
		
		$("#methodForm").attr({
			"action":"helloWorld_post.hbe",
			"method":"POST",
			"enctype":"application/x-www-form-urlencoded"
		}).submit();
	});
})

</script>
</head>
<body>
<h3>Spring Hello</h3>
<hr>
<a href="helloWorld_Controller_find.hbe">HelloWorld 실행</a><br>
<a href="helloWorld_get.hbe">HelloWorld GET Method 실행</a><br>
<a href="helloWorld_post.hbe">HelloWorld POST Method 실행</a><br>
<form name="methodForm" id="methodForm">
	<button type="button" id="getbtn">GET</button>
	<button type="button" id="postbtn">POST</button>
</form>
<hr>
<a href="viewJsp_1_stringTest_find.hbe">viewJsp_1_stringTest_find.hbe 실행</a><br>
<a href="viewJsp_2_modelandview_find.hbe">viewJsp_2_modelandview_find.hbe 실행</a><br>
<a href="viewJsp_3_voidTest_find.hbe">viewJsp_3_voidTest_find.hbe 실행</a><br>
<hr>
<a href="formdata_find.hbe">FORM DATA 실행</a>
<hr>
<a href="autowired_test.hbe">오토와이어드(의존성 주입 : DI) 생성자 실행</a><br>
<a href="autowired_test_filed.hbe">오토와이어드(의존성 주입 : DI) 필드 실행</a><br>
</body>
</html>