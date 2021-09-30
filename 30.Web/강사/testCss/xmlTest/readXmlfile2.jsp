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
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
%>
<%
	// Tomcat 서버에서 웹 서버(코요테)위치에 있는 file.xml 파일을 
	// 웹 서버(코요테)위치에 있는 file.xml 파일을 컨텍스트의 상대경로를 이용해서 
	// url 형식으로 읽어 온다. 
	String xmlURLPath = "http://localhost:8088/testCss/xmlTest/file.xml";
	out.println("xmlFilePath >>> : " + xmlURLPath + "<br>");
	// 파일의 절대 경로 읽기 
	// String xmlFilePath = CommonXML.XML_FILE_PATH;
	// File fXmlFile = new File(xmlFilePath + "/file.xml");
	// File fXmlFile = new File("/testCss/xmlTest/file.xml");
	
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	
	//Document doc = dBuilder.parse(fXmlFile);	
	// parse 함수에서는  url 경로도 읽을 수 있다. 
	Document doc = dBuilder.parse(xmlURLPath);	
	
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