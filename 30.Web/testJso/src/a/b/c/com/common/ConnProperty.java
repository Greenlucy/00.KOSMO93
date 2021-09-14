package a.b.c.com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class ConnProperty {

	// 상수 선언 : 4type thin 드라이브 사용
	// 데이터베이스 연결 정보 : DataSource 라고 부른다.
	// [25]
	public static final String KOS_URL = "jdbc:oracle:thin:@localhost:1521:orclKOSMO00";
	// [25]
	public static final String KOS_USER = "jso00";
	// [25]
	public static final String KOS_PASS = "jso1234";
	// [23] 상수 사용
	public static final String KOS_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	// [20] static이니까 ConnProperty.getConnection() 함수 호출
	public static Connection getConnection(){
		
		// [21]
		// 객체를 지역변수 선언, 초기화
		Connection conn = null;
		
		try{
			// [22] forName()함수 사용 : 메모리에 올리기
			Class.forName(ConnProperty.KOS_DRIVER);
			// [24] 변수 conn에 데이터베이스 연결하여 저장
			conn = DriverManager.getConnection(  ConnProperty.KOS_URL
												,ConnProperty.KOS_USER
												,ConnProperty.KOS_PASS);
		}catch(Exception c){
			System.out.println("드라이버 찾기에 문제가 발생 >>> : " + c);
		}
		// [26] return 
		return conn;
	}
	
	public static void conClose(Connection conn, PreparedStatement pstmt, ResultSet rsRs){
		try{
			if (rsRs != null){
				try{
					rsRs.close(); 
					rsRs = null;
				}catch(Exception e){}
			}
			if (pstmt != null) {
				try{
					pstmt.close();
					pstmt = null;
				}catch(Exception e){}
			}
			if (conn != null){
				try{
					conn.close();
					conn = null;
				}catch(Exception e){}
			}
		}catch(Exception e2){}
	}
	
	// [38] ConnProperty.conclose() 함수 호출
	public static void conClose(Connection conn, PreparedStatement pstmt){
		try{
			if (pstmt != null) {
				try{
					pstmt.close();
					pstmt = null;
				}catch(Exception e){}
			}
			if (conn != null){
				try{
					conn.close();
					conn = null;
				}catch(Exception e){}
			}
		}catch(Exception e2){}
	}
}
