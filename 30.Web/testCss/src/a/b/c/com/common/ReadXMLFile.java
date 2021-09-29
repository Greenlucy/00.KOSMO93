package a.b.c.com.common;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class ReadXMLFile {
	public static void main(String argv[]){
		try{
			String xmlFilePath = CommonXML.XML_FILE_PATH;
			File fXmlFile = new File(xmlFilePath + "/file.xml");
			// xml�� ���� ������ �����
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			// ���忡�� �۾� �غ��ϰ�
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			// Ȯ���ڰ� xml�� xml ���� ������ xml �������� �Ľ��ؼ�
			// Dom �ļ��� Document �������̽��� �����Ѵ�.
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
