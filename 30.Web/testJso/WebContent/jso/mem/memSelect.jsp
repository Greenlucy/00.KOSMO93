<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="a.b.c.com.jso.mem.vo.MemberVO" %>
    <%@ page import="a.b.c.com.common.CodeUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<title>글 조건조회</title>
	
	<style type="text/css">
		* {
			margin : 0 auto;
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
		
		.photo {
			border: 1px solid red;
			width: 160px;
			height: 180px;
			display: block;
			margin-left: auto;
			margin-right: auto;
		}
	</style>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 다음 주소록 OPEN API CDN 불러오기 -->
	<script src="http:/dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			
			// 이메일
			$('#memail2').change(function(){
			$('#memail2 option:selected').each(function(){
				if($(this).val() == '1'){	// 직접입력일 경우
					 var aa = $("#memail1").val();
					// alert("aa >>> : " + aa);
					$("#memail1").val('');	// 값 초기화
					$("#memail1").attr("readonly", true); // 활성화
				}else{ // 직접입력이 아닐 경우
					$("#memail").val($(this).text());	// 선택값 입력
					$("memail").attr("readonly", true);	// 비활성화
				}});
			});
			
			// 우편번호
			$("#zonecode").click(function(){
				console.log("zonecode >>> : ");
				new daum.Postcode({
					oncomplete: function(data) {
						$("#mzonecode").val(data.zonecode);	// 5자리 새우편번호 사용
						$("#mroadaddress").val(data.roadAddress);	// 도로명 주소
						$("mjibunaddress").val(data.jibunAddress);	// 지번주소
					}
				}).open();
			});
		});
		
			function memUpdate(actionUpdate){
				console.log("memUpdate 진입 >>> : " + actionUpdate);
				
				if ('U' == actionUpdate){
					var v1 = "UOK";
					document.memUpdateForm.action="/testJso/member?ISUD_TYPE="+v1;
				}
				if ('D' == actionUpdate){
					var v2 = "DOK";
					document.memUpdateForm.action="/testJso/member?ISUD_TYPE="+v2;
				}
				
				document.memUpdateForm.method="POST";
				document.memUpdateForm.enctype="application/x-www-form-urlencoded";
				document.memUpdateForm.submit();
			}
		
		function checkAction(actionName){
			console.log("actionName 진입 >>> : " + actionName);
			
			if ("I" == actionName){
				location.href="/testJso/jso/mem/mem.html";
			}
			if('SALL' == actionName){
				location.href="/testJso/member?ISUD_TYPE=SALL";
			}
		}
	</script>
