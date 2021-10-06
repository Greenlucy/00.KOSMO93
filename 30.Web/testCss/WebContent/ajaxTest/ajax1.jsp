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
 	
 	Web ȭ���� �������� �ʰ� Server�κ��� Data�� �������� ���
 	
 	��������.�Լ�() : jQuery.ajax() 	
 	�Լ� : $.ajax(), load(), $.get(), $.post(), $.getJSON()
 	
 	�����(keyword) : ajax() �Լ����� {} : ������Ʈ ������ ��� �ϴ� �� 
 	��û Ű����
 	#####################################
 	url      : ��û�� ���۵Ǵ� URL�� ���Ե� ���ڿ�
 	type     : http��û ��� : GET/POST
 	data     : http��û �Ķ���� ���ڿ� key=value&key=value
 	           or http��û �� ���ϰ� 
	#####################################
 	
 	���� Ű����
 	#####################################
 	success  : function(data: ���ϸŰ�����, ���� �̸��� �������̴� ){....} : http��û ������ �̺�Ʈ �ڵ鷯 
 	error    : function(){.....} : http��û ���н� �̺�Ʈ �ڵ鷯
 	
 	dataType : http��û �� return�ϴ� ������ Type
 	           xml, html, srcipt, json, jsonp, text
 	#####################################

 	timeout  : http��û�� ���� ���� �ð�(���� : ms)
	async    : ��û�� ���� ���� ����(true/false)
	           true : async, false : sync
	cache    : �������� ���� ��û�Ǵ� �������� ĳ��(true/false)
	           true : ĳ�û��, false : ĳ�û������ ���� 		
	           
	$.ajax() : $.ajax({url, type, dateType, data, success, error Ű���� ���})
	$ : ��������
	. : ��ũ ������
	ajax() : Ajax �Լ� 
	{} : �ڹٽ�ũ��Ʈ ��ü
	{url, } : url : Ajax Ű���� : ��û�� ���۵Ǵ� URL�� ���Ե� ���ڿ�
	        : , : �ĸ����۷��̼� : Ű���� ������ 
	
	success : ��û�� �����Ǹ� ������ �޴� Ű����
				function(data){}: ������ �޴� �Լ� 
				data �� ������ �̴�. 
				 
	error : ��û�� �����ϸ� ������ �޴� Ű���� 
				function(data){}: ������ �޴� �Լ� 	
				data �� ������ �̴�. 
				        
	=========================           
	$.ajax(
		{
			"url" : "������ ������ �ּ�" 
		   ,"type" : "GET" or "POST"
		   ,"dataType" : "XML" or "JSON"
		   ,"data" : "�Ķ���� ���ڿ� key=value&key=value" or { "key":"value", "key":"value"}
		   ,"success" : function(data){
		   				// ��ſ� �������� �� ����Ǵ� �Լ� 
		   } 
		   ,"error" : function(data){
		   				// ��ſ� �������� �� ����Ǵ� �Լ� 
		   } 
		}
	);	           			 	         
	
	$.get() : $.get({url, {�Ķ����}, functin(){} Ű���� ���})
	=========================   
	$.get(
		{
			"url"
		   ,{�Ķ���� Object(JSON)}
		   ,function (){
		   	// ��ſ� �������� �� ����Ǵ� �Լ� 
		   }			
		}
	);
	
	var ajax = $.get("url",{�Ķ���� Object(JSON)},function (){... });
	ajax.fail(function(){
		// 404, 500 �������� �߻��� ��� ���� 
	});
	ajax.always(function(){
		// ��� ����, ���� ���ο� ������� ������ �������� ȣ���
	});
	
	$.post() : $.post({url, {�Ķ����}, functin(){} Ű���� ���})
	=========================   
	$.post(
		{
			"url"
		   ,{�Ķ���� Object(JSON)}
		   ,function (){
			// ��ſ� �������� �� ����Ǵ� �Լ� 
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
					id : $('#id').val(),	// data �� ���� ��Ʈ�� 				
				},
				success : function (resData){
					alert("���� ������ >>> : " + resData);
					$('#ajaxResData').html("ȭ�鿡 ���� ������ ��� : "  + resData);
					console.log("�ֿܼ� ���� ������ ��� : " + resData);
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
		<label>���̵�</label><input name="id" id="id">
		<input id="button" type="button" value="��ư">			
	</form>
	<div id="ajaxResData">���� ������</div>		
</body>
</html>







