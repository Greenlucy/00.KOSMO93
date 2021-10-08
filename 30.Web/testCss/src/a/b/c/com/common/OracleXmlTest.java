package a.b.c.com.common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class OracleXmlTest {
	public static final String XML_PROLOG = "<?xml version='1.0' encoding='EUC-KR'?>";	// �����
	
	// [8] �Լ� ȣ��
	public String getXml(final String tableName) throws Exception{
		System.out.println("String tableName >>> : " + tableName);
		
		// ����� ��ü �����ϰ� �ʱ�ȭ
		Connection con = null;
		Statement stmt = null;
		ResultSet rsRs = null;
		
		ResultSetMetaData resultMeta = null;
		int colCount = 0;
		// [9] ��ü �޸𸮿� �ν��Ͻ�, ��� �ƱԸ�Ʈ�� �Է� : xml ���� �� �� ���� ����
		StringBuffer strBuffer = new StringBuffer(XML_PROLOG);
		
		try {
			// [10] DB ����
			con = CommonXML.getConnection();
			stmt = con.createStatement();
			rsRs = stmt.executeQuery("SELECT * FROM " + tableName);
			// 
			resultMeta = rsRs.getMetaData();
			
			colCount = resultMeta.getColumnCount();
			System.out.println(tableName + " ���̺� �÷� ī��Ʈ >>> : " + colCount);
			
			strBuffer.append("\n");
			strBuffer.append("<" + tableName.toUpperCase() + ">");
			strBuffer.append("\n");
			
			while (rsRs.next()){
				for (int i=0; i< colCount; i++){
					strBuffer.append("<" + resultMeta.getColumnName(i+1) + "> ");
					strBuffer.append(rsRs.getString(i+1));
					strBuffer.append(" </" + resultMeta.getColumnName(i+1) + ">");
					strBuffer.append("\n");
				}
				strBuffer.append("\n");
			}
			strBuffer.append("</" + tableName.toUpperCase() + ">");
			strBuffer.append("\n");
		}catch(Exception e){
			System.out.println(" getXML() : " + e);
		}
		
		return strBuffer.toString();
	}
	
	public static boolean xmlParse(String fileName, String xmlVal){
		
		boolean bool = false;
		 
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(CommonXML.XML_FILE_PATH + "/" + fileName.toLowerCase() + ".xml"));
			bw.write(xmlVal);
			bw.flush();
			bw.close();	// ������ �ݾ���� ��
		
			bool = true;
		}catch(Exception e){
			System.err.println(e);
		}
		return bool;
	}
	
	// [0] main() �Լ� : ���α׷� ������
	public static void main(String[] args){
		try{
			// [1] OracleXmlTest Ŭ���� �ν��Ͻ� (�ڽ�)
			OracleXmlTest ox = new OracleXmlTest();
			
			// [2] ���� ��� �Է� ����
			Scanner sc = new Scanner(System.in);
			// [3] �ֿܼ� ���
			System.out.println("���̺� �̸��� KEY-IN �Ͻÿ� >>> : ");
			// [4] �Է¹��� ���� ��� > ���ڿ� ���� tableName�� �Ҵ�
			String tableName = sc.next();
			
			// [5] ����, tableName�� ���̰� 0���� ũ�� (== �Է¹��� ��Ұ� �ִ�.)��,
			// 			����Ǵ� if��
			// ���α׷����� �����͸� ������ ������
			// 1. �����͸� �������� 
			// 1.1 �����͸� ������ �� �����͸� �ִ� ���� �����Ͱ� �ִ��� Ȯ���ϱ� (Ư��, ����API���� �� �� ��)
			// 2. ������ �����Ͱ� �ִ��� ������ Ȯ���ϱ�
			// 3. ������ �����Ͱ� ������ ��� ������� �ִ��� Ȯ���ϱ�
			if (tableName.length() > 0){
				// [6] ���ڿ� ��� fileName�� �Ҵ� (�̸��� �ٸ�) > �����ϱ� ����
				final String fileName = tableName;
				
				// [7] getXml(final String tableName) �Լ� ȣ���ؼ�,
				// 	      ���ڿ� xmlVal ������ �Ҵ�
				String xmlVal = ox.getXml(fileName);
				System.out.println("Oracle String Data�� xml�� ���� >>> : " + xmlVal);
				
				if (xmlVal != null && xmlVal.length() > 0){
					boolean bool = xmlParse(fileName, xmlVal);
					if (bool){
						System.out.println(CommonXML.XML_FILE_PATH + " ���丮�� " + fileName + ".xml ������ �� �����Ǿ����ϴ�.");
					}else{
						System.out.println(" ������ �������� �ʾҽ��ϴ�.");
					}
				}
			}else{
				System.out.println("java OracleXmlTest ���̺��̸�");
			}
			
		}catch(Exception e){
			System.out.println("e.getMessage() >>> : " + e.getMessage());
		}
	}
}
