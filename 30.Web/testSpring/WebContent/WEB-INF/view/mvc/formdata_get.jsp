<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>FORMDATA_GET</title>
</head>
<body>
	<h3>FORMDATA_GET</h3>
	<hr>
	<h3>������ ��Ʈ�ѷ����� request ��ü�� �޾ƿ���</h3>
	<%
		// �̰� �� set Ű ������ �ϸ� �� �޾�����?
		Object obj = request.getAttribute("request_datanum");
		if (obj == null){
			System.out.println("request_datanum key�� ���� value�� �� �Ѿ�ɴϴ�.");
			out.println("request_datanum key�� ���� value�� �� �Ѿ�ɴϴ�." + "<br>");
		}else{
			System.out.println("request_datanum key�� ���� value�� �Ѿ�ɴϴ�.");
			out.println("request_datanum key�� ���� value�� �Ѿ�ɴϴ�."+ "<br>");
		}
		
		String datanum = request.getParameter("datanum");
		String dataid = request.getParameter("dataid");
		String datapw = request.getParameter("datapw");
		String dataname = request.getParameter("dataname");
		
		System.out.println("formdata_get.jsp : datanum >>> : " + datanum);
		System.out.println("formdata_get.jsp : dataid >>> : " + dataid);
		System.out.println("formdata_get.jsp : datapw >>> : " + datapw);
		System.out.println("formdata_get.jsp : dataname >>> : " + dataname);
		
		out.println("datanum >>> : " + datanum + "<br>");
		out.println("dataid >>> : " + dataid + "<br>");
		out.println("datapw >>> : " + datapw + "<br>");
		out.println("dataname >>> : " + dataname + "<br>");
	%>
	<p>
	<h3>������ ��Ʈ�ѷ����� el ��ü�� �޾ƿ���</h3>
	<hr>
	${ el_datanum }<br>
	${ el_dataid }<br>
	${ el_datapw }<br>
	${ el_dataname }<br>
	<h3>������ ��Ʈ�ѷ����� request.setAttribute() ��ü�� �޾ƿ���</h3>
	<hr>
	${ request_datanum }
	${ request_dataid }
	${ request_datapw }
	${ request_dataname }
</body>
</html>