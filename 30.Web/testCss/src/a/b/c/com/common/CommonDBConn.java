package a.b.c.com.common;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CommonDBConn {
	public static Connection getConnection() {
		System.out.println("getConnection() 함수 진입 >>> : ");
		Connection conn = null;
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/Oracle11g_orclKOSMO00");
			conn = ds.getConnection();
			System.out.println("ds.getConnection() 완료 >>> : ");
		}catch(Exception e){
			System.out.println("데이터 베이스 커넥션 에러 >>> : " + e.getMessage());
		}
		
		return conn;
	}
}
