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
			/* Tomcat 서버에서 웹 서버(코요테)위치에 있는 fileClass.xml 파일을
				Tomcat 서버가 설치된 로컬 경로에 있는 물리적 파일 위치를 찾아서 
				java.io.File 객체로 읽어오는 것이다.
				java.io.File 객체는 물리적 경로를 읽는 객체이다.
			*/
			String xmlFilePath = CommonXML.XML_FILE_PATH;
			File fXmlFile = new File(xmlFilePath + "/fileAttrClass.xml");
			
			// 팩토리 디자인 패턴 : 형식 : xml 파일을 읽어서 파싱할 때 이 패턴이 좋다.
			// 물리적인 xml 파일을 xml 객체로 변환하기 위해서 팩토리 디자인 패턴을 이용한다.
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			// parse() 함수가 물리적인 xml 파일을 파싱해서 메모리에 xml 객체로 변환시킨다.
			Document doc = dBuilder.parse(fXmlFile);
			// xml 문서를 깨끗하게 만드세요.
			doc.getDocumentElement().normalize();
			
			// getNodeName() : 
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
