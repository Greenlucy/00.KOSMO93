package a.b.c.com.common;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class CommonXML {
	
	// file path
	// C:\00.KOSMO93\30.Web\el_web_neon_work\testCss\WebContent\xmlTest
	public static final String XML_FILE_PATH = "C:\\00.KOSMO93\\30.Web\\el_Web_neon_work\\testCss\\WebContent\\xmlTest";
	
	private static final String KOS_URL = "jdbc:oracle:thin:@localhost:1521:orclKOSMO00";
	private static final String KOS_USER = "scott";
	private static final String KOS_PASS = "tiger";
	private static final String KOS_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			Class.forName(CommonXML.KOS_DRIVER);
			conn = DriverManager.getConnection(	 CommonXML.KOS_URL
												,CommonXML.KOS_USER
												,CommonXML.KOS_PASS);
			
		}catch(Exception c){
			System.out.println("드라이버 찾기에 문제가 발생 >>> : " + c);
		}
		return conn;
	}
}
