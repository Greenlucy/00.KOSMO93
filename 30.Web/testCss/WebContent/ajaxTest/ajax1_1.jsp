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
			alert("button �Լ� Ŭ�� ���� >>> : ");			
			callAjax();
		});
	});
	
	
	function callAjax(){
		alert("callAjax() �Լ� ȣ�� ����  >>> : ");
	
		// �����(Ű����)�� ajax() �Լ� �ȿ� {} �ڹٽ�ũ��Ʈ ��ü ���·� ����Ѵ�.  
		// $.ajax({"url": "", "type": "", "success" : "function(�Ű�����){...}"");		
		
		// ��û�ϴ� �����͸� ajax �Լ� �ۿ��� �����ϰ� �ʱ�ȭ �ϱ� 
		// ajax �Լ� �������� �α׸� ���� ���� ����. 
		// ��û�ϴ� ������ �α���� ��� Ű���� :  url, type, data
		// ������ let ���������� ����ߴ�.
		let urlVal = "/testCss/ajaxTest/data1.jsp";
		let typeVal = "GET"
		let idVal = $('#id').val();
		
		// ��û�ϴ� ������ alert���� �α� ���� 
		alert("��û�ϴ� ������ �˷����� �α� ����  >>> : ");
		alert("urlVal >>> : " + urlVal);
		alert("typeVal >>> : " + typeVal);
		alert("idVal >>> : " + idVal);
		
		// ��û�ϴ� ������ �ֿܼ� �α� ���� 
		alert("��û�ϴ� ������ �ֿܼ� �α� ����  >>> : ");
		console.log("urlVal >>> : " + urlVal);
		console.log("typeVal >>> : " + typeVal);
		console.log("idVal >>> : " + idVal);
		
		$.ajax(
			{			
				url : urlVal,		
				type : typeVal,			
				data : {					
					id : idVal,	// data �� ���� ��Ʈ�� 				
				},
				// url + data : "/testCss/ajaxTest/data1.jsp?id="+#id�� ��
				
				success : whenSuccess, 
								/*
									������Ƽ�� �Լ��� ȣ�� �ϴ� �� whenSuccess ������Ƽ�� 
		                       		function whenSuccess(resData) {...........}
							   		var wehSucess = function(resData){...}	
							   		success: function(data){...}
							   		success: whenSuccess,
							   		function whenSuccess(resData){....}
							   	*/
				error : whenError
			}
		);
		
		// �����ϴ� �����͸� �ܺ� �Լ��� ����ϱ� 
		// success Ű���忡�� ������ whenSuccess ������Ƽ �Լ� 
		function whenSuccess(resData){
			alert("���� ������ >>> : " + resData);
			$('#ajaxResData').html("ȭ�鿡 ���� ������ ��� : "  + resData);
			console.log("�ֿܼ� ���� ������ ��� : " + resData);
		}
		
		// error Ű���忡�� ������ whenError ������Ƽ �Լ� 
		function whenError(){
			alert("error");
		}		
	}
	
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







