<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>read JSON</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		
		$('#btn').click(function(){
			alert('btn 진입 >>> : ');
	
			$.ajax({
				url : "data3.jsp",
				dataType : "json",				
				success : function(data){	
					console.log("data >>> : " + data);					
					
					var results = JSON.stringify(data);	
					alert("results >>> : " + results);	
					alert("results.bools >>> : " + results.bools);	
					console.log("results >>> : " + results);	
					console.log("results.bools >>> : " + results.bools);	
					
					var v = JSON.parse(results);
					console.log("v >>> : " + v);
					
					console.log("v >>> : " + v.bools);
					if (v.bools == "success"){
						alert("true");
						 $('#readJson').html("화면에 리턴 데이터 출력 : "  + v.bools);
					}else{
						alert("false");
					}
				},
				error : function(e){
					console.log("에러가 >>> : " + e.responseText);
				}
			});					
		});
	});			
</script>
</head>
<body>
<form>
	<input type="button" id="btn" value="클릭">
	<div id="readJson"></div>
</form>
</body>
</html>









