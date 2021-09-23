package a.b.c.com.kosmo.book.sql;

public abstract class BookSqlMap {
	
	// MaxChabun 쿼리 
	public static String getMaxChabunQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT  /*+ INDEX_DESC(SYS_C0011177) */ 			\n");
		sb.append("         NVL(MAX(SUBSTR(A.BNUM, -4)), 0) + 1 MAXNUM	\n");
		sb.append(" FROM    TEST_BOOK A 								\n");	  

		return sb.toString();
	}

	public static String getBookSelectAllQuery(){ 
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      A.BNUM 		BNUM			\n");
		sb.append("		,A.BTITLE 		BTITLE			\n");
		sb.append("		,A.BAUTH 		BAUTH			\n");
	    sb.append("		,A.ISBN   		BISBN			\n");	    
	    sb.append("		,A.BCOMP 		BCOMP			\n");	    
	    sb.append("		,A.BPRICE		BPRICE			\n");	    
	    sb.append("		,A.BQTY 		BQTY			\n");
	    sb.append("		,A.BCOVER   	BCOVER			\n");	    
	    sb.append("		,A.DELETEYN		DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");
	    sb.append("	FROM 								\n");
	    sb.append("		 TEST_BOOK A 					\n");
	    sb.append("	WHERE A.DELETEYN = 'Y'				\n");
	    sb.append("	ORDER BY 1 DESC  					\n");

	    return sb.toString();	  
	}
	
	public static String getBookSelectQuery(){ 
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      A.BNUM 		BNUM			\n");
		sb.append("		,A.BTITLE 		BTITLE			\n");
		sb.append("		,A.BAUTH 		BAUTH			\n");
	    sb.append("		,A.ISBN   		BISBN			\n");	    
	    sb.append("		,A.BCOMP 		BCOMP			\n");	    
	    sb.append("		,A.BPRICE		BPRICE			\n");	    
	    sb.append("		,A.BQTY 		BQTY			\n");
	    sb.append("		,A.BCOVER   	BCOVER			\n");	    
	    sb.append("		,A.DELETEYN		DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");
	    sb.append("	FROM 								\n");
	    sb.append("		 TEST_BOOK A 					\n");
	    sb.append("	WHERE A.DELETEYN = 'Y'				\n");
	    sb.append("	AND   A.BNUM     = ? 				\n");

	    return sb.toString();	  

	}
	
	// 도서 정보 등록
	public static String getBookInsertQuery(){ 
	
		StringBuffer sb = new StringBuffer();			
		sb.append("	INSERT INTO 						\n");	
		sb.append("		TEST_BOOK 				    	\n");
		sb.append("		          (			    		\n");
		sb.append("      			 BNUM 				\n");// COLUMN 1
		sb.append("					,BTITLE 			\n");// COLUMN 2
		sb.append("					,BAUTH 				\n");// COLUMN 3
	    sb.append("					,ISBN   			\n");// COLUMN 4	    
	    sb.append("					,BCOMP 				\n");// COLUMN 5	    
	    sb.append("					,BPRICE				\n");// COLUMN 6    
	    sb.append("					,BQTY 				\n");// COLUMN 7
	    sb.append("					,BCOVER   			\n");// COLUMN 8	    
	    sb.append("					,DELETEYN			\n");// COLUMN 9
	    sb.append("					,INSERTDATE			\n");// COLUMN 10
	    sb.append("					,UPDATEDATE			\n");// COLUMN 11
		sb.append("			      )						\n");
		sb.append("	       VALUES (  					\n");		
		sb.append("     				 ? 				\n"); // placeholder 1
		sb.append("						,? 				\n"); // placeholder 2
	    sb.append("						,?   			\n"); // placeholder 3
	    sb.append("						,?   			\n"); // placeholder 4
	    sb.append("						,? 				\n"); // placeholder 5
	    sb.append("						,? 				\n"); // placeholder 6
	    sb.append("						,?				\n"); // placeholder 7
	    sb.append("						,?				\n"); // placeholder 8
	    sb.append("						,'Y'			\n"); // placeholder 9
	    sb.append("						,SYSDATE 		\n"); // placeholder 10
	    sb.append("						,SYSDATE 		\n"); // placeholder 11	
		sb.append("	              )						\n");		
		
		return sb.toString();
	}
	
	public static String getBookUpdateQuery(){ 
	
		StringBuffer sb = new StringBuffer();	
		sb.append("	UPDATE  							\n");	
		sb.append("		   	 TEST_BOOK 			    	\n");	
		sb.append("	SET  								\n");		
		sb.append("			 BPRICE 		= ?			\n");	    	    
		sb.append("			,BQTY			= ?			\n");	    
	    sb.append("		  	,UPDATEDATE 	= SYSDATE	\n");
		sb.append("	WHERE  	 BNUM 			= ?			\n");	    
		sb.append("	AND    	 DELETEYN 		= 'Y'  		\n");	
		
		return sb.toString();
		
	}
	
	
	public static String getBookDeleteQuery(){ 
	
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  							\n");	
		sb.append("		   TEST_BOOK 			    	\n");	
		sb.append("	SET  								\n");
	    sb.append("		   DELETEYN 	= 'N'			\n");	    	   
	    sb.append("		  ,UPDATEDATE 	= SYSDATE		\n");
		sb.append("	WHERE  BNUM 		= ?				\n");	    
		sb.append("	AND    DELETEYN 	= 'Y'  			\n");	
		
		return sb.toString();
	}
}
