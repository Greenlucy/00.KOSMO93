package a.b.c.com.common;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class CommonJSON {
	
	// file path
	public static final String JSON_FILE_PATH = "C:\\00.KOSMO93\\30.Web\\el_web_neon_work\\testCss\\WebContent\\jsonTest";
	
	private static final String KOS_URL = "jdbc:oracle:thin:@localhost:1521:orclKOSMO00";
	private static final String KOS_USER = "scott";
	private static final String KOS_PASS = "tiger";
	private static final String KOS_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	public static Connection getConnection(){
		
		Connection conn = null;
		
		try{
			Class.forName(CommonJSON.KOS_DRIVER);
			conn = DriverManager.getConnection(CommonJSON.KOS_URL,
												CommonJSON.KOS_USER,
												CommonJSON.KOS_PASS);
		}catch(Exception e){
			System.out.println("드라이버 찾기에 문제가 발생 >>> : " + e);
		}
		return conn;
	}
}
