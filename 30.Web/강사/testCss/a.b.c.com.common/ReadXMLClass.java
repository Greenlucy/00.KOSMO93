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
			// Tomcat �������� �� ����(�ڿ���)��ġ�� �ִ� fileClass.xml ������ 
			// Tomcat ������ ��ġ�� ���� ��ο� �ִ� ������ ���� ��ġ�� ã�Ƽ� 
			// java.io.File ��ü�� �п��� ���̴�. 
			// java.io.File ��ü�� ������ ��θ� �д� ��ü�̴�. 
			String xmlFilePath = CommonXML.XML_FILE_PATH;
			File fXmlFile = new File( xmlFilePath + "/fileClass.xml");
			
			// ���丮 ������ ���� : ���� : xml ������ �о �Ľ��� �� �� ������ ���� 
			// �������� xml ������ xml ��ü�� ��ȯ�ϱ� ���ؼ� ���丮 ������ ������ �̿��Ѵ�. 	
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			// parse() �Լ��� �������� xml ������ �Ľ��ؼ� �޸𸮿� xml ��ü�� ��ȯ ��Ų��.
			Document doc = dBuilder.parse(fXmlFile);
			// xml ������ �����ϰ� ���弼�� 
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
