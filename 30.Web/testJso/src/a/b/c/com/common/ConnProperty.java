package a.b.c.com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class ConnProperty {

	// ��� ���� : 4type thin ����̺� ���
	// �����ͺ��̽� ���� ���� : DataSource ��� �θ���.
	// [25]
	public static final String KOS_URL = "jdbc:oracle:thin:@localhost:1521:orclKOSMO00";
	// [25]
	public static final String KOS_USER = "jso00";
	// [25]
	public static final String KOS_PASS = "jso1234";
	// [23] ��� ���
	public static final String KOS_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	// [20] static�̴ϱ� ConnProperty.getConnection() �Լ� ȣ��
	public static Connection getConnection(){
		
		// [21]
		// ��ü�� �������� ����, �ʱ�ȭ
		Connection conn = null;
		
		try{
			// [22] forName()�Լ� ��� : �޸𸮿� �ø���
			Class.forName(ConnProperty.KOS_DRIVER);
			// [24] ���� conn�� �����ͺ��̽� �����Ͽ� ����
			conn = DriverManager.getConnection(  ConnProperty.KOS_URL
												,ConnProperty.KOS_USER
												,ConnProperty.KOS_PASS);
		}catch(Exception c){
			System.out.println("����̹� ã�⿡ ������ �߻� >>> : " + c);
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
	
	// [38] ConnProperty.conclose() �Լ� ȣ��
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