</head>
<body onload="compCheck()">
	<% request.setCharacterEncoding("EUC-KR"); %>
	SELECT
	<%
		Object obj = request.getAttribute("aListS");
		ArrayList<MemberVO> aListS = (ArrayList<MemberVO>)obj;
		int nCnt = aListS.size();
		out.println(":::: 조건 조회 >>> : " + nCnt + "건");
		
		String mgender = "";
		String mbirth = "";
		String mhp = "";
		String mtel = "";
		String memail = "";
		String mzonecode = "";
		String mroadaddress = "";
		String mroadaddressdetail = "";
		String mjibunaddress = "";
		String mhobby = "";
		
		MemberVO mvo = null;
		
		if(nCnt == 1){
			mvo = aListS.get(0);
			MemberVO.printMemberVO(mvo);
			
			// 성별
			mgender = mvo.getMgender();
			// 생년월일
			mbirth = CodeUtil.birth(mvo.getMbirth());
			// 핸드폰
			mhp = CodeUtil.hp(mvo.getMhp());
			// 전화번호
			mtel = CodeUtil.tel(mvo.getMtel());
			// 이메일
			memail = mvo.getMemail();
			// 주소
			mzonecode = mvo.getMzonecode();
			mroadaddress = mvo.getMroadaddress();
			try{
				String addr[] = mroadaddress.split("@");
				try{
					mroadaddress = addr[0];
				}catch(Exception e){
					System.out.println("mroadaddress = addr[0] 에러 >>> : " + e);
				}
				try{
					mroadaddressdetail = addr[1];
				}catch(Exception e){
					System.out.println("mroadaddress = addr[1] 에러 >>> : " + e);
				}
			}catch(Exception e){
				System.out.println("String addr[] 에러 >>> : " + e);
			}
						
			// 취미
			mhobby = mvo.getMhobby();
		}
	%>
	<hr>
	<div>
		<form name="memUpdateForm" id="memUpdateForm">
			<table border="1">
				<script>
					function compCheck(){
						console.log("compCheck >>> 진입 >>> : ");
						
						// 성별
						var gen = '<%= mgender%>';
						console.log("gen >>> : " + gen);
						if('01' == gen){
							document.getElementsByName("mgender")[0].checked = true;
						}
						if('02' == gen){
							document.getElementsByName("mgender")[1].checked = true;
						}
						
						// 이메일
						var email = '<%= memail %>';
						var emails = email.split('@');
						document.getElementById("memail").value = emails[0];
						document.getElementById("memail1").value = emails[1];
						
						// 취미
						var hobs = '<%= mhobby %>';
						console.log("hobs >>> : " + hobs);
						var hob = hobs.split(', ');				// 구분자 제대로 안 쓰면, 모두 출력되지 않음
						for (var m=0; m < hob.length; m++){
							var hobValue = hob[m];
							console.log("hobValue >>> : " + hobValue);
							if('01' == hobValue){
								document.getElementsByName("mhobby")[0].checked = true;
							}
							if ('02' == hobValue){
								document.getElementsByName("mhobby")[1].checked = true;
							}
							if ('03' == hobValue){
								document.getElementsByName("mhobby")[2].checked = true;
							}
							if ('04' == hobValue){
								document.getElementsByName("mhobby")[3].checked = true;
							}
							if ('05' == hobValue){
								document.getElementsByName("mhobby")[4].checked = true;
							}
						}
					}
				</script>
				<tr>
					<td colspan="3" align="center">
						<font size="4" style="color:blue;">회원정보 수정 && 삭제</font> 
						<img src="/testJso/img/img_mando/ase.gif" width="25" height="25" alt="image">
					</td>
				</tr>
				<tr>
					<td>회원번호</td>
					<td>
						<input type="text" name="mnum" id="mnum" value="<%= mvo.getMnum() %>" readonly>
					</td>
					<td rowspan="5">
						<img class="photo" src="/testJso/fileupload/member/<%= mvo.getMphoto() %>" alt="image">
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="mname" id="mname" value="<%= mvo.getMname() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="mid" id="mid" style="width:100px" value="<%= mvo.getMid() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td>
						<input type="text" name="mpw" id="mpw" style="width:100px" value="<%= mvo.getMpw() %>" readonly>					
					</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<input type="radio" name="mgender" id="mgender" value="01" checked /> 여자
						<input type="radio" name="mgender" id="mgender" value="02" /> 남자
					</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td colspan="2">
						<input type="text" name="mbirth" id="mbirth" value="<%= mbirth %>" readonly>
					</td>
				</tr>
				<tr>
					<td>핸드폰</td>
					<td colspan="2">
						<input type="text" name="mhp" id="mhp" value="<%= mhp %>" readonly>
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td colspan="2">
						<input type="text" name="mtel" id="mtel" value="<%= mtel %>" readonly >
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td colspan="2">
						<input type="text" name="memail" id="memail" style="width:100px" >
						@ <input type="text" name="memail1" id="memail1" style="width:100px" placeholder="직접입력" >
						<select name="memail2" id="memail2">
							<option value="1" selected>직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="daum.net">daum.net</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td colspan="2">
						<input type="text" name="mzonecode" id="mzonecode" placeholder="우편번호" style="width:50px" value="<%= mzonecode %>">
						<input type="button" name="zonecode" id="zonecode" value="우편번호 찾기"><br>
						<input type="text" name="mroadaddress" id="mroadaddress" placeholder="도로명주소" style="width:250px" value="<%= mroadaddress %>" ><br>
						<input type="text" name="mroadaddressdetail" id="mroadaddressdetail" placeholder="도로명주소 상세주소" style="width:250px" value="<%= mroadaddressdetail %>" ><br>
						<input type="text" name="mjibunaddress" id="mjibunaddress" placeholder="지번주소" style="width:250px" value="<%= mjibunaddress %>">
					</td>
				</tr>
				<tr>
					<td>취미</td>
					<td colspan="2">
						<input type="checkbox" name="mhobby" value="01">알고리즘
						<input type="checkbox" name="mhobby" value="02">코딩
						<input type="checkbox" name="mhobby" value="03">분석설계<br>
						<input type="checkbox" name="mhobby" value="04">데이터베이스
						<input type="checkbox" name="mhobby" value="05">스크립트
					</td>
				</tr>
				<tr>
					<td>소개글</td>
					<td colspan="2">
						<textarea name="minfo" id="minfo" rows="5" cols="50"><%= mvo.getMinfo() %>
						</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE">
						<input type="button" value="수정" onclick="memUpdate('U')" />
						<input type="button" value="삭제" onclick="memUpdate('D')" />
						<input type="reset" value="취소" />
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="입력" onclick="checkAction('I')" />
						<input type="button" value="목록" onclick="checkAction('SALL')" />
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>