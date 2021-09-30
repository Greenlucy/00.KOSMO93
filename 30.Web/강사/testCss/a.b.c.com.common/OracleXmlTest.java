package a.b.c.com.common;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OracleXmlTest {
	
	public static final String XML_PROLOG = "<?xml version='1.0' encoding='euc-kr'?>"; //�����
		
	public String getXml(final String tableName) throws Exception{
System.out.println("String tableName >>>> : " + tableName);			
		
		Connection con = null;			
		Statement stmt = null;
		ResultSet rsRs = null;
		
		ResultSetMetaData resultMeta = null;		
		int colCount = 0;		
		StringBuffer strBuffer = new StringBuffer(XML_PROLOG);
			
		try{
			con = CommonXML.getConnection();
			stmt = con.createStatement();
			rsRs = stmt.executeQuery("SELECT * FROM "+ tableName);	
			
			resultMeta = rsRs.getMetaData();

			colCount = resultMeta.getColumnCount();
System.out.println(tableName + " ���̺� �÷� ī��� >>> : " + colCount);
								
			strBuffer.append("\n");	
			strBuffer.append("<" +  tableName.toUpperCase() + ">");		
			strBuffer.append("\n");	
	
			while (rsRs.next()){
				for ( int i=0; i < colCount; i++){
					strBuffer.append("<"+resultMeta.getColumnName(i+1)+ ">");
					strBuffer.append(rsRs.getString(i+1));
					strBuffer.append("</"+resultMeta.getColumnName(i+1)+ ">");
					strBuffer.append("\n");
				}				
			}		
			strBuffer.append("</" +  tableName.toUpperCase()  + ">");		
			strBuffer.append("\n");				
		}catch(SQLException e) {
			System.out.println(" getXML() : "+e);
		}finally {}			
		
		return strBuffer.toString();
	}
	
	public static boolean xmlParse(String fileName, String xmlVal){
		
		boolean bool = false;
		
		try {
			
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(CommonXML.XML_FILE_PATH + "/" + fileName.toLowerCase() + ".xml"));
			bw.write(xmlVal);
			bw.flush();
			bw.close(); //������ �ݾ�����Ѵ�.
			
			bool = true;
		}catch(IOException e){
			System.err.println(e);
		}
		
		return bool;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			OracleXmlTest ox = new OracleXmlTest();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("���̺� �̸��� KEY-IN �Ͻÿ� >>> : ");
			String tableName = sc.next();
			
			if(tableName.length() > 0){		
				
				final String fileName = tableName; 
				
				String xmlVal = ox.getXml(fileName);
				System.out.println("Oralce String Data�� xml�� ���� >>> : \n" + xmlVal);
				
				if (xmlVal !=null && xmlVal.length() > 0){
					
					boolean bool = xmlParse(fileName, xmlVal);
					if (bool){
						System.out.println(CommonXML.XML_FILE_PATH +" ���丮�� " + fileName +".xml ������ �� ���� �Ǿ����ϴ�. ");
					}else{
						System.out.println(" ������ ���� ���� �ʾҽ��ϴ�. ");
					}	
				}
			}else{	
				System.out.println("java OracleXmlTest ���̺��̸� ");
			}				
		}catch(Exception e){
			System.out.println("e.getMessage() >>> : " + e.getMessage());
		}	
	}
}
