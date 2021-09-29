package a.b.c.com.common;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;

public class ReadXMLAttrClass {
	public static void main(String argv[]){
		String testClass = "";
		
		try{
			String xmlFilePath = CommonXML.XML_FILE_PATH;
			File fXmlFile = new File(xmlFilePath + "/fileAttrClass.xml");
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("test");
			System.out.println("----------------------------------");
			
			for (int temp = 0; temp < nList.getLength(); temp++){
				Node nNode = nList.item(temp);
				System.out.println(" Current Element >>> : " + nNode.getNodeName());
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE){
					Element eElement = (Element) nNode;
					testClass = eElement.getAttribute("className");
					System.out.println("attr className >>> : " + testClass);
				}
			}
			
			try {
				Class cla_1 = Class.forName(testClass);
				TestClass classAction = (TestClass)cla_1.newInstance();
				System.out.println("classAction >>> : " + classAction);
				classAction.test();
			}
			catch(ClassNotFoundException e){}
			catch(InstantiationException i){}
			catch(IllegalAccessException il){}
		}catch(Exception e){
			
		}
	}
}
