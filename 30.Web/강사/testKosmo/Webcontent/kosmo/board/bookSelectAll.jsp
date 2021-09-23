<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="a.b.c.com.kosmo.board.service.BoardService"%>
<%@page import="a.b.c.com.kosmo.board.service.BoardServiceImpl"%>    
<%@page import="a.b.c.com.kosmo.board.vo.BoardVO"%>    
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 전체조회</title>
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

	//체크박스 체크 확인하기 
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

		// 등록하기 
		$("#I").click(function(){			
			location.href='/testKosmo/kosmo/board/board.html';			
		});
		
		// 전체조회
		$("#SALL").click(function(){			
			var isudType = document.boardSelectAllForm.ISUD_TYPE.value = "SALL";			
			send(isudType);		
		});
		
		// 수정하기 
		$("#U").click(function(){			

			var nCnt = chkInfo();			
			if (nCnt == 0){	
				console.log('체크박스를 체크하세요');
				alert('체크박스를 체크하세요');
			}else{	
				/* 자바스크립트 버전
					document.boardSelectAllForm.ISUD_TYPE.value = "U";
					alert("isudType U >>> : " + document.boardSelectAllForm.ISUD_TYPE.value);
					send(document.boardSelectAllForm.ISUD_TYPE.value);	
				*/
				// jQuery 버전 
				var v1 = $("#ISUD_TYPE").val('U');
				alert("v1 >>> : " + v1.val());
				send(v1);				
			}			
		});
		
	
		// 삭제하기 
		$("#D").click(function(){			
			
			var nCnt = chkInfo();
			if (nCnt == 0){	
				console.log('체크박스를 체크하세요');
				alert('체크박스를 체크하세요');
			}else{	
				/* 자바스크립트 버전
					document.boardSelectAllForm.ISUD_TYPE.value = "D";
					alert("isudType D >>> : " + document.boardSelectAllForm.ISUD_TYPE.value);
					send(document.boardSelectAllForm.ISUD_TYPE.value);	
				*/
				
				// jQuery 버전 
				var v2 = $("#ISUD_TYPE").val('D');
				alert("v2 >>> : " + v2.val());
				send(v2);
			}					
		});
		
		// 체크박스 체크 카운트
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
	out.println(":::: 전체 조회 건수  " + nCnt + " 건");	
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
	<td class="tt">순번</td>
	<td class="tt">글번호</td>
	<td class="tt">글제목</td>
	<td class="tt">저자</td>
	<td class="tt">패스워드</td>
	<td class="tt">내용</td>
	<td class="tt">이미지</td>	
	<td class="tt">삭제여부</td>
	<td class="tt">등록일</td>
	<td class="tt">수정일</td>
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
		<input type="button" value="등록" id="I">
		<input type="button" value="조회" id="SALL">
		<input type="button" value="수정" id="U">
		<input type="button" value="삭제" id="D">									
	</td>
</tr>	
</tbody>			
</table>
</form>		
</body>
</html>

