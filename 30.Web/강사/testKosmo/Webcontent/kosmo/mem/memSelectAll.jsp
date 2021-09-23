<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="a.b.c.com.kosmo.mem.service.MemberService"%>
<%@page import="a.b.c.com.kosmo.mem.service.MemberServiceImpl"%>    
<%@page import="a.b.c.com.kosmo.mem.vo.MemberVO"%>  
<%@page import="a.b.c.com.common.CodeUtil"%>   
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
		var chkObj = document.getElementsByName("mnumCheck");
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
			location.href='/testKosmo/kosmo/mem/mem.html';			
		});
		
		// 전체조회
		$("#SALL").click(function(){			
			var isudType = document.memSelectAllForm.ISUD_TYPE.value = "SALL";			
			send(isudType);		
		});
		
		// 수정하기 
		$("#U").click(function(){			

			var nCnt = chkInfo();			
			if (nCnt == 0){	
				console.log('체크박스를 체크하세요');
				alert('체크박스를 체크하세요');
			}else{				
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
				// jQuery 버전 
				var v2 = $("#ISUD_TYPE").val('D');
				alert("v2 >>> : " + v2.val());
				send(v2);
			}					
		});
		
		// 체크박스 체크 카운트
		function chkInfo(){			
			var obj = document.getElementsByName("mnumCheck");
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
			
			$("#memSelectAllForm").attr({
				"action":"/testKosmo/mem?ISUD_TYPE="+isudType,
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
	
	ArrayList<MemberVO> aList = (ArrayList<MemberVO>)obj;
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
<form name="memSelectAllForm" id="memSelectAllForm">
<table border="1">
<thead>
<tr>
	<td class="tt"><input type="checkbox" name="chkAll" id="chkAll"></td>
	<td class="tt">순번</td>
	<td class="tt">회원번호</td>
	<td class="tt">이름</td>
	<td class="tt">아이디</td>
	<td class="tt">성별</td>
	<td class="tt">생년월일</td>
	<td class="tt">핸드폰</td>
	<td class="tt">이메일</td>
	<td class="tt">주소</td>
	<td class="tt">취미</td>
	<td class="tt">사진</td>	
	<td class="tt">수정일</td>
</tr>
</thead>
<%
	String gender = "";
	String birth = "";
	String hp = "";
	String tel = "";
	String email = "";
	String addr = "";
	String hobby = "";
	
	for(int i=0; i<nCnt; i++){		
		MemberVO mvo = aList.get(i);
		gender = CodeUtil.gender(mvo.getMgender());
		birth = CodeUtil.birth(mvo.getMbirth());
		hp = CodeUtil.hp(mvo.getMhp());
		addr = mvo.getMzonecode() + " " + mvo.getMroadaddress().replace("@", " " );
		hobby = CodeUtil.hobbys(mvo.getMhobby());				
%>					
<tbody>
<tr>
	<td class="tt">
		<input type="checkbox" id="mnumCheck" name="mnumCheck" value=<%= mvo.getMnum() %> onclick="checkOnly(this)">
	</td>		
	<td class="tt"><%= i + 1 %></td>
	<td class="tt"><%= mvo.getMnum() %> </td>
	<td class="tt"><%= mvo.getMname() %> </td>
	<td class="tt"><%= mvo.getMid() %> </td>
	<td class="tt"><%= gender %> </td>	
	<td class="tt"><%= birth %> </td>
	<td class="tt"><%= hp %> </td>
	<td class="tt"><%= mvo.getMemail() %> </td>
	<td class="tt"><%= addr %></td>
	<td class="tt"><%= hobby %></td>
	<td class="tt"><img src="/testKosmo/fileupload/member/<%= mvo.getMphoto() %> " border="1" width="25" height="25" alt="image"></td>	
	<td class="tt"><%= mvo.getUpdatedate() %> </td>			
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

