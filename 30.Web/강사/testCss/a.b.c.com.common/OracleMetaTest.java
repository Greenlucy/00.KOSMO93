package a.b.c.com.common;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleMetaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = null;

		try{
			con = CommonXML.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");

			DatabaseMetaData dm = con.getMetaData();
System.out.print("DatabaseMetaData dm >>> : " + dm + "\n");			
System.out.println("===============================");
			System.out.println("DBMS 이름 : " + dm.getDatabaseProductName());
			System.out.println("DBMS 버전 : " + dm.getDatabaseProductVersion());
			System.out.println("JDBC 드라이버 이름 : " + dm.getDriverName());			

			ResultSetMetaData rsm = rs.getMetaData();
System.out.print("\nResultSetMetaData rsm >>> : " + rsm + "\n");

			int colCount = rsm.getColumnCount();
System.out.println("\nrsm.getColumnCount() >>> : " + colCount + "\n");
			
			for (int i=1; i <= colCount ; i++){
				System.out.print(rsm.getColumnName(i) + "\t");
			}
			
			System.out.println("\n===============================");
			while (rs.next()){
				for (int i=1; i <= colCount ; i++){
					System.out.print(rs.getString(i) + "\t");				
				}
				System.out.println("");
			}	
		}catch (SQLException e){
			System.out.println("e.getMessage() >>> : " + e.getMessage());
		}finally{
			try{
				if (con !=null) con.close();
			}catch (SQLException e2){
				System.out.println("e2.getMessage() >>> : " + e2.getMessage());
			}
		}
	}
}
