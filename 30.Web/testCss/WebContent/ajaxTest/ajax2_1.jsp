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
		
		let urlVal = "/testCss/ajaxTest/data2.jsp";
		let typeVal = "POST";
		let idVal = $('#id').val();		
		// ��û�ϴ� ������ �ֿܼ� �α� ���� 
		alert("��û�ϴ� ������ �ֿܼ� �α� ����  >>> : ");
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
			alert("���� ������ >>> : " + data);
			
			// find() �Լ�
			// text() �Լ� 
			var boolVal = $(data).find("result").text();
			
			alert("boolVal >>> : " + boolVal);
			alert("typeof(boolVal) >>> : " + typeof(boolVal));
			console.log("boolVal >>> : " + boolVal);
			
			if ('true' == boolVal){
				alert("����");			
			}else{
				alert("����");				
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
		<label>���̵�</label>
		<input name="id" id="id">
		<input id="button" type="button" value="��ư">			
	</form>			
</body>
</html>