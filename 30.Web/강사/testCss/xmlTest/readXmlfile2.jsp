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
	// jsp ���� �Լ��� ����Ϸ��� <%! ���� ����ϸ� �ȴ�. 
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
%>
<%
	// Tomcat �������� �� ����(�ڿ���)��ġ�� �ִ� file.xml ������ 
	// �� ����(�ڿ���)��ġ�� �ִ� file.xml ������ ���ؽ�Ʈ�� ����θ� �̿��ؼ� 
	// url �������� �о� �´�. 
	String xmlURLPath = "http://localhost:8088/testCss/xmlTest/file.xml";
	out.println("xmlFilePath >>> : " + xmlURLPath + "<br>");
	// ������ ���� ��� �б� 
	// String xmlFilePath = CommonXML.XML_FILE_PATH;
	// File fXmlFile = new File(xmlFilePath + "/file.xml");
	// File fXmlFile = new File("/testCss/xmlTest/file.xml");
	
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	
	//Document doc = dBuilder.parse(fXmlFile);	
	// parse �Լ�������  url ��ε� ���� �� �ִ�. 
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