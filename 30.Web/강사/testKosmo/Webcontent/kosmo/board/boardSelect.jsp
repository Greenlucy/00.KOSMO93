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
	
	div {
		margin: 50px 0px 0px 100px;
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

	function boardUpdate(actionUpdate){
		console.log("boardUpdate ���� >>> : " + actionUpdate);
				
		if ('U' == actionUpdate){
			var v1 = "UOK";		
			document.boardUpdateForm.action="/testKosmo/board?ISUD_TYPE="+v1;			
		}
		
		if ('D' == actionUpdate){
			var v2 = "DOK";
			document.boardUpdateForm.action="/testKosmo/board?ISUD_TYPE="+v2;
		}
		
		document.boardUpdateForm.method="POST";
		document.boardUpdateForm.enctype="application/x-www-form-urlencoded";
		document.boardUpdateForm.submit();		
	}
	
	function checkAction(actionName){
		console.log("actionName ���� >>> : " + actionName);
		
		if ('I' == actionName){	
			location.href="/testKosmo/kosmo/board/board.html";
		}
		if ('SALL' == actionName){			
			location.href="/testKosmo/board?ISUD_TYPE=SALL";
		}
	}	
</script>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR");%> 
SELECT 

<%
	Object obj = request.getAttribute("aListS");
	if (obj == null) return;
	
	ArrayList<BoardVO> aList = (ArrayList<BoardVO>)obj;
	int nCnt = aList.size();
	out.println(":::: ���� ��ȸ >>> : " + nCnt + " ��");
	
	String bnum = "";
	String bsubject = "";	
	String bwriter = "";
	String bpw = "";
	String bmemo = "";
	String bphoto = "";
	String deleteyn = "";
	String insertdate = "";
	String updatedate = "";	
	
	if (nCnt == 1){
		BoardVO bvo = aList.get(0);
		
		bnum = bvo.getBnum();
		bsubject = bvo.getBsubject();
		bwriter = bvo.getBwriter();
		bpw = bvo.getBpw();
		bmemo = bvo.getBmemo();
		bphoto = bvo.getBphoto();
		deleteyn = bvo.getDeleteyn();
		insertdate = bvo.getInsertdate();
		updatedate = bvo.getUpdatedate();		
	}
%>
<hr>
<div>
<form name="boardUpdateForm" id="boardUpdateForm">
<table border="1">
<tr>	
	<td colspan="2" align="center">	
					
		<font size="4" style="color:blue;">�Խ��� �� ���� && ����</font> 
		<img src="/testKosmo/img/img_mando/ase.gif" width="25" height="25" alt="image">		
	</td>				
</tr>
<tr>
	<td class="tt">�۹�ȣ</td>
	<td><input type="text" name="bnum" id="bnum" size="20"  value="<%= bnum %>" readonly></td>
</tr>
<tr>
	<td class="tt">����</td>
	<td><input type="text" name="bsubject" id="bsubject" value="<%= bsubject %>" size="55"></td>
</tr>
<tr>
	<td  class="tt">�̸�</td>.
	<td><input type="text" name="bwriter" id="bwriter" value="<%= bwriter %>" size="20" readonly></td>
</tr>
<tr>
	<td  class="tt">��й�ȣ</td>
	<td><input type="password" name="bpw" id="bpw" value="<%= bpw %>" size="20" readonly></td>
</tr>
<tr>
	<td  class="tt">��������</td>
	<td><input type="text" name="deleteyn" size="20" value="<%= deleteyn %>" disabled></td>
</tr>
<tr>
	<td  class="tt">�Է���</td>
	<td><input type="text" name="insertdate" size="20" value="<%= insertdate %>" disabled></td>
</tr>
<tr>
	<td  class="tt">������</td>
	<td><input type="text" name="updatedate" size="20" value="<%= updatedate %>" disabled></td>
</tr>
<tr>
	<td  class="tt">����</td>
	<td>
	<textarea name="bmemo" id="bmemo" cols="50" rows="10"><%= bmemo %></textarea>
</td>
</tr>
<tr>
	<td  class="tt">����</td>
	<td>
	<img src="/testKosmo/fileupload/board/<%= bphoto %>" border="1" width="40" height="50" alt="image">		
</td>
</tr>
<tr>
	<td colspan="2" align="center">	
	<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" >
	<input type="button" value="����" onclick="boardUpdate('U')"/>
	<input type="button" value="����" onclick="boardUpdate('D')"/>
    <input type="reset" value="���" />
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="�Է�" onclick="checkAction('I')"/>
	<input type="button" value="���" onclick="checkAction('SALL');">
</td>	
<tr>			
</table>
</form>
</div>
</body>
</html>