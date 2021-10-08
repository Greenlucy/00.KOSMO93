package a.b.c.com.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class OracleJsonTest {

	@SuppressWarnings("unchecked")
	public static String getJson(String tableName){
		
		// ����� ��ü ����, �ʱ�ȭ
		Connection con = null;
		Statement stmt = null;
		ResultSet rsRs = null;
		ResultSetMetaData resultMeta = null;
		int colCount = 0; 
		String jArrStr = "";
		
		try{
			// CommonJSONŬ���� �Լ��� �̿��ؼ� DB�� ����
			con = CommonJSON.getConnection();
			stmt = con.createStatement();
			rsRs = stmt.executeQuery("SELECT * FROM " + tableName);		// tableName�� �Է¹޾Ƽ�, sql ���� �ϼ�
			
			resultMeta = rsRs.getMetaData();							// ��� �� �� ������ ���� ��..
			colCount = resultMeta.getColumnCount();
			
			// JSONArray �ν��Ͻ�
			JSONArray jArr = new JSONArray();
			// JSONObject Ŭ���� ���� ����, �ʱ�ȭ
			JSONObject jObj = null;
			
			// Ŀ���Լ� : �� ������ŭ �ݺ� ( ��> )
			while(rsRs.next()){
				// JSONObject �ν��Ͻ�
				jObj = new JSONObject();
				
				// for : �÷� ������ŭ �ݺ� ( | )
				for (int i=0; i < colCount; i++){
					// i+1��° �÷� �̸� get���� �����Ͽ�, columnName ������ ����
					String columnName = resultMeta.getColumnName(i+1);
					// i+1��° �÷��� data get���� �����Ͽ�, dataName ������ ����
					String dataName = rsRs.getString(i+1);
					
					// Object������ put()�Լ� ����Ͽ�, jObj ������ ���
					// (key,value)���·� ��� ��.
					// [ Object java.util.HashMap.put(Object key, Object value) ]
					jObj.put(columnName, dataName);
				
				} // end of for
				
				// ���ٸ�, 
				if (jObj != null){
					// String ������ add()�Լ� ����Ͽ� jObj ��ü ���� ���
					jArr.add(jObj);
				
					// ���ڿ��� ��ȯ�Ͽ� jArrStr�� ���
					jArrStr = jArr.toString();
				}else{
					System.out.println("jObj >>> : " + jObj);
				}
			}
		}catch(Exception e){
			System.out.println("getJson() : " + e);
		}
		
		
		return jArrStr;
	}
	
	public static boolean jsonParse(String fileName, String jsonVal){
		
		boolean bool = false;
		
		try {
			// CommonJSON Ŭ������ ��� ����Ͽ�
			// ��� + ���ϸ� + Ȯ����(.json) 
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(CommonJSON.JSON_FILE_PATH + "/" + fileName.toLowerCase() + ".json"));
			
			bw.write(jsonVal);
			bw.flush();
			bw.close();	// ������ �ݾ���� �Ѵ�.
			
			bool = true;
		}catch(Exception e){
			System.err.println(e);
		}
		
		return bool;
	}
	
	public static void main(String[] args){
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("json ������ ������ ���̺� �̸��� �Է��Ͻÿ� !!");
			String tableName = sc.next();
			
			// �Է¹��� �� tableName�� ������� �ʴٸ�,
			if (tableName != null && tableName.length() > 0){
				// tableName�� getJson �Լ��� �־ return ���� ���ڿ� ���� s�� �����ص���.
				// getJson() : �÷�(for), ��(while) �ݺ��� �̿��Ͽ� data �����ϰ�, String������ �����ϴ� �Լ�
				// 				>> maybe : JSON
				String s = OracleJsonTest.getJson(tableName);
				System.out.println("s >>> : \n" + s);
				System.out.println("s.length() >>> : \n" + s.length());
				
				if (s.length() > 0){
					// jsonParse() �Լ��� tableName, tableVal�־ ������ boolean�� �����Ͽ� bool������ ����.
					boolean bool = OracleJsonTest.jsonParse(tableName, s);
					
					if (bool){
						File f = new File(CommonJSON.JSON_FILE_PATH + "/" + tableName.toLowerCase() + ".json");
						System.out.println("\n" + f.getName() + " ������ �� �����Ǿ����ϴ�. ");
					}else{
						System.out.println("������ �������� �ʾҽ��ϴ�.");
					}
				}else{
					System.out.println("s.length() >>> : " + s.length());
				}
			}else{
				System.out.println("main() : tableName >>> : " + tableName);
			}
		}catch(Exception e){
			System.out.println("������ >>> : " + e.getMessage());
		}
		
	}	// end of main()
}
