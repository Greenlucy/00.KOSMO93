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
			callAjax();
		});
	});
				
	function callAjax(){
		alert("callAjax() 함수 호출 성공  >>> : ");
		
		let urlVal = "/testCss/ajaxTest/data2.jsp";
		let typeVal = "POST";
		let idVal = $('#id').val();		
		// 요청하는 데이터 콘솔에 로그 찍어보기 
		alert("요청하는 데이터 콘솔에 로그 찍어보기  >>> : ");
		console.log("urlVal >>> : " + urlVal);
		console.log("typeVal >>> : " + typeVal);
		console.log("idVal >>> : " + idVal);
		
		$.ajax({	
			url : urlVal,				
			type : typeVal,					
			data : { idVal,	
				},
			
			success : whenSuccess,
			error : whenError
		});
		
		function whenSuccess(data){
			alert("리턴 데이터 >>> : " + data);
			
			// find() 함수
			// text() 함수 
			var boolVal = $(data).find("result").text();
			
			alert("boolVal >>> : " + boolVal);
			alert("typeof(boolVal) >>> : " + typeof(boolVal));
			console.log("boolVal >>> : " + boolVal);
			
			// eval() : 이발함수 : 자바스크립트 객체로 변환 : 사용금지 : 보안취약성에 위배
			var result = eval(boolVal);
			alert("result >>> : " + result);
			alert("typeof(result) >>> : " + typeof(result));
			console.log("result >>> : " + result);
			
			if (result){
				alert("성공");
				console.log("result >>> : " + result);
			}else{
				alert("실패");
				console.log("result >>> : " + result);
			}
		}
		
		function whenError(){
			alert("error");
		}				
	}

</script>		        
</head>
<body>		
	<form id="frm">			
		<label>아이디</label>
		<input name="id" id="id">
		<input id="button" type="button" value="버튼">			
	</form>			
</body>
</html>