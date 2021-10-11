<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>EMP SELECT FORM</title>
<!-- 
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> 
 -->
<link rel="stylesheet" href="/springStudy2/calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="/springStudy2/calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.js"></script>

<script type="text/javascript">

	$(document).ready(function(){
		alert(">>>>");
		
		$("#search_btn").click(function(){
			alert('검색버튼 클릭! >>> 전체조회 조건검색 컨트롤러로 이동');
			
			$("#empSearchForm").attr({
				"method":"GET",
				"action":"empSelect.hbe"
			}).submit();
		});
		
		$("#startDate").datepicker({
			showOn: "button",			
	        buttonImage: "/springStudy2/calendar_datepicker/images/calendar.gif",
	        dateFormat: 'yy-mm-dd',
		    buttonImageOnly: false,
			buttonText: "Select date"
		});
		
		$("#endDate").datepicker({
			showOn: "button",
	        buttonImage: "/springStudy2/calendar_datepicker/images/calendar.gif",
	        dateFormat: 'yy-mm-dd',
		    buttonImageOnly: false,
			buttonText: "Select date"
			
			/*
				showOn: "both", // 버튼과 텍스트 필드 모두 캘린더를 보여준다. 
				buttonImage: "/application/db/jquery/images/calendar.gif", // 버튼 이미지 
				buttonImageOnly: true, // 버튼에 있는 이미지만 표시한다. 
				changeMonth: true, // 월을 바꿀수 있는 셀렉트 박스를 표시한다. 
				changeYear: true, // 년을 바꿀 수 있는 셀렉트 박스를 표시한다. 
				minDate: '-100y', // 현재날짜로부터 100년이전까지 년을 표시한다. 
				nextText: '다음 달', // next 아이콘의 툴팁. 
				prevText: '이전 달', // prev 아이콘의 툴팁. 
				numberOfMonths: [1,1], // 한번에 얼마나 많은 월을 표시할것인가. [2,3] 일 경우, 2(행) x 3(열) = 6개의 월을 표시한다. 
				stepMonths: 3, // next, prev 버튼을 클릭했을때 얼마나 많은 월을 이동하여 표시하는가. 
				yearRange: 'c-100:c+10', // 년도 선택 셀렉트박스를 현재 년도에서 이전, 이후로 얼마의 범위를 표시할것인가. 
				showButtonPanel: true, // 캘린더 하단에 버튼 패널을 표시한다. 
				currentText: '오늘 날짜' , // 오늘 날짜로 이동하는 버튼 패널 
				closeText: '닫기', // 닫기 버튼 패널 
				dateFormat: "yy-mm-dd", // 텍스트 필드에 입력되는 날짜 형식. 
				showAnim: "slide", //애니메이션을 적용한다. 
				showMonthAfterYear: true , // 월, 년순의 셀렉트 박스를 년,월 순으로 바꿔준다. 
				dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], // 요일의 한글 형식. 
				monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] // 월의 한글 형식. 
				yearRange: "2010:2013" //연도 범위
			*/
		});
	});
		
</script>

</head>
<body>
<h3>EMP SELECT FORM</h3>
<hr>
<form name="empSearchForm" id="empSearchForm">
	<select id="searchFilter" name="searchFilter">
		<option value="key_00">전체-----------</option>
		<option value="key_01">사번</option>
		<option value="key_02">이름</option>
	</select>
	<input type="text" id="keyword" name="keyword" placeholder="검색어 입력"><br>	
	<!--
	<input type="text" id="startDate" name="startDate" style="text-align:left; width:100px; height:13px;" placeholder="시작일 "> 
	 -->		
	<input type="text" id="startDate" name="startDate" size="10" placeholder="시작일 ">
	~
	<!-- 
	<input type="text" id="endDate" name="endDate" style="text-align:left; width:100px; height:13px;" placeholder="종료일">
	 -->
	<input type="text" id="endDate" name="endDate" size="10" placeholder="종료일"><br>	
	<input type="button" id="search_btn" name="search_btn" value="검색">
	<input type="reset" id="reset_btn" name="reset_btn" value="리셋"><br>
</form>
</body>
</html>