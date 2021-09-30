<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="javax.xml.parsers.DocumentBuilderFactory" %> 
<%@ page import="javax.xml.parsers.DocumentBuilder" %>
<%@ page import="org.w3c.dom.Document" %>
<%@ page import="org.w3c.dom.NodeList" %>
<%@ page import="org.w3c.dom.Node" %>
<%@ page import="org.w3c.dom.Element" %>
<%@ page import="java.io.File" %>

<%@ page import="a.b.c.com.common.CommonXML" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%!
	// jsp 에서 함수를 사용하려먼 <%! 에서 사용하면 된다. 
	private static String getTagValue(String sTag, Element eElement) 
	{
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
%>
<%
	// Tomcat 서버에서 웹 서버(코요테)위치에 있는 file.xml 파일을 
	// Tomcat 서버가 설치된 로컬 경로에 있는 물리적 파일 위치를 찾아서 
	// java.io.File 객체로 읽오는 것이다. 
	// java.io.File 객체를 물리적 경로를 읽는 객체이다. 
	String xmlFilePath = CommonXML.XML_FILE_PATH;
	out.println("xmlFilePath >>> : " + xmlFilePath + "<br>");
	String path = xmlFilePath + "/file.xml";
	out.println("path >>> : " + path + "<br>");
	// String xmlFilePath = "/testJsp/xml";
	File fXmlFile = new File(path);
	out.println("fXmlFile >>> : " + fXmlFile + "<br>");
	
	// 팩토리 디자인 패턴 : 형식 : xml 파일을 읽어서 파싱할 때 이 패턴이 좋다 
	// 물리적인 xml 파일을 xml 객체로 변환하기 위해서 팩토리 디자인 패턴을 이용한다. 	
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	
	// parse() 함수가 물리적인 xml 파일을 파싱해서 메모리에 xml 객체로 변환 시킨다.  
	Document doc = dBuilder.parse(fXmlFile);	
	// xml 문서를 깨끗하게 만드세요 
	doc.getDocumentElement().normalize();
	
	out.println("Root element : " + doc.getDocumentElement().getNodeName() + "<br>");
	NodeList nList = doc.getElementsByTagName("staff");
	out.println("-----------------------<br>");
	
	for (int temp = 0; temp < nList.getLength(); temp++) {
		
		Node nNode = nList.item(temp);
		
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
			Element eElement = (Element) nNode;
		
			out.println("First Name : " + getTagValue("firstname", eElement) + "<br>");
			out.println("Last Name : " + getTagValue("lastname", eElement) + "<br>");
			out.println("Nick Name : " + getTagValue("nickname", eElement) + "<br>");
			out.println("Salary : " + getTagValue("salary", eElement) + "<br>");
	
		}
	}
%>
</body>
</html>