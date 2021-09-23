<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	//request.setAttribute(java.lang.String, java.lang.Object);
	//request.getAttribute(java.lang.String);
	
	request.setAttribute("김상진", "김상진은 천재당");
	String kkk = String.valueOf(request.getAttribute("김상진"));
	out.println("kkk >>> : " + kkk + "<br>");
	
	String name = "김상진";
	String age = "29";
	java.util.ArrayList aList = new java.util.ArrayList();
	aList.add(name);
	aList.add(age);
	
	request.setAttribute("kim", aList);
	Object obj = request.getAttribute("kim");
	java.util.ArrayList kLists = (java.util.ArrayList)obj;
	
	for (int i=0; i < kLists.size(); i++){
		out.println(">>> : " + kLists.get(i) + "<br>");
		
	}

%>
</body>
</html>