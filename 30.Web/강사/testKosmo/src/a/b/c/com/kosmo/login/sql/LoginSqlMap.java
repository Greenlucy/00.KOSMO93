package a.b.c.com.kosmo.login.sql;

public abstract class LoginSqlMap {
	
	public static String getLoginCheckCntQuery(){
		
		// �α��� Ȯ��					
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("       COUNT(A.MNUM)  NCNT 			\n");		
	    sb.append("	FROM 								\n");	    
	    sb.append("		  MVC_MEMBER 	A 				\n");
	    sb.append("	WHERE A.DELETEYN 	= 'Y'			\n");	    
	    sb.append("	AND   A.MID 	  	= ?				\n");
	    sb.append("	AND   A.MPW  		= ?   			\n");

	    return sb.toString();		
	}
}
