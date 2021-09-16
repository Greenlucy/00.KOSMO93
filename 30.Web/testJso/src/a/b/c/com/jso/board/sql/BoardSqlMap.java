package a.b.c.com.jso.board.sql;

public abstract class BoardSqlMap {

	public static String getChabunQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT 												\n");
		sb.append(" 		NVL(MAX(SUBSTR(A.BNUM, -4)), 0) + 1 MAXNUM 	\n");
		sb.append(" FROM 	MVC_BOARD	A								\n");
		
		return sb.toString();
	}
	
	public static String getBoardSelectAllQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT 										\n");
		sb.append(" 		 A.BNUM				BNUM			\n");
		sb.append(" 		,A.BSUBJECT			BSUBJECT		\n");
		sb.append(" 		,A.BWRITER			BWRITER			\n");
		sb.append(" 		,A.BPW				BPW				\n");
		sb.append(" 		,A.BMEMO			BMEMO			\n");
		sb.append(" 		,A.BPHOTO			BPHOTO			\n");
		sb.append(" 		,A.DELETEYN			DELETEYN		\n");
		sb.append(" 		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')	INSERTDATE	\n");
		sb.append(" 		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')	UPDATEDATE	\n");
		sb.append(" FROM	MVC_BOARD		A					\n");
		sb.append(" WHERE	DELETEYN		= 'Y'				\n");
		sb.append(" ORDER BY	1	DESC						\n");
		
		return sb.toString(); 
	}
	
	public static String getBoardSelectQuery(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT 										\n");
		sb.append(" 		 A.BNUM				BNUM			\n");
		sb.append(" 		,A.BSUBJECT			BSUBJECT		\n");
		sb.append(" 		,A.BWRITER			BWRITER			\n");	
		sb.append(" 		,A.BPW				BPW				\n");
		sb.append(" 		,A.BMEMO			BMEMO			\n");
		sb.append(" 		,A.BPHOTO			BPHOTO			\n");
		sb.append(" 		,A.DELETEYN			DELETEYN		\n");
		sb.append(" 		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')		INSERTDATE	\n");
		sb.append(" 		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')		UPDATEDATE	\n");
		sb.append(" FROM	MVC_BOARD	A						\n");
		sb.append(" WHERE	A.DELETEYN		='Y'				\n");
		sb.append(" AND		A.BNUM			= ?					\n");
		sb.append(" ORDER BY	1	DESC						\n");
		
		return sb.toString(); 
	}
	
	// [28]
	public static String getBoardInsertQuery(){
		// [29] StringBuffer 클래스 인스턴스
		StringBuffer sb = new StringBuffer();
		
		// [30] Insert 쿼리문
		sb.append("	INSERT INTO								\n");
		sb.append("			MVC_BOARD						\n");
		sb.append("				(							\n");
		sb.append("					 BNUM					\n");	// 1
		sb.append("					,BSUBJECT				\n");	// 2
		sb.append("					,BWRITER				\n");	// 3
		sb.append("					,BPW					\n");	// 4
		sb.append("					,BMEMO					\n");	// 5
		sb.append("					,BPHOTO					\n");	// 6
		sb.append("					,DELETEYN				\n");	// 7
		sb.append("					,INSERTDATE				\n");	// 8
		sb.append("					,UPDATEDATE				\n");	// 9
		sb.append("				)							\n");
		sb.append("			VALUES							\n");
		sb.append("				(							\n");
		sb.append("					 ?						\n");	// placeholder 1
		sb.append("					,?						\n");	// placeholder 2
		sb.append("					,?						\n");	// placeholder 3
		sb.append("					,?						\n");	// placeholder 4
		sb.append("					,?						\n");	// placeholder 5
		sb.append("					,?						\n");	// placeholder 6
		sb.append("					,'Y'					\n");	
		sb.append("					,SYSDATE				\n");
		sb.append("					,SYSDATE				\n");
		sb.append("				)							\n");
		
		// [31] return 반환
		return sb.toString(); 
	}
	
	public static String getBoardUpdateQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append(" UPDATE									\n");
		sb.append(" 		MVC_BOARD						\n");
		sb.append(" SET										\n");
		sb.append(" 		 BSUBJECT			= ?			\n");
		sb.append(" 		,BMEMO				= ?			\n");
		sb.append(" 		,UPDATEDATE			= SYSDATE	\n");
		sb.append(" WHERE	BNUM 				= ?			\n");
		sb.append(" AND		DELETEYN			= 'Y'		\n");
		
		return sb.toString(); 
	}
	
	public static String getBoardDeleteQuery(){
		StringBuffer sb = new StringBuffer();
		
		sb.append(" UPDATE									\n");
		sb.append(" 		MVC_BOARD						\n");
		sb.append(" SET										\n");		
		sb.append(" 		 UPDATEDATE		= SYSDATE		\n");
		sb.append(" 		,DELETEYN		= 'N'			\n");
		sb.append(" WHERE		BNUM		= ?				\n");	// placeholder 1
		sb.append(" AND		 	DELETEYN	= 'Y'			\n");
		
		return sb.toString(); 
	}
}
