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
		
		// 사용할 객체 선언, 초기화
		Connection con = null;
		Statement stmt = null;
		ResultSet rsRs = null;
		ResultSetMetaData resultMeta = null;
		int colCount = 0; 
		String jArrStr = "";
		
		try{
			// CommonJSON클래슷 함수들 이용해서 DB와 연결
			con = CommonJSON.getConnection();
			stmt = con.createStatement();
			rsRs = stmt.executeQuery("SELECT * FROM " + tableName);		// tableName을 입력받아서, sql 쿼리 완성
			
			resultMeta = rsRs.getMetaData();							// 요거 두 개 공부할 때가 됌..
			colCount = resultMeta.getColumnCount();
			
			// JSONArray 인스턴스
			JSONArray jArr = new JSONArray();
			// JSONObject 클래스 변수 선언, 초기화
			JSONObject jObj = null;
			
			// 커서함수 : 행 갯수만큼 반복 ( ㅡ> )
			while(rsRs.next()){
				// JSONObject 인스턴스
				jObj = new JSONObject();
				
				// for : 컬럼 갯수만큼 반복 ( | )
				for (int i=0; i < colCount; i++){
					// i+1번째 컬럼 이름 get으로 리턴하여, columnName 변수에 저장
					String columnName = resultMeta.getColumnName(i+1);
					// i+1번째 컬럼의 data get으로 리턴하여, dataName 변수에 저장
					String dataName = rsRs.getString(i+1);
					
					// Object변수에 put()함수 사용하여, jObj 변수에 담기
					// (key,value)형태로 담는 중.
					// [ Object java.util.HashMap.put(Object key, Object value) ]
					jObj.put(columnName, dataName);
				
				} // end of for
				
				// 담겼다면, 
				if (jObj != null){
					// String 변수에 add()함수 사용하여 jObj 객체 내용 담기
					jArr.add(jObj);
				
					// 문자열로 변환하여 jArrStr에 담기
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
			// CommonJSON 클래스의 상수 사용하여
			// 경로 + 파일명 + 확장자(.json) 
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(CommonJSON.JSON_FILE_PATH + "/" + fileName.toLowerCase() + ".json"));
			
			bw.write(jsonVal);
			bw.flush();
			bw.close();	// 무조건 닫아줘야 한다.
			
			bool = true;
		}catch(Exception e){
			System.err.println(e);
		}
		
		return bool;
	}
	
	public static void main(String[] args){
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("json 파일을 생성할 테이블 이름을 입력하시오 !!");
			String tableName = sc.next();
			
			// 입력받은 값 tableName이 비어있지 않다면,
			if (tableName != null && tableName.length() > 0){
				// tableName을 getJson 함수에 넣어서 return 값을 문자열 변수 s에 저장해두자.
				// getJson() : 컬럼(for), 행(while) 반복문 이용하여 data 리턴하고, String값으로 리턴하는 함수
				// 				>> maybe : JSON
				String s = OracleJsonTest.getJson(tableName);
				System.out.println("s >>> : \n" + s);
				System.out.println("s.length() >>> : \n" + s.length());
				
				if (s.length() > 0){
					// jsonParse() 함수에 tableName, tableVal넣어서 나오는 boolean값 리턴하여 bool변수에 저장.
					boolean bool = OracleJsonTest.jsonParse(tableName, s);
					
					if (bool){
						File f = new File(CommonJSON.JSON_FILE_PATH + "/" + tableName.toLowerCase() + ".json");
						System.out.println("\n" + f.getName() + " 파일이 잘 생성되었습니다. ");
					}else{
						System.out.println("파일이 생성되지 않았습니다.");
					}
				}else{
					System.out.println("s.length() >>> : " + s.length());
				}
			}else{
				System.out.println("main() : tableName >>> : " + tableName);
			}
		}catch(Exception e){
			System.out.println("에러가 >>> : " + e.getMessage());
		}
		
	}	// end of main()
}
