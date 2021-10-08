package a.b.c.com.common;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

/* xml 파싱하여 html 파일과 동일한 내용인데, java에서 읽은 버전. */
public class ReadXMLFile {
	public static void main(String argv[]){
		try{
			String xmlFilePath = CommonXML.XML_FILE_PATH;
			System.out.println("xmlFilePath >>> : " + xmlFilePath);
			// File 객체 이용해서 물리적 경로(절대 경로)에 있는 xmlFile 가져온 것
			File fXmlFile = new File(xmlFilePath + "/file.xml");
			
			// 팩토리 패턴 ::
			// xml로 만들 공장을 만들고
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			// 공장에서 작업 준비하고
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			// 확장자가 xml인 xml 문자 파일을 xml 형식으로 파싱해서
			// Dom 파서의 Document 인터페이스에 전달한다.
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("staff");
			System.out.println("-------------------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++){
				Node nNode = nList.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE){
					Element eElement = (Element)nNode;
					System.out.println("First Name : " + getTagValue("firstname", eElement));
					System.out.println("Last Name : " + getTagValue("lastname", eElement));
					System.out.println("Nick Name : " + getTagValue("nickname", eElement));
					System.out.println("Salary : " + getTagValue("salary", eElement));
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	private static String getTagValue(String sTag, Element eElement){
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node)nlList.item(0);
		return nValue.getNodeValue();
	}
}
