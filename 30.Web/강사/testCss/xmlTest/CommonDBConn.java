package a.b.c.com.common;

import java.sql.Connection;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CommonDBConn {

	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/Oracle11g_orclKOSMO00");
			conn = ds.getConnection();
		}catch(Exception e){
			System.out.println("������ ���̽� Ŀ�ؼ� ���� >>> : " + e.getMessage());
		}
		
		return conn;
	}
}
