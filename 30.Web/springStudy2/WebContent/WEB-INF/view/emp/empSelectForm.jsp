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
			alert('�˻���ư Ŭ��! >>> ��ü��ȸ ���ǰ˻� ��Ʈ�ѷ��� �̵�');
			
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
				showOn: "both", // ��ư�� �ؽ�Ʈ �ʵ� ��� Ķ������ �����ش�. 
				buttonImage: "/application/db/jquery/images/calendar.gif", // ��ư �̹��� 
				buttonImageOnly: true, // ��ư�� �ִ� �̹����� ǥ���Ѵ�. 
				changeMonth: true, // ���� �ٲܼ� �ִ� ����Ʈ �ڽ��� ǥ���Ѵ�. 
				changeYear: true, // ���� �ٲ� �� �ִ� ����Ʈ �ڽ��� ǥ���Ѵ�. 
				minDate: '-100y', // ���糯¥�κ��� 100���������� ���� ǥ���Ѵ�. 
				nextText: '���� ��', // next �������� ����. 
				prevText: '���� ��', // prev �������� ����. 
				numberOfMonths: [1,1], // �ѹ��� �󸶳� ���� ���� ǥ���Ұ��ΰ�. [2,3] �� ���, 2(��) x 3(��) = 6���� ���� ǥ���Ѵ�. 
				stepMonths: 3, // next, prev ��ư�� Ŭ�������� �󸶳� ���� ���� �̵��Ͽ� ǥ���ϴ°�. 
				yearRange: 'c-100:c+10', // �⵵ ���� ����Ʈ�ڽ��� ���� �⵵���� ����, ���ķ� ���� ������ ǥ���Ұ��ΰ�. 
				showButtonPanel: true, // Ķ���� �ϴܿ� ��ư �г��� ǥ���Ѵ�. 
				currentText: '���� ��¥' , // ���� ��¥�� �̵��ϴ� ��ư �г� 
				closeText: '�ݱ�', // �ݱ� ��ư �г� 
				dateFormat: "yy-mm-dd", // �ؽ�Ʈ �ʵ忡 �ԷµǴ� ��¥ ����. 
				showAnim: "slide", //�ִϸ��̼��� �����Ѵ�. 
				showMonthAfterYear: true , // ��, ����� ����Ʈ �ڽ��� ��,�� ������ �ٲ��ش�. 
				dayNamesMin: ['��', 'ȭ', '��', '��', '��', '��', '��'], // ������ �ѱ� ����. 
				monthNamesShort: ['1��','2��','3��','4��','5��','6��','7��','8��','9��','10��','11��','12��'] // ���� �ѱ� ����. 
				yearRange: "2010:2013" //���� ����
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
		<option value="key_00">��ü-----------</option>
		<option value="key_01">���</option>
		<option value="key_02">�̸�</option>
	</select>
	<input type="text" id="keyword" name="keyword" placeholder="�˻��� �Է�"><br>	
	<!--
	<input type="text" id="startDate" name="startDate" style="text-align:left; width:100px; height:13px;" placeholder="������ "> 
	 -->		
	<input type="text" id="startDate" name="startDate" size="10" placeholder="������ ">
	~
	<!-- 
	<input type="text" id="endDate" name="endDate" style="text-align:left; width:100px; height:13px;" placeholder="������">
	 -->
	<input type="text" id="endDate" name="endDate" size="10" placeholder="������"><br>	
	<input type="button" id="search_btn" name="search_btn" value="�˻�">
	<input type="reset" id="reset_btn" name="reset_btn" value="����"><br>
</form>
</body>
</html>