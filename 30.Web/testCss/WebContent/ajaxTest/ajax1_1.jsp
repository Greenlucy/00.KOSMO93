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
	
		// 예약어(키워드)를 ajax() 함수 안에 {} 자바스크립트 객체 형태로 사용한다.  
		// $.ajax({"url": "", "type": "", "success" : "function(매개변수){...}"");		
		
		// 요청하는 데이터를 ajax 함수 밖에서 선언하고 초기화 하기 
		// ajax 함수 블럭에서는 로그를 찍을 수가 없다. 
		// 요청하는 데이터 로그찍는 대상 키워드 :  url, type, data
		// 변수를 let 지역변수로 사용했다.
		let urlVal = "/testCss/ajaxTest/data1.jsp";
		let typeVal = "GET"
		let idVal = $('#id').val();
		
		// 요청하는 데이터 alert으로 로그 찍어보기 
		alert("요청하는 데이터 알럿으로 로그 찍어보기  >>> : ");
		alert("urlVal >>> : " + urlVal);
		alert("typeVal >>> : " + typeVal);
		alert("idVal >>> : " + idVal);
		
		// 요청하는 데이터 콘솔에 로그 찍어보기 
		alert("요청하는 데이터 콘솔에 로그 찍어보기  >>> : ");
		console.log("urlVal >>> : " + urlVal);
		console.log("typeVal >>> : " + typeVal);
		console.log("idVal >>> : " + idVal);
		
		$.ajax(
			{			
				url : urlVal,		
				type : typeVal,			
				data : {					
					id : idVal,	// data 는 쿼리 스트링 				
				},
				// url + data : "/testCss/ajaxTest/data1.jsp?id="+#id의 값
				
				success : whenSuccess, 
								/*
									프로퍼티로 함수를 호출 하는 것 whenSuccess 프로퍼티로 
		                       		function whenSuccess(resData) {...........}
							   		var wehSucess = function(resData){...}	
							   		success: function(data){...}
							   		success: whenSuccess,
							   		function whenSuccess(resData){....}
							   	*/
				error : whenError
			}
		);
		
		// 응답하는 데이터를 외부 함수로 사용하기 
		// success 키워드에서 선언한 whenSuccess 프로퍼티 함수 
		function whenSuccess(resData){
			alert("리턴 데이터 >>> : " + resData);
			$('#ajaxResData').html("화면에 리턴 데이터 출력 : "  + resData);
			console.log("콘솔에 리턴 데이터 출력 : " + resData);
		}
		
		// error 키워드에서 선언한 whenError 프로퍼티 함수 
		function whenError(){
			alert("error");
		}		
	}
	
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







