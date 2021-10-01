package a.b.c.com.common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class OracleXmlTest {
	public static final String XML_PROLOG = "<?xml version='1.0' encoding='EUC-KR'?>";	// 선언부
	
	// [8] 함수 호출
	public String getXml(final String tableName) throws Exception{
		System.out.println("String tableName >>> : " + tableName);
		
		// 사용할 객체 선언하고 초기화
		Connection con = null;
		Statement stmt = null;
		ResultSet rsRs = null;
		
		ResultSetMetaData resultMeta = null;
		int colCount = 0;
		// [9] 객체 메모리에 인스턴스, 상수 아규먼트로 입력 : xml 파일 맨 위 문구 삽입
		StringBuffer strBuffer = new StringBuffer(XML_PROLOG);
		
		try {
			// [10] DB 연결
			con = CommonXML.getConnection();
			stmt = con.createStatement();
			rsRs = stmt.executeQuery("SELECT * FROM " + tableName);
			// 
			resultMeta = rsRs.getMetaData();
			
			colCount = resultMeta.getColumnCount();
			System.out.println(tableName + " 테이블 컬럼 카운트 >>> : " + colCount);
			
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
			bw.close();	// 무조건 닫아줘야 한
		
			bool = true;
		}catch(Exception e){
			System.err.println(e);
		}
		return bool;
	}
	
	// [0] main() 함수 : 프로그램 시작점
	public static void main(String[] args){
		try{
			// [1] OracleXmlTest 클래스 인스턴스 (자신)
			OracleXmlTest ox = new OracleXmlTest();
			
			// [2] 다음 요소 입력 받음
			Scanner sc = new Scanner(System.in);
			// [3] 콘솔에 출력
			System.out.println("테이블 이름을 KEY-IN 하시오 >>> : ");
			// [4] 입력받은 다음 요소 > 문자열 변수 tableName에 할당
			String tableName = sc.next();
			
			// [5] 만약, tableName의 길이가 0보다 크다 (== 입력받은 요소가 있다.)면,
			// 			실행되는 if문
			// 프로그램에서 데이터를 실행할 때에는
			// 1. 데이터를 가져오기 
			// 1.1 데이터를 가져올 때 데이터를 주는 곳에 데이터가 있는지 확인하기 (특히, 오픈API같은 거 쓸 때)
			// 2. 가져온 데이터가 있는지 없는지 확인하기
			// 3. 가져온 데이터가 있으면 어떻한 모습으로 있는지 확인하기
			if (tableName.length() > 0){
				// [6] 문자열 상수 fileName에 할당 (이름이 다름) > 변경하기 위함
				final String fileName = tableName;
				
				// [7] getXml(final String tableName) 함수 호출해서,
				// 	      문자열 xmlVal 변수에 할당
				String xmlVal = ox.getXml(fileName);
				System.out.println("Oracle String Data를 xml로 생성 >>> : " + xmlVal);
				
				if (xmlVal != null && xmlVal.length() > 0){
					boolean bool = xmlParse(fileName, xmlVal);
					if (bool){
						System.out.println(CommonXML.XML_FILE_PATH + " 디렉토리에 " + fileName + ".xml 파일이 잘 생성되었습니다.");
					}else{
						System.out.println(" 파일이 생성되지 않았습니다.");
					}
				}
			}else{
				System.out.println("java OracleXmlTest 테이블이름");
			}
			
		}catch(Exception e){
			System.out.println("e.getMessage() >>> : " + e.getMessage());
		}
	}
}
