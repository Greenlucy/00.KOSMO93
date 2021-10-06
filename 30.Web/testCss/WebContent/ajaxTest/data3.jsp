<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%	
	// String id = request.getParameter("id");	
    // System.out.println(" jqueryIdCheck :: id >>> " + id);	
	
	int idNcnt = 0;	
	boolean bool = false;
	
	if (idNcnt == 0){
		out.print("{\"bools\":\"success\"}");
	}else{
		out.print("{\"bools\":\"fail\"}");
	}
%>    
