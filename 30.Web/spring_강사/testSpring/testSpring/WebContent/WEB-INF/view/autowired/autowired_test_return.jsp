<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>AUTOWIRED TEST</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		// alert("ready >>> : ");
		
		// GET 방식
		$(document).on("click", "#getbtn", function(){
			alert("getbtn >>> : 진입 ");
			
			$("#formData").attr({
				"action":"autowired_test_get.hbe",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();		
		});		
	})

</script>
</head>
<body>
<h3 align="center">FORM DATA AUTOWIRED CONSTRUCTOR</h3>
<hr>
<form name="formData" id="formData">
<table border="1" align="center">
	<tr>
		<td>회원번호 : </td>
		<td><input type="text" name="datanum" id="datanum"></td>
	</tr>
	<tr>
		<td>아이디 : </td>
		<td><input type="text" name="dataid" id="dataid"></td>
	</tr>
	<tr>
		<td>비밀번호 : </td>
		<td><input type="text" name="datapw" id="datapw"></td>
	</tr>
	<tr>
		<td>이름 : </td>
		<td><input type="text" name="dataname" id="dataname"></td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" id="getbtn">GET AUTOWIRED CONSTRUCTOR</button>			
		</td>
	</tr>
</table>
</form>
</body>
</html>