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
						id : idVal,	// data �� ���� ��Ʈ�� 				
					},
					success : whenSuccess,					
					error : whenError
			}); // end of ajax()
			
			function whenSuccess(resData){
				alert("���� ������ >>> : " + resData);
				$('#ajaxResData').html("ȭ�鿡 ���� ������ ��� : "  + resData);
				console.log("�ֿܼ� ���� ������ ��� : " + resData);
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
	<label>���̵�</label><input name="id" id="id">
	<input id="button" type="button" value="��ư">			
</form>
<div id="ajaxResData">���� ������</div>		
</body>
</html>







