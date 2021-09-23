<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="a.b.c.com.kosmo.board.service.BoardService"%>
<%@page import="a.b.c.com.kosmo.board.service.BoardServiceImpl"%>    
<%@page import="a.b.c.com.kosmo.board.vo.BoardVO"%>    
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� ��ü��ȸ</title>
<style type="text/css">
	* {
		margin: 0 auto;
		/*text-align: center;*/
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
			location.href='/testKosmo/kosmo/board/board.html';			
		});
		
		// ��ü��ȸ
		$("#SALL").click(function(){			
			var isudType = document.boardSelectAllForm.ISUD_TYPE.value = "SALL";			
			send(isudType);		
		});
		
		// �����ϱ� 
		$("#U").click(function(){			

			var nCnt = chkInfo();			
			if (nCnt == 0){	
				console.log('üũ�ڽ��� üũ�ϼ���');
				alert('üũ�ڽ��� üũ�ϼ���');
			}else{	
				/* �ڹٽ�ũ��Ʈ ����
					document.boardSelectAllForm.ISUD_TYPE.value = "U";
					alert("isudType U >>> : " + document.boardSelectAllForm.ISUD_TYPE.value);
					send(document.boardSelectAllForm.ISUD_TYPE.value);	
				*/
				// jQuery ���� 
				var v1 = $("#ISUD_TYPE").val('U');
				alert("v1 >>> : " + v1.val());
				send(v1);				
			}			
		});
		
	
		// �����ϱ� 
		$("#D").click(function(){			
			
			var nCnt = chkInfo();
			if (nCnt == 0){	
				console.log('üũ�ڽ��� üũ�ϼ���');
				alert('üũ�ڽ��� üũ�ϼ���');
			}else{	
				/* �ڹٽ�ũ��Ʈ ����
					document.boardSelectAllForm.ISUD_TYPE.value = "D";
					alert("isudType D >>> : " + document.boardSelectAllForm.ISUD_TYPE.value);
					send(document.boardSelectAllForm.ISUD_TYPE.value);	
				*/
				
				// jQuery ���� 
				var v2 = $("#ISUD_TYPE").val('D');
				alert("v2 >>> : " + v2.val());
				send(v2);
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
		function send(isudType){
			alert("isudType send >>> : " + isudType);
			
			$("#boardSelectAllForm").attr({
				"action":"/testKosmo/board?ISUD_TYPE="+isudType,
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		}
	});

</script>	
</head>
<% request.setCharacterEncoding("EUC-KR");%> 
SELECT ALL
<%
	Object obj = request.getAttribute("aListAll");
	if (obj == null) return;
	
	ArrayList<BoardVO> aList = (ArrayList<BoardVO>)obj;
	int nCnt = aList.size();
	out.println(":::: ��ü ��ȸ �Ǽ�  " + nCnt + " ��");	
%>
<table>
<tr>
<td calspan="2">
<font size="4" color="blue">
	<img src="/testKosmo/img/img_mando/ase.gif" width="25" height="25" alter="image">
	BOARD TEST
</font>
</td>
</tr>
</table>
<hr>
<hr>
<form name="boardSelectAllForm" id="boardSelectAllForm">
<table border="1">
<thead>
<tr>
	<td class="tt"><input type="checkbox" name="chkAll" id="chkAll"></td>
	<td class="tt">����</td>
	<td class="tt">�۹�ȣ</td>
	<td class="tt">������</td>
	<td class="tt">����</td>
	<td class="tt">�н�����</td>
	<td class="tt">����</td>
	<td class="tt">�̹���</td>	
	<td class="tt">��������</td>
	<td class="tt">�����</td>
	<td class="tt">������</td>
</tr>
</thead>
<%
	for(int i=0; i<nCnt; i++){
		
		BoardVO bvo = aList.get(i);

%>					
<tbody>
<tr>
	<td class="tt">
		<input type="checkbox" id="bnumCheck" name="bnumCheck" value=<%= bvo.getBnum() %> onclick="checkOnly(this)">
	</td>		
	<td class="tt"><%= i + 1 %></td>
	<td class="tt"><%= bvo.getBnum() %> </td>
	<td class="tt"><%= bvo.getBsubject() %> </td>
	<td class="tt"><%= bvo.getBwriter() %> </td>
	<td class="tt"><%= bvo.getBpw() %> </td>	
	<td class="tt"><%= bvo.getBmemo() %> </td>
	<td class="tt"><img src="/testKosmo/fileupload/board/<%= bvo.getBphoto() %>"></td>
	<td class="tt"><%= bvo.getDeleteyn() %> </td>		
	<td class="tt"><%= bvo.getInsertdate() %> </td>
	<td class="tt"><%= bvo.getUpdatedate() %> </td>		
</tr>	
<%
	}//end of if
%>						
<tr>
	<td colspan="20" align="right">
		<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" value="">			
		<input type="button" value="���" id="I">
		<input type="button" value="��ȸ" id="SALL">
		<input type="button" value="����" id="U">
		<input type="button" value="����" id="D">									
	</td>
</tr>	
</tbody>			
</table>
</form>		
</body>
</html>

