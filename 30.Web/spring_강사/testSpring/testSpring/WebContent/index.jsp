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
	
	// GET ���
	$(document).on("click", "#getbtn", function(){
		alert("getbtn >>> : ���� ");
		
		$("#methodForm").attr({
			"action":"helloWorld_get.hbe",
			"method":"GET",
			"enctype":"application/x-www-form-urlencoded"
		}).submit();
	});
	
	// POST ���
	$(document).on("click", "#postbtn", function(){		
		alert("postbtn >>> : ���� ");
		
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
<a href="helloWorld_Controller_find.hbe">HelloWorld ����</a><br>
<a href="helloWorld_get.hbe">HelloWorld GET Method ����</a><br>
<a href="helloWorld_post.hbe">HelloWorld POST Method ����</a><br>
<form name="methodForm" id="methodForm">
	<button type="button" id="getbtn">GET</button>
	<button type="button" id="postbtn">POST</button>
</form>
<hr>
<a href="viewJsp_1_stringTest_find.hbe">viewJsp_1_stringTest_find.hbe ����</a><br>
<a href="viewJsp_2_modelandview_find.hbe">viewJsp_2_modelandview_find.hbe ����</a><br>
<a href="viewJsp_3_voidTest_find.hbe">viewJsp_3_voidTest_find.hbe ����</a><br>
<hr>
<a href="formdata_find.hbe">FORM DATA ����</a>
<hr>
<a href="autowired_test.hbe">������̾��(������ ���� : DI) ������ ����</a><br>
<a href="autowired_test_filed.hbe">������̾��(������ ���� : DI) �ʵ� ����</a><br>
</body>
</html>