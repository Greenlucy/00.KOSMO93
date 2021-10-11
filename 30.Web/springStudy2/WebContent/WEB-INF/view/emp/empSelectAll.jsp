<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="a.b.c.com.emp.vo.EmpVO" %>
<%@ page import="java.util.List" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>EMP SELECT ALL</title>
</head>
<body>
<h3>EMP SELECT ALL : jsp </h3>
<hr>
<%
	Object obj = request.getAttribute("listAll");
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

<h3>EMP SELECT ALL : jstl & el </h3>
<hr>
	<c:forEach items="${listAll}" var="emp">
		${emp.empno}
		${emp.ename}
		${emp.hiredate}<br>
	</c:forEach>
		
<h3>EMP SELECT ALL : jsp & el </h3>
<hr>	
<%
	Object obj1 = request.getAttribute("listAll");
	if (obj1 == null){ return; }
	
	List<EmpVO> list1 = (List<EmpVO>)obj1;
	pageContext.setAttribute("list11", list1);	
	
%>
		${list11[0].empno } ${list11[0].ename } ${list11[0].hiredate }<br>
		${list11[1].empno } ${list11[1].ename } ${list11[1].hiredate }<br>
</body>
</html>