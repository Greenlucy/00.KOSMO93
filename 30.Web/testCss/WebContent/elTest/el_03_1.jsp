<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<title>el_03_1</title>
	</head>
<body>
	<h3>el_03_1</h3>
	<hr>
	<%
		String irum = request.getParameter("irum");
		out.println("[��ũ��Ʋ��]<br/>");
		out.println("ȸ������ �̸��� " + irum + "�� �Դϴ�.<br/>");
		out.println(irum + "�Բ��� Ű��� ���� �ֿϵ����� ");
		
		String[] animal = request.getParameterValues("animal");
		if(animal != null){
			for(int i=0; i < animal.length; i++){
				if (i != animal.length - 1){
					out.println(animal[i] + ", ");
				}else{
					out.println(animal[i] + "�Դϴ�.<br/><br/>");
				}
			}
		}else{
			out.println("�����Ͻ� ������ �����ϴ�.<br/><br/>");
		}
	%>
	[EL ����]<br />
	ȸ������ �̸��� ${param.irum }���Դϴ�.<br />
	<br />
	${ param.irum }�Բ��� Ű��� ���� �ֿϵ�����
	${ paramValues.animal[0] }
	${ paramValues.animal[1] }
	${ paramValues.animal[2] }
	${ paramValues.animal[3] }
	${ paramValues.animal[4] }
	${ paramValues.animal[5] }�Դϴ�.
</body>
</html>