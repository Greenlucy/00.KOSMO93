<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> Ajax Test </title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
 <!-- 
 	Ajax(Asynchronous JavaScript and XML)
 	
 	Web 화면을 갱신하지 않고 Server로부터 Data를 가져오는 방법
 	
 	제이쿼리.함수() : jQuery.ajax() 	
 	함수 : $.ajax(), load(), $.get(), $.post(), $.getJSON()
 	
 	예약어(keyword) : ajax() 함수에서 {} : 오브젝트 블럭에서 사용 하는 것 
 	요청 키워드
 	#####################################
 	url      : 요청이 전송되는 URL이 포함된 문자열
 	type     : http요청 방식 : GET/POST
 	data     : http요청 파라미터 문자열 key=value&key=value
 	           or http요청 후 리턴값 
	#####################################
 	
 	응답 키워드
 	#####################################
 	success  : function(data: 리턴매개변수, 변수 이름이 가변적이다 ){....} : http요청 성공시 이벤트 핸들러 
 	error    : function(){.....} : http요청 실패시 이벤트 핸들러
 	
 	dataType : http요청 후 return하는 데이터 Type
 	           xml, html, srcipt, json, jsonp, text
 	#####################################

 	timeout  : http요청에 대한 제한 시간(단위 : ms)
	async    : 요청시 동기 유무 선택(true/false)
	           true : async, false : sync
	cache    : 브라우저에 의해 요청되는 페이지를 캐시(true/false)
	           true : 캐시사용, false : 캐시사용하지 않음 		
	           
	$.ajax() : $.ajax({url, type, dateType, data, success, error 키워드 사용})
	$ : 제이쿼리
	. : 링크 연산자
	ajax() : Ajax 함수 
	{} : 자바스크립트 객체
	{url, } : url : Ajax 키워드 : 요청이 전송되는 URL이 포함된 문자열
	        : , : 컴마세퍼레이션 : 키워드 구분자 
	
	success : 요청이 성공되면 응답을 받는 키워드
				function(data){}: 응답을 받는 함수 
				data 는 변수명 이다. 
				 
	error : 요청이 실패하면 응답을 받는 키워드 
				function(data){}: 응답을 받는 함수 	
				data 는 변수명 이다. 
				        
	=========================           
	$.ajax(
		{
			"url" : "접속할 페이지 주소" 
		   ,"type" : "GET" or "POST"
		   ,"dataType" : "XML" or "JSON"
		   ,"data" : "파라미터 문자열 key=value&key=value" or { "key":"value", "key":"value"}
		   ,"success" : function(data){
		   				// 통신에 성공했을 때 실행되는 함수 
		   } 
		   ,"error" : function(data){
		   				// 통신에 실패했을 때 실행되는 함수 
		   } 
		}
	);	           			 	         
	
	$.get() : $.get({url, {파라미터}, functin(){} 키워드 사용})
	=========================   
	$.get(
		{
			"url"
		   ,{파라미터 Object(JSON)}
		   ,function (){
		   	// 통신에 성공했을 때 실행되는 함수 
		   }			
		}
	);
	
	var ajax = $.get("url",{파라미터 Object(JSON)},function (){... });
	ajax.fail(function(){
		// 404, 500 에러등이 발생한 경우 실행 
	});
	ajax.always(function(){
		// 통신 성공, 실패 여부에 상관없이 무조건 마지막에 호출됨
	});
	
	$.post() : $.post({url, {파라미터}, functin(){} 키워드 사용})
	=========================   
	$.post(
		{
			"url"
		   ,{파라미터 Object(JSON)}
		   ,function (){
			// 통신에 성공했을 때 실행되는 함수 
		   }			
		}
	);
  -->
<script type="text/javascript">

	$(document).ready(function(){
		
		$('#button').click(function(){
			alert(">>>");
			
			$.ajax({					
				type : "POST",
				url : "/testCss/ajaxTest/data1.jsp",
				data : {					
					id : $('#id').val(),	// data 는 쿼리 스트링 				
				},
				success : function (resData){
					alert("리턴 데이터 >>> : " + resData);
					$('#ajaxResData').html("화면에 리턴 데이터 출력 : "  + resData);
					console.log("콘솔에 리턴 데이터 출력 : " + resData);
				},
				error : function (){
					alert("error");
				}	
			});
			
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







