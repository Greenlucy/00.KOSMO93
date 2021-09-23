<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="a.b.c.com.kosmo.book.service.BookService"%>
<%@page import="a.b.c.com.kosmo.book.service.BookServiceImpl"%>    
<%@page import="a.b.c.com.kosmo.book.vo.BookVO"%>    
<%@page import="java.util.ArrayList"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ��� ��ȸ</title>
<style type="text/css">
	* {
		margin: 0 auto;
		/*text-align: center;*/
	}
			
	fieldset {
			 width: 1000px;
	}
	
	legend {
		 font-size: 1.5em;
		 font-weight: bold;
	}

	td, th {
		 padding: 5px;
	}
	
	.tt {
		text-align: center;
	}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	//üũ�ڽ� üũ Ȯ���ϱ� 
	function checkOnly(chk){
		// alert(">>> : " + chk);
		var chkObj = document.getElementsByName("bnumCheck");
		console.log("chkObj >>> : " + chkObj);
		for (var i=0; i < chkObj.length; i++){
			if (chkObj[i] != chk){
				chkObj[i].checked = false;
			}
		}
	}
	
	$(document).ready(function(){	

		// ����ϱ� 
		$("#I").click(function(){			
			location.href='/testKosmo/kosmo/book/book.html';			
		});
		
		// ��ü��ȸ
		$("#SALL").click(function(){			
			var isudtype = document.bookSelectAllForm.isudtype.value = "SALL";			
			send(isudtype);		
		});
		
		// �����ϱ� 
		$("#U").click(function(){			

			var nCnt = chkInfo();			
			if (nCnt == 0){	
				console.log('üũ�ڽ��� üũ�ϼ���');
				alert('üũ�ڽ��� üũ�ϼ���');
			}else{	
				document.bookSelectAllForm.isudtype.value = "U";
				alert("isudtype U >>> : " + document.bookSelectAllForm.isudtype.value);
				send(document.bookSelectAllForm.isudtype.value);				
			}			
		});
		
	
		// �����ϱ� 
		$("#D").click(function(){			
			
			var nCnt = chkInfo();
			if (nCnt == 0){	
				console.log('üũ�ڽ��� üũ�ϼ���');
				alert('üũ�ڽ��� üũ�ϼ���');
			}else{				
				document.bookSelectAllForm.isudtype.value = "D";
				alert("isudtype D >>> : " + document.bookSelectAllForm.isudtype.value);
				send(document.bookSelectAllForm.isudtype.value);				
			}					
		});
		
		// üũ�ڽ� üũ ī��Ʈ
		function chkInfo(){			
			var obj = document.getElementsByName("bnumCheck");
			var nCnt = 0;			
			for(var i=0; i < obj.length; i++){ 
	          	if (obj[i].checked == true){ 
	          		nCnt++;
	          	}		          			            
	        }			
			console.log('nCnt >>> : ' + nCnt);			
			return nCnt;
		}
		
		// submit 
		function send(isudtype){
			alert("isudtype send >>> : " + isudtype);
			
			$("#bookSelectAllForm").attr({
				"action":"/testKosmo/book?isudtype="+isudtype,
				"method":"POST",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		}
	});

</script>
</head>
<body>
<body>
<% request.setCharacterEncoding("EUC-KR");%> 
SELECT ALL
<%
	Object obj = request.getAttribute("aListAll");
	if (obj == null) return;
	
	ArrayList<BookVO> aList = (ArrayList<BookVO>)obj;
	int nCnt = aList.size();
	out.println(":::: ��ü ��ȸ �Ǽ�  " + nCnt + " ��");	
%>
<table>
<tr>
<td calspan="2">
<font size="4" color="blue">
	<img src="/testKosmo/img/img_mando/ase.gif" width="25" height="25" alter="image">
	BOOK TEST
</font>
</td>
</tr>
</table>
<hr>
<hr>
<fieldset>
<legend>���� ���� ��ȸ</legend>
<form name="bookSelectAllForm" id="bookSelectAllForm">
<table border="1">
<thead>
<tr>
	<td class="tt"><input type="checkbox" name="chkAll" id="chkAll"></td>
	<td class="tt">����</td>
	<td class="tt">������ȣ</td>
	<td class="tt">������</td>
	<td class="tt">����</td>
	<td class="tt">ISBN</td>
	<td class="tt">���ǻ�</td>
	<td class="tt">�ܰ�</td>
	<td class="tt">����</td>
	<td class="tt">ǥ��</td>	
	<td class="tt">��������</td>
	<td class="tt">�����</td>
	<td class="tt">������</td>
</tr>
</thead>
<%
	for(int i=0; i<nCnt; i++){
		
		BookVO bvo = aList.get(i);

%>					
<tbody>
<tr>
	<td class="tt">
		<input type="checkbox" name="bnumCheck" id="bnumCheck" value=<%= bvo.getBnum() %> onclick="checkOnly(this)">
	</td>		
	<td class="tt"><%= i + 1 %></td>
	<td class="tt"><%= bvo.getBnum() %> </td>
	<td class="tt"><%= bvo.getBtitle() %> </td>
	<td class="tt"><%= bvo.getBauth() %> </td>
	<td class="tt"><%= bvo.getIsbn() %> </td>	
	<td class="tt"><%= bvo.getBcomp() %> </td>
	<td class="tt"><%= bvo.getBprice() %> </td>
	<td class="tt"><%= bvo.getBqty() %> </td>		
	<td class="tt"><img src="/testKosmo/fileupload/book/<%= bvo.getBcover() %>" border="1" width="25" height="25" alt="image"></td>
	<td class="tt"><%= bvo.getDeleteyn() %> </td>		
	<td class="tt"><%= bvo.getInsertdate() %> </td>
	<td class="tt"><%= bvo.getUpdatedate() %> </td>		
</tr>	
<%
	}//end of if
%>						
<tr>
	<td colspan="20" align="right">
		<input type="hidden" name="isudtype" id="isudtype" value="">			
		<input type="button" value="�����������" id="I">
		<input type="button" value="����������ȸ" id="SALL">
		<input type="button" value="������������" id="U">
		<input type="button" value="������������" id="D">									
	</td>
</tr>	
</tbody>			
</table>
</form>	
</fieldset>		
</body>
</html>