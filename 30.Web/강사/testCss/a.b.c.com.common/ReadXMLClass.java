package a.b.c.com.common;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
 
public class ReadXMLClass {
	
	public static void main(String argv[]) {
		
		String testClass = "";
		
		try {
			// Tomcat 서버에서 웹 서버(코요테)위치에 있는 fileClass.xml 파일을 
			// Tomcat 서버가 설치된 로컬 경로에 있는 물리적 파일 위치를 찾아서 
			// java.io.File 객체로 읽오는 것이다. 
			// java.io.File 객체를 물리적 경로를 읽는 객체이다. 
			String xmlFilePath = CommonXML.XML_FILE_PATH;
			File fXmlFile = new File( xmlFilePath + "/fileClass.xml");
			
			// 팩토리 디자인 패턴 : 형식 : xml 파일을 읽어서 파싱할 때 이 패턴이 좋다 
			// 물리적인 xml 파일을 xml 객체로 변환하기 위해서 팩토리 디자인 패턴을 이용한다. 	
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			// parse() 함수가 물리적인 xml 파일을 파싱해서 메모리에 xml 객체로 변환 시킨다.
			Document doc = dBuilder.parse(fXmlFile);
			// xml 문서를 깨끗하게 만드세요 
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("testclass");
			System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
	
					testClass = getTagValue("test", eElement);
					System.out.println("test : " + testClass);				     			
				}
			}
			
			try{
				Class cla_1 = Class.forName(testClass);
				TestClass classAction = (TestClass)cla_1.newInstance();
				System.out.println(" classAction >>> : " + classAction);	
				classAction.test();
			}catch (Exception e){}
			
//			catch (ClassNotFoundException e){}
//			catch (InstantiationException i){}
//			catch (IllegalAccessException il){}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
}
