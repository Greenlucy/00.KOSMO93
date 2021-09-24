package a.b.c.com.jso.notice.sql;

public abstract class NoticeSqlMap {
	public static String getNoticeChabunQuery() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("	SELECT 		/*+ A SYS_C0011579 */			\n");
		sb.append(" NVL (MAX(SUBSTR(A.NNUM, -4)),0) + 1 MAXNUM	\n");
		sb.append(" FROM 	MVC_NOTICE 	A						\n");
		
		return sb.toString();
	}
	
	public static String getNoticeSelectAllQuery() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT									 \n");
		sb.append(" 		 A.NNUM			NNUM			 \n");
		sb.append(" 		,A.NSUBJECT		NSUBJECT		 \n");
		sb.append(" 		,A.NMEMO		NMEMO			 \n");
		sb.append(" 		,A.NPHOTO		NPHOTO			 \n");
		sb.append(" 		,A.DELETEYN		DELETEYN		 \n");
		sb.append(" 		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')	INSERTDATE	 \n");
		sb.append(" 		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')	UPDATEDATE	 \n");
		sb.append(" FROM	MVC_NOTICE		A				 \n");
		sb.append(" WHERE	DELETEYN 			= 'Y'		 \n");
		sb.append(" ORDER BY	1	DESC					 \n");
		
		return sb.toString();
	}
	
	public static String getNoticeSelectQuery() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT									 \n");
		sb.append(" 		 A.NNUM			NNUM			 \n");
		sb.append(" 		,A.NSUBJECT		NSUBJECT		 \n");
		sb.append(" 		,A.NMEMO		NMEMO			 \n");
		sb.append(" 		,A.NPHOTO		NPHOTO			 \n");
		sb.append(" 		,A.DELETEYN		DELETEYN		 \n");
		sb.append(" 		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')	INSERTDATE	 \n");
		sb.append(" 		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')	UPDATEDATE	 \n");
		sb.append(" FROM	MVC_NOTICE		A				 \n");
		sb.append(" WHERE	DELETEYN 			= 'Y'		 \n");
		sb.append(" AND 	NNUM				= ?			 \n");	// placeholder 1
		
		return sb.toString();
	}
	
	public static String getNoticeInsertQuery() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(" INSERT INTO								\n");
		sb.append(" 		MVC_NOTICE						\n");
		sb.append(" 			(							\n");
		sb.append(" 			 NNUM						\n");	// COLUMN 1
		sb.append(" 			,NSUBJECT					\n");	// COLUMN 2
		sb.append(" 			,NMEMO						\n");	// COLUMN 3
		sb.append(" 			,NPHOTO						\n");	// COLUMN 4
		sb.append(" 			,DELETEYN					\n");	// COLUMN 5
		sb.append(" 			,INSERTDATE					\n");	// COLUMN 6
		sb.append(" 			,UPDATEDATE					\n");	// COLUMN 7
		sb.append(" 			)							\n");
		sb.append(" 		VALUES							\n");
		sb.append(" 			(							\n");
		sb.append(" 			 ?							\n");	// placeholder 1
		sb.append(" 			,?							\n");	// placeholder 2
		sb.append(" 			,?							\n");	// placeholder 3
		sb.append(" 			,?							\n");	// placeholder 4
		sb.append(" 			,'Y'						\n");	
		sb.append(" 			,SYSDATE					\n");	
		sb.append(" 			,SYSDATE					\n");	
		sb.append(" 			)							\n");
		
		return sb.toString();
	}
	
	public static String getNoticeUpdateQuery() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE									 \n");
		sb.append(" 		MVC_NOTICE						 \n");
		sb.append(" SET										 \n");
		sb.append(" 		 NSUBJECT		= ?				 \n");	// placeholder 1
		sb.append(" 		,NMEMO			= ?				 \n");	// placeholder 2
		sb.append(" 		,UPDATEDATE		= SYSDATE		 \n");
		sb.append(" WHERE	DELETEYN		= 'Y'			 \n");
		sb.append(" AND		NNUM			= ?				 \n");	// placeholder 3
		
		return sb.toString();
	}
	
	public static String getNoticeDeleteQuery() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("	UPDATE											 \n");
		sb.append("			MVC_NOTICE								 \n");
		sb.append("	SET												 \n");
		sb.append("			 DELETEYN		= 'N'					 \n");
		sb.append("			,UPDATEDATE		= SYSDATE				 \n");
		sb.append("	WHERE	DELETEYN		= 'Y'					 \n");
		sb.append("	AND		NNUM			= ?						 \n");	// placeholder 1
		
		return sb.toString();
	}
}
