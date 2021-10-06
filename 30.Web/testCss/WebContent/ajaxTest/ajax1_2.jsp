<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> Ajax Test </title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$('#button').click(function(){
			alert("button 함수 클릭 성공 >>> : ");			
			
			let urlVal = "/testCss/ajaxTest/data1.jsp";
			let typeVal = "GET"
			let idVal = $('#id').val();
					
			alert("urlVal >>> : " + urlVal);
			alert("typeVal >>> : " + typeVal);
			alert("idVal >>> : " + idVal);
			console.log("urlVal >>> : " + urlVal);
			console.log("typeVal >>> : " + typeVal);
			console.log("idVal >>> : " + idVal);
			
			$.ajax({			
					url : urlVal,		
					type : typeVal,			
					data : {					
						id : idVal,	// data 는 쿼리 스트링 				
					},
					success : whenSuccess,					
					error : whenError
			}); // end of ajax()
			
			function whenSuccess(resData){
				alert("리턴 데이터 >>> : " + resData);
				$('#ajaxResData').html("화면에 리턴 데이터 출력 : "  + resData);
				console.log("콘솔에 리턴 데이터 출력 : " + resData);
			}
			function whenError(){
				alert("error");
			}
		});
	});
</script>		        
</head>
<body>		
<form id="frm">			
	<label>아이디</label><input name="id" id="id">
	<input id="button" type="button" value="버튼">			
</form>
<div id="ajaxResData">리턴 데이터</div>		
</body>
</html>







