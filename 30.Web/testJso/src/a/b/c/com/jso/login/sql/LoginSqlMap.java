package a.b.c.com.jso.login.sql;

public abstract class LoginSqlMap {
	public static String getloginCheckQuery() { 
		
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT 								\n");
		sb.append(" 		COUNT(A. MNUM)	NCNT		\n");
		sb.append(" FROM	MVC_MEMBER	A				\n");
		sb.append(" WHERE	A.DELETEYN		= 'Y'		\n");
		sb.append(" AND		A.MID			= ?			\n");	// placeholder 1
		sb.append(" AND		A.MPW			= ?			\n");	// placeholder 2
		
		return sb.toString();
	}
}
