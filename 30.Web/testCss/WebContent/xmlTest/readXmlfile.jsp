<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="org.w3c.dom.Element" %>
    <%@ page import="org.w3c.dom.NodeList" %>
    <%@ page import="org.w3c.dom.Node" %>
    <%@ page import="java.io.File" %>
    <%@ page import="javax.xml.parsers.DocumentBuilderFactory" %>
    <%@ page import="javax.xml.parsers.DocumentBuilder" %>
    <%@ page import="org.w3c.dom.Document" %>
    
    <%@ page import="a.b.c.com.common.CommonXML" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<%!
		// jsp에서 함수를 사용하려면 <%! 에서 사용하면 된다.
		private static String getTagValue(String sTag, Element eElement) {
		
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node)nlList.item(0);
		return nValue.getNodeValue();
	}
	%>
	<%
		String xmlFilePath = CommonXML.XML_FILE_PATH;
		// String xmlFilePath = "/testJsp/xml";
		File fXmlFile = new File(xmlFilePath + "/file.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		
		out.println("Root element : " + doc.getDocumentElement().getNodeName() + "<br>");
		NodeList nList = doc.getElementsByTagName("staff");
		out.println("------------------------------<br>");
		
		for (int temp=0; temp < nList.getLength(); temp++){
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE){
				
				Element eElement = (Element) nNode;
				
				out.println("First Name : " + getTagValue("firstname", eElement) + "<br>");
				out.println("Last Name : " + getTagValue("lastname", eElement) + "<br>");
				out.println("NickName : " + getTagValue("nickname", eElement) + "<br>");
				out.println("Salary : " + getTagValue("salary", eElement) + "<br>");
			}
		}
	%>
</body>
</html>