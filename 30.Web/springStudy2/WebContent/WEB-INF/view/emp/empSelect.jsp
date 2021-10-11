<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="a.b.c.com.emp.vo.EmpVO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>EMP SELECT</title>
</head>
<body>
<h3>EMP SELECT</h3>
<hr>
<%
	Object obj = request.getAttribute("searchList");
	if (obj == null){ return; }
	
	List<EmpVO> list = (List<EmpVO>)obj;
	if (list.size() > 0){
		for (int i=0; i < list.size(); i++){
			EmpVO evo = list.get(i);
%>
			<%= evo.getEmpno() %>			
			<%= evo.getEname() %>
			<%= evo.getHiredate() %><br>
<%			
			//out.println(evo.getEmpno());
			//out.println(evo.getEname());
			//out.println(evo.getHiredate() + "<br>");
		}
	}
%>
</body>
</html>